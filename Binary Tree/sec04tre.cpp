#include <stdio.h>
#include <stdlib.h>

typedef struct nod
{
	int data;
	struct nod *left;
	struct nod *right;
}TREE;

TREE*SEARCH(TREE*,int);
INSERT();
DISPLAY();

main()
{
	TREE*node=NULL;
	TREE*T;
	int key;
	int choice;

	w'hile (choice != 0)
	{
		printf("\n1>Search");
		printf("\n2>Insert");
		printf("\n3>Display");
		printf("\n0>Exit");

		printf("\nInsert choice : ");
		scanf("%d",&choice);

		switch (choice)
		{
			case 1:	printf("\nSEARCH");
						printf("Insert search key : ");
						scanf("%d", &key);
						T=SEARCH(node,key);

						if (T!=NULL)
							printf("jupe...%d",T->data);
						else
							printf("tok jupe...");

						break;
		}
	}
}

TREE*SEARCH(TREE*node,int key)
{
	if(node)
	{
		if(key==node->data)
			return node;

		else if (key<node->data)
			return SEARCH(node->left,key);

		else
			return SEARCH(node->right,key);
	}
	else
		return NULL;
}