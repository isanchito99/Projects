#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>
#include <time.h>
#include <semaphore.h>

#define MAX_CHAIRS 5
#define MAX_CUSTOMERS 25

int shmid; // shared memory ID
int remaining_customers = MAX_CUSTOMERS; // remaining customers to be served
int served_customers = 0; // number of customers with a haircut
// structure for shared memory
struct shmem {
    int num_waiting; // number of customers waiting
    int barber_sleeping; // flag to indicate if the barber is sleeping
    int next_customer; // index of next customer to be served
    int haircut_done[MAX_CUSTOMERS]; // flag to indicate if the customer's haircut is done
} *shm;

sem_t *B_S;
sem_t *C_S;

void barber() {
    while (1) {
        // check if there are customers waiting
        if (shm->num_waiting == 0) {
            // barber goes to sleep
            printf("Barber is sleeping because the SALON is empty...\n");
            shm->barber_sleeping = 1;
             // wait for a customer to arrive
            shm->barber_sleeping = 0;
        }
        sem_post(C_S);

        // serve next customer
        int customer_index = shm->next_customer;
        if (shm->haircut_done[customer_index] == 1) {
            // customer's haircut is already done, skip
            shm->next_customer = (shm->next_customer + 1) % MAX_CUSTOMERS;
            continue;
        }
        sem_wait(B_S);
        printf("Barber is serving customer %d...\n", customer_index);
        shm->num_waiting--;
        shm->next_customer = (shm->next_customer + 1) % MAX_CUSTOMERS;
        sleep(2); // haircut takes some time
        printf("BARBER finish a haircut. Customer %d has his new haircut.\n", customer_index);
        shm->haircut_done[customer_index] = 1; // mark customer's haircut as done
        sem_post(C_S); // signal customer that the haircut is finished

        remaining_customers--;
        // served_customers++;

        // check if the barber has served 25 customers
        if (remaining_customers == 0) {
            printf("Barber cuts more than 25 hairs. Their working day has come to an end.\n");
            printf("Barber closes the shop.\n");
            exit(0);
        }
    }
}

void customer(int index) {
    // check if there are empty seats in the waiting room
    if (shm->num_waiting < MAX_CHAIRS && remaining_customers > 0) {
        // take a seat and wait for the barber
        sem_wait(C_S);
        printf("Customer %d is waiting...\n", index);

        shm->num_waiting++;
        sem_post(B_S); // signal barber that a customer has arrived
        sem_wait(C_S); // wait for the barber to finish the haircut
    } else {
        // no empty seats or no remaining customers, leave without a haircut
        printf("SALON IS FULL. Customer %d has left without a haircut.\n", index);
    }
}

int main() {
    // create shared memory
    shmid = shmget(IPC_PRIVATE, sizeof(struct shmem), IPC_CREAT | 0666);
    shm = shmat(shmid, NULL, 0);
// initialise shared memory
shm->num_waiting = 0;
shm->barber_sleeping = 0;
shm->next_customer = 0;
for (int i = 0; i < MAX_CUSTOMERS; i++) {
    shm->haircut_done[i] = 0; // initialize all customers' haircut status as not done
}
//BARBER SEMAPHORE INITIALITE
int BS_id = shmget(IPC_PRIVATE, sizeof(sem_t),0600);
    if(BS_id == -1)exit(1);
    B_S = shmat(BS_id, NULL, 0); //BARBER SEMAPHORE
    shmctl(BS_id, IPC_RMID, NULL);
    sem_init(B_S, 1, 0);
//CUSTOMER SEMAPHORE INITIALITE
    int CS_id = shmget(IPC_PRIVATE, sizeof(sem_t),0600);
    if(CS_id == -1)exit(1);
    C_S = shmat(CS_id, NULL, 0);
    shmctl(CS_id, IPC_RMID, NULL);
    sem_init(C_S, 1, 0);

// create barber process
pid_t pid = fork();
if (pid == 0) {
    barber();
    exit(0);
}

// create customer processes
srand(time(NULL)); // seed the random number generator
int i = 0;
while (remaining_customers > 0) {
    int delay = rand() % 3 + 1; // random delay between 1 and 3 seconds
    sleep(delay);
    pid_t pid = fork();
    if (pid == 0) {
        customer(i);
        exit(0);
    }
    i++;
    remaining_customers--;
}
// wait for all child processes to finish
for (int i = 0; i < MAX_CUSTOMERS + 1; i++) {
    wait(NULL);
}
// clean up shared memory and semaphores
shmdt(shm);
shmctl(shmid, IPC_RMID, NULL);
sem_destroy(B_S);
sem_destroy(C_S);
free(B_S);
free(C_S);

return 0;
}