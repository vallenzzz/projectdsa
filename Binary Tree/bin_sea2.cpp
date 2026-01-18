#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<string.h>
#include<stdio.h>

bin_search(int[],int,int,int);
void display(int[],int,int);

main()
{
	int list[]={2,5,8,10,11,15,55,60,70,77,93};
	int first = 0;
	int last = sizeof(list)/2;
	//printf("%d\n", last);
	int key, found;

	printf("Enter search key ");
	scanf("%d", &key);

	bin_search(list, key, first, last);


}

bin_search(int list[], int key, int first, int last)
{
	int i, middle_elem;

	i = last - first;

	while (i>=0)
	{
		display(list, first, last);
		middle_elem = (first + last)/2;

		printf("\nComparing... %d ...%d\n",key, list[middle_elem]);
		if (key == list[middle_elem])
		{
			printf("Found key is %d", list[middle_elem]);
			return 0;
		}

		else if (key < list[middle_elem])
		{
			printf("\nLOWER >>>");
			last = middle_elem - 1;
		}

		else if (key > list[middle_elem])
		{
			printf("\nUPPER >>>");
			first = middle_elem + 1;
		}
		i = last - first;
	}
	printf("No search key found!");
}

void display(int list[], int first, int last)
{
	int x;

	for(x=first; x<=last; x++)
		printf("%d\t", list[x]);
}
