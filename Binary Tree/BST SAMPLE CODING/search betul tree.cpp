#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

void createNOde();
struct btree_node insertNOde(btree_node *,int);
void listNode();

struct btree_node
{
    int data;
    struct btree_node *left;
    struct btree_node *right;

};

struct btree_node *rootptr, *newptr, *currentptr;
//pointer that can point to a node

void main()
{
	char ch;
	int choice=TRUE;

	rootptr=NULL;
	while(choice==TRUE)

	{
		printf("\n\ni - Insert a new node");
		printf("\nl - List all numbers");
		printf("\nx - Exit\n");
		printf("\nEnter choice: ");
		scanf(" %c",&ch);
		switch(ch)
		{
		case 'i':createNOde();break;
		case 'l':listNode();break;
		case 'x': choice=FALSE; break;

		default: printf("\nEnter only one from the above");
		}
	}


}

void createNOde()
{
  newptr=(struct btree_node *)malloc(sizeof (struct btree_node)); // pointer to a new
  																			//	memory allocation

  printf("\nEnter an integer number: ");
  scanf("%d",&newptr->data);

  rootptr = insertNOde(&newptr,newptr->data)
  //	else
  //	{
  //    newptr->ptrnext=headptr;// new node pointer point to previous first node
	//	headptr=newptr; // head point to new node,new node become first node

  //	}



}

struct btree_node insertNOde(struct btree_node *subroot, int data)
{

	if (rootptr==NULL)//node is empty?
	  	{rootptr=newptr; //first pointer point to first node
       newptr->left=NULL; //first node pointer point to null
       newptr->right=NULL;
       return sub
      }

  //	else
  //	{
  //    newptr->ptrnext=headptr;// new node pointer point to previous first node
	//	headptr=newptr; // head point to new node,new node become first node

  //	}



}


void listNode()
{
	if (rootptr==(struct number*)NULL) //empty list
	{
		printf("\nEmpty list");
		return;
	}

	currentptr=rootptr;


	do
   {
		printf("\n\n%d",currentptr->data);
		printf("\n");
		currentptr=currentptr->left; //point to next node
	} while(currentptr !=(struct number *)NULL);
}


