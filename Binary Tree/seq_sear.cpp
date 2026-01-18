#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

seq_search(int[],int,int);
void display(int[], int);

main()
{
	int list[]={15,8,70,10,2,55,93};
	int last = sizeof(list)/2;
	int key, found;

	printf("Enter search key");
	scanf("%d", &key);

	seq_search(list, key, last);


}

seq_search(int list[], int key, int last)
{
	int i=0;

	while(i <= last)
	{
		printf("Comparing... %d ...%d\n",key, list[i]);
		if (key == list[i])
			{
				printf("Found key is %d", list[i]);
				return 0;
			}
		i++;
	}
	printf("No key found!");
}

void display(int list[], int last)
{
	int x;

	for(x=0; x<last; x++)
		printf("%d", list[x]);
}
