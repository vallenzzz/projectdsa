#include <stdio.h>
#include <stdlib.h>

typedef char eltype ;
struct node_rec
{
	eltype key;
	struct node_rec *left, *right;
};
typedef struct node_rec *tree_type;

//prototype fungsi
tree_type SEARCH(tree_type node, eltype key);
void INSERT(tree_type *root_addr, eltype key);
void PREORDER (tree_type node);
void INORDER (tree_type node);
void POSTORDER (tree_type node);
void MERGE(tree_type *node);
void DELETE(tree_type *root_addr, eltype key);
void copy (tree_type *node);
void DELETE1(tree_type *root_addr, eltype key);

main()
{
	eltype element;
	tree_type node=NULL, T;

	T = SEARCH (node,element);
                 if (T != NULL)
                 	   printf ("\nThe key %c is found!",T->key);
                 else
                 	    printf ("\nThe key %c is not found!",element);
        

         case 2: printf ("\n Insert");
                 printf("\nEnter a key : ");
                 scanf("\t%c", &element);
                 INSERT(&node, element);
                 printf ("\n Insertion is success");
                 break;

         case 3: printf ("\n Traverse preorder");
                 PREORDER(node);
                 break;

         case 4: printf ("\n Traverse inorder");
                 INORDER(node);
                  break;

         case 5: printf ("\n Traverse postorder");
                 POSTORDER(node);
                 break;

         case 6: printf ("\n Delete BY COPY");
                 printf("\nEnter a key : ");
                 scanf("\t%c", &element);
                 DELETE(&node, element);
                 break;

         case 7: printf ("\n Delete BY MERGE");
                 printf("\nEnter a key : ");
                 scanf("\t%c", &element);
                 DELETE1(&node, element);
                 break;

       }//case
   }//while
}

tree_type SEARCH(tree_type node, eltype key)
{
   if (node)
      if (key == node->key)
           return node;
      else if (key < node->key)
           return SEARCH (node->left, key);
      else
           return SEARCH (node->right, key);

   else return NULL;
}

void INSERT(tree_type *root_addr, eltype key)
{
   tree_type p, previous = NULL, newnode;

   newnode = (struct node_rec*) malloc (sizeof(struct node_rec));
   newnode->left = newnode->right = NULL;
   newnode->key = key;

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

void PREORDER (tree_type node)
{
   if (node)
   {
      printf ("\n => %c",node->key);
      PREORDER(node->left);
      PREORDER(node->right);
   }
}

void INORDER (tree_type node)
{
   if (node)
   {
      INORDER(node->left);
      printf("\n => %c",node->key);
      INORDER(node->right);
   }
}

void POSTORDER (tree_type node)
{
   if (node)
   {
      POSTORDER(node->left);
      POSTORDER(node->right);
      printf("\n => %c",node->key);
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

   if (*root_addr && node)
   {
      if (node == *root_addr)
         copy(root_addr);
      else if (previous->left == node)
         copy(&previous->left);
      else
         copy(&previous->right);
   }

   else if (!*root_addr)
      printf ("\n the tree is empty");
   else if (!node)
      printf ("\nkey %c is not in the tree", key);

/*   if (!*root_addr)
      printf ("\n the tree is empty");
   else if (!node)
      printf ("\nkey %c is not in the tree", key);
   else 
   {
      if (node == *root_addr)
         copy(root_addr);
      else if (previous->left == node)
         copy(&previous->left);
      else
         copy(&previous->right);
   }*/
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
      if (previous == *node)
         previous->left = tmp->left;
      else
         previous->right = tmp->left;
   }
   free(tmp);
}

