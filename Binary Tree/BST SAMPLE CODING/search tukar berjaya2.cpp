#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node_rec
{
    int key;
    struct node_rec *left, *right;

};
typedef struct node_rec *tree;


tree SEARCH(tree node,int key);
void  INSERT(tree *rootAddr,int key);
void INORDER (tree node);
void DELETE (tree *rootAddr,int key);
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
                     printf("\n The number %d is found",T->key);
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

tree SEARCH(tree node,int key)
{
 	if(node)// node is not null
   {
    	if(key == node->key)
      return node;

      else if(key < node->key)
      return SEARCH(node->left,key);

      else
      return SEARCH(node->right,key);
   }

   else
   return NULL;

}
void INSERT(tree *rootAddr, int key)
{
   tree p, previous = NULL, newnode;

   newnode = (struct node_rec*) malloc (sizeof(struct node_rec));
   newnode->left = newnode->right = NULL;
   newnode->key = key;
   
   p = *rootAddr;
   while (p)
   {
      previous = p;
      if (p->key > key)
         p = p->left;
      else
         p = p->right;
   }

   if (!*rootAddr)
      *rootAddr = newnode;

   else if (previous->key > key)
      previous->left = newnode;
   else
      previous->right = newnode;
}

void INORDER (tree node)
{
   int x;

   if (node)
   {
      INORDER(node->left);
      printf("\n => %d",node->key);
      INORDER(node->right);
   }

}

void DELETE(tree *rootAddr, int key)
{
   tree node = *rootAddr, previous = NULL;

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
   if (node==NULL)
     { printf ("\n Number %d is not in the tree!!!",key);
       return;}

   else if (node->key == key)
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
      (*node)->key = tmp->key;
      if (previous == *node)
      	  previous->left = tmp->left;
      else
         previous->right = tmp->left;
     
   }
   free(tmp);
}


