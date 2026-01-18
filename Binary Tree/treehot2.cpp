#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <math.h>

int count=0;
																				//
typedef int eltype ;
struct node_rec
{
	eltype key;
	char name[10];                                           //
	struct node_rec *left, *right;
};
typedef struct node_rec *tree_type;

//prototype fungsi
tree_type SEARCH(tree_type node, eltype key);
void INSERT(tree_type *root_addr, eltype key, char[]);
void TREE_ORDER (tree_type node,int);
void GEN_NUM (tree_type node, int);
void MERGE(tree_type *node);
void DELETE(tree_type *root_addr, eltype key);
void copy (tree_type *node);
void DELETE1(tree_type *root_addr, eltype key);
void menu();
//void GEN_MATRIX (int[16][4]);

main()
{
	eltype element;
	tree_type node=NULL, T;
	int choice, GenNum;
	double test;

	INSERT(&node, 50, "wazi");                                //
	INSERT(&node, 40, "abun");                                //
	INSERT(&node, 92, "zaki");
	INSERT(&node, 30, "mira");
	INSERT(&node, 48, "wati");
	INSERT(&node, 81, "aman");
	INSERT(&node, 99, "niza");
	INSERT(&node, 20, "asan");
	INSERT(&node, 46, "bada");
	INSERT(&node, 49, "azri");
	INSERT(&node, 89, "yati");
	INSERT(&node, 97, "razi");
	INSERT(&node, 10, "rozi");
	INSERT(&node, 44, "emie");
	INSERT(&node, 47, "atie");
	INSERT(&node, 85, "wafi");


	while (choice != 7)
	{
		menu();
		printf("\nEnter the instruction code :");
		scanf("\t%d", &choice);

		switch (choice)
		{
			case 1: count=0;
					  printf ("\n Search");
					  printf("\nEnter a key : ");
					  scanf("\t%d", &element);
					  T = SEARCH (node,element);
					  if (T != NULL)
					  {
							printf ("\n\n\nID Number \t\t: %d",T->key);
							printf ("\nName \t\t\t: %s",T->name);
							printf ("\nNumber of Generation \t: %d",count);
					  }
					  else
							printf ("\nThe key %c is not found!",element);
					  break;

			case 2: printf ("\n Insert");
					  printf("\nEnter a key : ");
					  scanf("\t%d", &element);
					  T = SEARCH (node,element);
					  if (T != NULL)
							printf ("\n The key %d is already in the tree. Insertion unsuccessful!",element);
					  else
					  {
							//INSERT(&node, element);
							printf ("\n Insertion was successful!");
					  }

					  break;

			case 3: printf ("\n Delete BY COPY");
					  printf("\nEnter a key : ");
					  scanf("\t%d", &element);
					  T = SEARCH (node,element);
					  if (T != NULL)
					  {
							DELETE(&node, element);
							printf ("\n Deletion was successful!");
					  }
					  else
							printf ("\n The key %d is not in the tree. Deletion unsuccessful!",element);

					  break;

			case 4: printf ("\n Delete BY MERGE");
					  printf("\nEnter a key : ");
					  scanf("\t%d", &element);
					  T = SEARCH (node,element);
					  if (T != NULL)
					  {
							DELETE1(&node, element);
							printf ("\n Deletion was successful!");
					  }
					  else
							printf ("\n The key %d is not in the tree. Deletion unsuccessful!",element);

					  break;

			case 5: printf ("\n Display the Family's Tree\n\n");
					  TREE_ORDER(node,0);
					  break;

			case 6: printf ("\n Display a list of person in the generation\n\n");
					  printf("\nEnter the number of Generation : ");
					  scanf("\t%d", &GenNum);
					  GEN_NUM(node,GenNum-1);
					  break;

		 }//case
	}//while
}

void menu()
{
	printf("\n------------------------------------------");
	printf("\n\n MENU ");
	printf("\n 1: Search for person (with the number of generation)");
	printf("\n 2: New Born (Insert)");
	printf("\n 3: Passed Away (Delete by COPY)");
	printf("\n 4: Passed Away (Delete by MERGE)");
	printf("\n 5: Display the Family's Tree");
	printf("\n 6: Display a list of person in the generation");
	printf("\n 7: Quit");
	printf("\n\n------------------------------------------\n\n");

}

tree_type SEARCH(tree_type node, eltype key)
{
	if (node)
	{
		printf("\nComparing ...%d...%d",key,node->key);      //
		if (key == node->key)
		{
			  count++;
			  return node;
		}
		else if (key < node->key)
		{
			  printf("\nGo to left child...");
			  count++;
			  return SEARCH (node->left, key);
		}
		else
		{
			  printf("\nGo to right child...");
			  count++;
			  return SEARCH (node->right, key);
		}
	}
	else return NULL;
}

