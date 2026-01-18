#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <math.h>


int main()
{
    int size = 4;
	double x = pow(2,size);;
	int xx = x;
    int convert;
	int array[xx][size];/*= {{0,0,0,0},
							{0,0,0,0},
							{0,0,0,0},
							{0,0,0,0},
							{0,0,0,0},
							{0,0,0,0},
							{0,0,0,0},
							{0,0,0,0}};
								*/
	

	for (int a=0; a<size; a++)
	{
        int val=0;
		convert=pow(2,a);
		for (int b=0; b<x; b++)
		{
			if (convert > 0)
				array[b][a] = val;
			else
			{
			    if (val==0)
			           val=1;
                else 
                       val=0;
				convert=pow(2,a);
				array[b][a] = val;
			}
			convert--;

		}
		printf("\n");
	}


	for (int y=0; y<x; y++)
	{
		for (int z=0; z<size; z++)
		{
			printf("%d ", array[y][z]);
		}
		printf("\n");
	}

for (int d=2; d>=0; d--)
    	{
    	    printf("\nsssss");
 }   		
	getch();
}
