#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <signal.h>
#include <time.h>
#include <stdlib.h>
#include <time.h>
#include <ctype.h>
#include <math.h>
#include <unistd.h>

#define LEFT 0
#define RIGHT 1
#define MISSIONARIES 0
#define CANNIBALS 1
#define EMPTY 0
#define FULL 1
#define NAVIGATION 2

int flag = 0; //initialite to 0,
int B_P;//BOAT POSITION:is the position of the boat, is a flag, will be RIGHT or lEFT
int E_B = 1; //EMPTY BOAT:empty=0, no empty=1.
int boatMissionaries = 0;// is the number of missionaries in the boat
int boatCannibals = 0;//is the number of cannibals in the boat
int BeachMissionaries[2] = {0};//represent the missionaries in both beach.
int BeachCannibals[2] = {0};//represent the cannibals and cannibals in both beach.
//These variables and pthreads  set up tje necessary structures to coordinate the
// actions of the threads and control the code with monitors
pthread_cond_t condition[2][2];//is an array bidimensional. Stores only 2 conditions (LEFT and RIGHT)
pthread_cond_t boat[3];
pthread_mutex_t lock;//for provide mutual exclusion.
pthread_t thread[4];
int thread_counter = 2; //is the number of active threads in the program. Is used before exiting the program
//THIS FUNCTION PRINTS A MESSAGE WHEN A MISSIONAIRE OR CANNIBAL ARRIVES THE BEACH
void created(int person, int beach)
{
    if (person == MISSIONARIES)
    {
//MISSIONARIES CREATED
        if (beach == LEFT)
            printf("M%d: arrived on left beach\n", BeachMissionaries[beach]);
        else
            printf("M%d: arrived on right beach\n", BeachMissionaries[beach]);
    }
    else
    {
//CANNIBALS CREATED
        if (beach == RIGHT)
            printf("C%d: arrived on right beach\n", BeachCannibals[beach]);
        else
            printf("C%d: arrived on left beach\n", BeachCannibals[beach]);
    }
}
//MISSIONARY CLASS WHEN A NEW THREAD IS CREATED. X=LEFT OR RIGHT
void *Missionary(void *x)
{
    int beach = 0; //Stores beach location
    int peopleBoat = 0; //counter for how many peopleBoat the boat
    beach = *((int *)x);
    pthread_mutex_lock(&lock); //monitor: exclusive access
    BeachMissionaries[beach]++;
    created(MISSIONARIES, beach);//print the message
    while (peopleBoat == 0)
    {
        //condition when missionaries can enter the boat
        if (B_P == beach && (boatCannibals + boatMissionaries) < 7 && boatCannibals <= (boatMissionaries + 1))
        {
            boatMissionaries++;
            BeachMissionaries[beach]--;
            peopleBoat = 1;
            printf("M%d: enter in the boat\n", boatMissionaries);

            if ((boatMissionaries + boatCannibals) == 3)
            {
                pthread_cond_signal(&boat[FULL]);
                printf("B: boat meets the conditions to leave for the other beach.-------------------->\n");
                sleep(1);
            }
            if ((boatMissionaries + boatCannibals) < 7 && BeachCannibals[beach] > 0)
                pthread_cond_signal(&condition[beach][CANNIBALS]);
        }
        else
        {
            pthread_cond_wait(&condition[beach][MISSIONARIES], &lock);//condition wait
        }
    }

    pthread_cond_wait(&boat[NAVIGATION], &lock); //condition wait
    boatMissionaries--; //
    printf("M: Missionaries are getting off the boat\n");

    if ((boatCannibals + boatMissionaries) == 0)
    {
        printf("B: empty on %s beach\n", B_P == LEFT ? "left" : "right"); //print if boat is empty in left or right
        pthread_cond_signal(&boat[EMPTY]);//condition signal
    }
    pthread_mutex_unlock(&lock);//unlock
    pthread_join(thread[3], NULL);
    return 0;
}

