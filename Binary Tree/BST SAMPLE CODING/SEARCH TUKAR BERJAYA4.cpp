#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct btree_node
{
    int number;
    struct btree_node *left, *right;

};
typedef struct btree_node *tree;

//struct btree_node *nodeAddr,*rootAddr;

tree SEARCH(tree,int number);
void  INSERT(tree *rootAddr,int number);
void INORDER (tree node);
void DELETE (tree *rootAddr,int number);
void COPY(tree *node);

main ()
{
	
   int element;
   tree node = NULL;
   tree s;
   tree T;
   int choice, count=0;

   while (choice !=0)
   {
     printf("\n\n MENU ");
     printf("\n 0: Quit");
     printf("\n 1: Search");
     printf("\n 2: Insert");
     printf("\n 3: Display Accending");
     printf("\n 4: Delete by copying");
     printf("\n\n Enter your choice: ");
     scanf("\t%d",&choice);

         switch(choice)
         {
          	case 1 : printf("\n SEARCH");
            			printf("\n Enter the searching number:");
            			scanf("%d", &element);
                     T = SEARCH(node,element);
                     if(T != NULL)
                     printf("\n The number %d is found",T->number);
                     else
                     printf("\n The number %d is not found", element);
                     break;

         	case 2 : printf ("\n Insert");
            		   printf("\n Enter an integer number: ");
                 		scanf("%d",&element);
                 		INSERT(&node, element);
                 		printf ("\n Insertion is successful");
                 		break;

         	case 3 : printf("\n Display number in accending \n\n");
                     INORDER(node);
                  	break;

         	case 4 : printf ("\n Delete BY COPY");
                 		printf("\n Enter a number to delete: ");
                 		scanf("%d",&element);
                 		DELETE(&node,element);
                 		break;

            default: printf("\n Please enter number only from the MENU");

         }
   }

}

tree SEARCH(tree node,int number)
{
 	if(node!=NULL)// node is not null
   {
    	if(number == node->number)
      return node;

      else if(number < node->number)
      return SEARCH(node->left,number);

      else
      return SEARCH(node->right,number);
   }

   else
   return NULL;

}
void INSERT(tree *rootAddr, int number)
{
   struct btree_node *newnode, *currNode, *previous = NULL;

   newnode = (struct btree_node*) malloc (sizeof(struct btree_node));
   newnode->left = newnode->right = NULL;
   newnode->number = number;
   
   currNode = *rootAddr;
   while (currNode!=NULL)
   {
      previous = currNode;
      if (currNode->number > number)
         currNode = currNode->left;
      else
         currNode = currNode->right;
   }

   if (*rootAddr==NULL)
      *rootAddr = newnode;

   else if (previous->number > number)
      previous->left = newnode;
   else
      previous->right = newnode;
}

void INORDER (tree node)
{
   int x;

   if (node!=NULL)
   {
      INORDER(node->left);
      printf("\n => %d",node->number);
      INORDER(node->right);
   }

}

void DELETE(tree *rootAddr, int number)
{
   tree node = *rootAddr, previous = NULL;

   while (node!=NULL)
   {
      if (node->number == number)
         break;

      previous = node;

      if (node->number > number)
         node = node->left;
      else
         node = node->right;
   }
   if (node==NULL)
     { printf ("\n Number %d is not in the tree!!!",number);
       return;}

   else if (node->number == number)
      {if (node == *rootAddr)
         COPY(rootAddr);
      else if (previous->left == node)
         COPY(&previous->left);
      else
         COPY(&previous->right);}

}

void COPY (tree *node)
{
   tree previous, tmp = *node;

   if(!(*node)->right)
      *node = (*node)->left;//no right child
   else if (!(*node)->left)//no left child
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
      (*node)->number = tmp->number;
      if (previous == *node)
      	  previous->left = tmp->left;
      else
         previous->right = tmp->left;
     
   }
   free(tmp);
}


