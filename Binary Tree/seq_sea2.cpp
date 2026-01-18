#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

bin_search(int[],int,int,int);
void display(int[], int);

main()
{
	int list[]={3,23,45,50,57,89,99,101,120,202};
	int first = 0;
	int last = 9;
	int key;

	printf("Enter search key ");
	scanf("%d", &key);

	bin_search(list, key, first, last);
}

bin_search(int list[], int key, int first, int last)
{
	int i;
	int mid_elem;

	mid_elem = (first+last)/2;

	loop....
	{
		printf("Comparing... %d ...%d\n",key, list[i]);
		if (key == list[mid_elem])
			{
				printf("Found key is %d", i);
				return 0;
			}
		else if (key < list[mid_elem])
		{
				last = mid_elem - 1;
				//return 0;
		}
		else if (key > list[mid_elem])
		{
				first = mid_elem + 1;
				//return 0;
		}
		//i++;
	}
	printf("No search key found!");
}

void display(int list[], int last)
{
	int x;

	for(x=0; x<last; x++)
		printf("%d", list[x]);
}