void *cannibal(void *x)
{
    int beach, peopleBoat = 0;
    beach = *((int *)x);
    pthread_mutex_lock(&lock);
    BeachCannibals[beach]++;
    created(CANNIBALS, beach);
    while (peopleBoat == 0)
    {
        if (beach == B_P && (boatCannibals + boatMissionaries) < 7 && (boatCannibals + 1) <= boatMissionaries)
        {
            boatCannibals++;
            BeachCannibals[beach]--;
            peopleBoat = 1;
            printf("C%d: enter in the boat\n", boatCannibals);

            if ((boatCannibals + boatMissionaries) == 3)
            {
                pthread_cond_signal(&boat[FULL]);
                printf("B: boat meets the conditions to leave for the other beach.-------------------->\n");
                sleep(1);
            }
            if ((boatMissionaries + boatCannibals) < 7 && BeachMissionaries[beach] > 0)
                pthread_cond_signal(&condition[beach][MISSIONARIES]);
        }
        else
        {
            pthread_cond_wait(&condition[beach][CANNIBALS], &lock);
        }
    }

    pthread_cond_wait(&boat[NAVIGATION], &lock);

    boatCannibals--;
    printf("C: passengers are getting off the boat\n");

    if ((boatCannibals + boatMissionaries) == 0)
    {
        printf("B: empty on %s beach\n", B_P == LEFT ? "left" : "right");
        pthread_cond_signal(&boat[EMPTY]);
    }
    pthread_mutex_unlock(&lock);
    pthread_join(thread[2], NULL);
    return 0;
}

void *passengers()
{
    int i;
    while (1)
    {
        while (flag == 1)
            ;
        i = rand() % 2;// This random number is used to determine the beach location (LEFT or RIGHT) where the passengers will be created.
        if (pthread_create(&thread[2], NULL, cannibal, (void *)&i) != 0) //thread create for cannibal and passing id
            exit(0);

        sleep(1);

        i = rand() % 2;
        if (pthread_create(&thread[3], NULL, Missionary, (void *)&i) != 0)//thread create for Missionary and passing id
            exit(0);

        i = rand() % 2;
        if (pthread_create(&thread[2], NULL, cannibal, (void *)&i) != 0)//thread create for cannibal and passing id
            exit(0);

        sleep(1);
    }
}

void *travel()
{
    // Initial boat position to RIGHT
    B_P = RIGHT;
    pthread_mutex_lock(&lock);
    while (1)
    {
        // Wait until the boat is full to travel (full=loaded)
        pthread_cond_wait(&boat[FULL], &lock);

        // flag=1, boat is going to the other beach
        flag = 1;
        sleep(1);

        // Print the people in the boat and the direction
        printf("B: transporting from %s beach to %s: ", B_P == LEFT ? "left" : "right", B_P == LEFT ? "right" : "left");
        for (int i = 1; i <= boatCannibals; i++)
            printf("C%d ", i);
        for (int i = 1; i <= boatMissionaries; i++)
            printf("M%d ", i);
        printf("\n");
        sleep(1);

        // Change the boat's position to the opposite
        B_P = abs(1 - B_P);
        // Signal all the passengerss
        pthread_cond_broadcast(&boat[NAVIGATION]);
        // Wait in the boat because people is desambarking
        pthread_cond_wait(&boat[EMPTY], &lock);
        // flag=0 boat is ready for new travel
        flag = 0;
        // Wait until the boat is empty
        while ((boatCannibals + boatMissionaries) != 0)
            ;

        // Signal all the waiting passengers on the current beach that they can proceed
        pthread_cond_broadcast(&condition[B_P][MISSIONARIES]);
        pthread_cond_broadcast(&condition[B_P][CANNIBALS]);
    }
    pthread_mutex_unlock(&lock);
    return 0;
}

int main()
{
    srand(time(NULL));

    // Initialize the mutex and condition variables
    pthread_mutex_init(&lock, NULL);
    for (int i = 0; i < 2; i++)
    {
        pthread_cond_init(&condition[i][MISSIONARIES], NULL);
        pthread_cond_init(&condition[i][CANNIBALS], NULL);
    }
    for (int i = 0; i < 3; i++)
        pthread_cond_init(&boat[i], NULL);

    // Create threads for travel() and the passengers() function
    pthread_create(&thread[0], NULL, travel, NULL);
    pthread_create(&thread[1], NULL, passengers, NULL);

    // Wait for all the threads to finish
    for (int i = 0; i < thread_counter; i++)
        pthread_join(thread[i], NULL);

    return 0;
}