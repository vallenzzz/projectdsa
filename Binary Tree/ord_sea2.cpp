#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

ord_search(int[],int,int);
void display(int[], int);

main()
{
	int list[]={2,8,10,15,55,70,93};
	int last = 6;
	int key, found;

	printf("Enter search key ");
	scanf("%d", &key);

	ord_search(list, key, last);


}

ord_search(int list[], int key, int last)
{
	int i;

	for(i=last; i>=0; i--)
	{
		printf("Comparing... %d ...%d\n",key, list[i]);
		if (key == list[i])
		{
			printf("Found key is %d", list[i]);
			return 0;
		}
		else if (key > list[i])
		{
			printf("No search key found!");
         return 0;
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
