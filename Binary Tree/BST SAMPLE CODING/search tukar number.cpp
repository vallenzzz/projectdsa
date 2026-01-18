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
       printf("\n\n CODES FOR BOOKS");
       printf("\n M = Mathematic\n D = Data Structure\n O = OOP\n S = SADM\n A = Artificial inteligence\n P = Pengajian Malaysia\n E = English for Business"); 
     printf("\n------------------------------------------");
     printf("\n\n MENU ");
    	printf("\n 0: Quit");
      printf("\n 1: Search");
       printf("\n 2: Insert");
        printf("\n 3: Display Accending");
         printf("\n 4: Delete by copying");
          printf("\n\nEnter your choice: ");
			scanf("\t%d",&choice);

         switch(choice)
         {
          	case 1 : printf("\n SEARCH");
            			printf("\n Enter Book Title");
            			scanf("%d", &element);
                     T = SEARCH(node,element);
                     if(T != NULL)
                     printf("\n The book %d is found",T->key);
                     else
                     printf("\n The book %d is not found" , element);
                     break;

         case 2 :  printf ("\n Insert");
                  printf("\n Enter book name (char) : ");
                 scanf("%d", &element);
                 INSERT(&node, element);
                 printf ("\n Insertion is successful");
                 break;

         case 3 : printf("\n Display Accending \n\n");
         			INORDER(node);
                  break;

         case 4 : printf ("\n Delete BY COPY");
                 printf("\n Enter 1st character of book name to delete: ");
                 scanf("%d",&element);
                 DELETE(&node, element);
                 break;


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
   if (node->key == key)
      {if (node == *rootAddr)
         COPY(rootAddr);
      else if (previous->left == node)
         COPY(&previous->left);
      else
         COPY(&previous->right);}
   else if (*rootAddr)
      printf ("\nBook name  is not in the tree");
   else
      printf ("\n the tree is empty");

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