void INSERT(tree_type *root_addr, eltype key, char name[])
{
	tree_type p, previous = NULL, newnode;

	newnode = (struct node_rec*) malloc (sizeof(struct node_rec));
	newnode->left = newnode->right = NULL;
	newnode->key = key;
	strcpy(newnode->name,name);                 //

	p = *root_addr;
	while (p)
	{
		previous = p;
		if (p->key > key)
			p = p->left;
		else
			p = p->right;
	}

	if (!*root_addr)
		*root_addr = newnode;
	else if (previous->key > key)
		previous->left = newnode;
	else
		previous->right = newnode;
}

void GEN_NUM (tree_type node, int GenNum)
{
    tree_type p = node;
	double x = pow(2,GenNum);;
	int xx = x;
    int convert;
	int array[xx][GenNum];
	
	for (int a=0; a<GenNum; a++)
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
//		printf("\n");
	}

	for (int y=0; y<x; y++)
	{
		for (int z=0; z<GenNum; z++)
		{
//			printf("%d ", array[y][z]);
		}
//		printf("\n");
	}
    
//==================================================================
    
    for (int c=0; c<x; c++)
    {	
        p = node;
        for (int d=GenNum-1; d>=-1; d--)
    	{
    		if(p)
    		{
    		   if (array[c][d] == 0)
    		   {
//                  printf("%d %s LEFT >> ...\n", p->key, p->name);
               if (d<0)
                  printf("\n\n>>>> %d %s\n\n", p->key, p->name);   
                  p = p->left;
 		       }    
               else
               {
//                  printf("%d %s RIGHT >> ...\n", p->key, p->name);
               if (d<0)
                  printf("\n\n>>>> %d %s\n\n", p->key, p->name);   
                  p = p->right;
               } 
            }
            else
               break;
        }
     }    
}

void TREE_ORDER (tree_type node,int count)
{
	if (node)
	{
		printf (" --- (%d) %s",node->key, node->name);   //
		count++;
		TREE_ORDER(node->right,count);
		if (node->left)
			printf("\n");

		for(int x=0; x<count; x++)
			if (node->left)
				printf("              ");         //
		TREE_ORDER(node->left,count);
	}
}

void MERGE(tree_type *node)
{
	tree_type tmp = *node;

	if (*node)
	{
		if (!(*node)->right)
			*node = (*node)->left;
		else if (!(*node)->left)
			*node = (*node)->right;
		else
		{
			tmp = (*node)->left;
			while (tmp->right)
				tmp = tmp->right;

			tmp->right = (*node)->right;
			tmp = *node;
			*node = (*node)->left;
		}
		free(tmp);
	}
}


void DELETE1(tree_type *root_addr, eltype key)
{
	tree_type node = *root_addr, previous = NULL;

	while (node)
	{
		if (node->key == key)
			break;

		previous = node;

		if (node->key > key)
			node = node->left;
		else
			node = node->right;
	}
	if (node->key == key)
		if (node == *root_addr)
			MERGE(root_addr);
		else if (previous->left == node)
			MERGE(&previous->left);
		else
			MERGE(&previous->right);
	else if (*root_addr)
		printf ("\nkey &c is not in the tree");
	else
		printf ("\n the tree is empty");

}


void DELETE(tree_type *root_addr, eltype key)
{
	tree_type node = *root_addr, previous = NULL;

	while (node)
	{
		if (node->key == key)
			break;

		previous = node;

		if (node->key > key)
			node = node->left;
		else
			node = node->right;
	}
	if (node->key == key)
		if (node == *root_addr)
			copy(root_addr);
		else if (previous->left == node)
			copy(&previous->left);
		else
			copy(&previous->right);
	else if (*root_addr)
		printf ("\nkey &c is not in the tree");
	else
		printf ("\n the tree is empty");

}

void copy (tree_type *node)
{
	tree_type previous, tmp = *node;

	if(!(*node)->right)
		*node = (*node)->left;
	else if (!(*node)->left)
		*node = (*node)->right;
	else
	{
		tmp = (*node)->left;
		previous = *node;
		while (tmp->right)
		{
			previous = tmp;
			tmp = tmp->right;
		}
		(*node)->key = tmp->key;
		strcpy((*node)->name,tmp->name);      //

		if (previous == *node)
			previous->left = tmp->left;
		else
			previous->right = tmp->left;
	}
	free(tmp);
}







