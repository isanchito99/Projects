#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
//SHARE MEMORY LIBRARIES
#include <sys/shm.h>
#include <sys/wait.h>

#define SHM_SIZE sizeof(int)

int *FINAL_VALUE; //Final Value
//Both variables for enter in the share memory
int *NUM;
int *ENTER;
int LAST_NUM = 0; //For Lamport's

//this is the loop function, I incr_function in a loop the M parameter
void *incr_function(void *arg){
    int i, j;
    int *pN = (int *) arg;
    for(i=0;i<*pN;i++){
//all of this is like the professor slides for control de C.S with Lamport's algorithm
        ENTER[i] = 1;
        NUM[i] = LAST_NUM + 1;
        LAST_NUM = NUM[i];
        ENTER[i] = 0;
        for(j=0;j<*pN;j++){
            while(ENTER[j] == 1);
            while((NUM[j] != 0) && ((NUM[j] < NUM[i]) || ((NUM[j] == NUM[i]) && (j < i))));
        }
        // C.S
        *FINAL_VALUE += 1;
        NUM[i] = 0;
        //N.C.S
    }
    pthread_exit(NULL);
}

int main(int arguments, char *argv[]) {
    if(arguments < 3){
        printf("You need to put the N parameter and the M parameter (loops) \n");
        return 0;
    }
    int N = atoi(argv[1]);
    int M = atoi(argv[2]);
//share memory id variable
    int shmid;
    key_t key = 1234;
//Creation of the share memory size
    if ((shmid = shmget(key, SHM_SIZE, 0666 | IPC_CREAT)) < 0) {
        perror("shmget");
        exit(1);
    }
//this is for try to acess the share memory
    if ((FINAL_VALUE = shmat(shmid, NULL, 0)) == (int *) -1) {
        perror("shmat");
        exit(1);
    }
//restar of A value
    *FINAL_VALUE = 0;
//Dinamic memory
    int size = N;
    NUM = (int*) malloc(size * sizeof(int));
    ENTER = (int*) malloc(N * sizeof(int));

//Here I will create the threads, I create N threads and it incr_functions M times in the loop (incr_function function)
    pthread_t threads[N];
    int i;
    int args[N];
    for(i=0;i<N;i++){
        args[i] = M;
        if(pthread_create(&threads[i],NULL,incr_function,&args[i])){
            printf("Error creating the thread\n");
            return 1;
        }
    }
//Wait for finish the threads
    for(i=0;i<N;i++)
        pthread_join(threads[i],NULL);
//Print of the final value
    printf("THE FINAL VALUE IS: %d\n",*FINAL_VALUE);

//for clean only the share memory afther the execution
    if (shmdt(FINAL_VALUE) == -1) {
        perror("shmdt");
        exit(1);
    }

    if (shmctl(shmid, IPC_RMID, NULL) == -1) {
        perror("shmctl");
        exit(1);
    }
    free(NUM);
    free(ENTER);
    return 0;
}
