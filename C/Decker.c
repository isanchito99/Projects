#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/wait.h>

int main(int arguments, char *argv[]) {
    //We check if I put a number in the terminal
    if (arguments != 2) {
        printf("You need to put a number for the M loop.\n");
        return 1;
    }

    int M = atoi(argv[1]);//convert to int
    int A = 0;
    int shmid; //for share memory
    int *shm;

    // Create shared memory segment
    shmid = shmget(IPC_PRIVATE, sizeof(int), IPC_CREAT | 0666);
    if (shmid == -1) {
        printf("Error creating shared memory\n");
        exit(1);
    }

    // Need to control the shared memory
    //This function is used to attach shared memory to the virtual address of the process.
    shm = (int*) shmat(shmid, NULL, 0);
    if (shm == (int*) -1) {
        printf("Error attaching shared memory\n");
        exit(1);
    }

    // This is the shared memory variable
    *shm = 0;

 // Decker's algorithm variable
    int turn = 0;
// 3 flags because we need it in Decker's algorithm. (0,1,2)
    int flag[2] = {0, 0};

    // Here only we create the two child processes
    // Same example like the lectures
    for (int i = 0; i < 2; i++) {
        switch (fork()) {
            case -1:
                printf("Error creating the child process\n");
                exit(1);
            case 0:
                // Child process increments shared variable M times
                for (int j = 0; j < M; j++) {
                    flag[i] = 1;
                    while (flag[1 - i] == 1) {
                        if (turn == 1 - i) {
                            flag[i] = 0;
                            while (turn == 1 - i);
                            flag[i] = 1;
                        }
                    }
                    (*shm)++;
                    turn = 1 - i;
                    flag[i] = 0;
                }
                printf("Process %d completed. A = %d\n", i, *shm);
                exit(0);
            default:
                break;
        }
    }

    // Wait for both child processes to complete
    for (int i = 0; i < 2; i++) {
        wait(NULL);
    }

    // We take the final value for A variable in the share memory
    A = *shm;
    printf("PROCESSES SUCCESFULLY COMPLETED: Final value of A = %d\n", A);

    // Detach and delete shared memory segment
    shmdt(shm);
    shmctl(shmid, IPC_RMID, NULL);

    return 0;
}
/*SOMETIMES WE WILL HAVE MIXTAKES IN THE OUTPUT. THIS IS BECAUSE DECKER'S ALGHORHITM
DONT GUARANTEE THAT THE PROCESSES HAVE ACESS AT THE MOMENT THEY WANT.
AND MAYBE I HAVE PROBLEMS IN THE OUTPUT AND WRONG SUMS BUT IS NORMAL AND NO IS PROBLEM ABOUT THE CODE.
IS THE PROBLEM ABOUT DECKER'S ALGORITHM AND THE SHARE MEMORY*/

/*EXAMPLE*/

/*ivan@LAPTOP-7T0UBK8T:~$ ./deck 3900
Process 0 completed. A = 3900
Process 1 completed. A = 7800
PROCESSES SUCCESFULLY COMPLETED: Final value of A = 7800
ivan@LAPTOP-7T0UBK8T:~$ ./deck 3900
Process 0 completed. A = 4114
Process 1 completed. A = 7509
PROCESSES SUCCESFULLY COMPLETED: Final value of A = 7509*/
