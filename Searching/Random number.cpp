//Generate random number
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>

void main()
{
	int range, max,min,num_rand;

   printf("\nHow many random number you want to generate?:");
   scanf("%d",&num_rand);
   printf("\nEnter the maximum value for your random number:");
   scanf("%d",&max);
   printf("\nEnter the minimum value for your random number:");
   scanf("%d",&min);

   srand(time(NULL));
   range = (max-min)+1;


   for (int i = 0; i<num_rand;i++)
   {printf(" %d", rand()%range +10);
   }



	getch();
}



