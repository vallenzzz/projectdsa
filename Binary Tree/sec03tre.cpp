#include <stdio.h>
#include <stdlib.h>

typedef struct nod
{
	int data;
	struct nod *left;
	struct nod *right;
}TREE;

TREE*SEARCH(TREE*,int);
void INSERT(TREE*,int);
void INORDER();
void MENU();

main()
{
	int key;
	TREE*node=NULL;
	TREE*T;
	int choice;

	while(choice != 0)
	{
		MENU();

		switch(choice)
		{
			case 1: 	printf("Enter key to be searched :");
						scanf("%d",&key);
						T=SEARCH(node, key);

						if (T != NULL)
							printf("..... is %d", T->data);
						else
							printf("Tak dok");

						break;

			case 2:  printf("Enter key to be inserted :");
						scanf("%d",&key);

						INSERT(node, key);
						printf("Berjaya");
						break;

		}
	}
}

TREE*SEARCH(TREE*node, int key)
{
	if (node)
		if (key == node->data)
			return node;
		else if (key < node->data)
			SEARCH(node->left, key);
		else
			SEARCH(node->right, key);
	else
		return NULL;
}

void INSERT(TREE*node, int key)
{

}