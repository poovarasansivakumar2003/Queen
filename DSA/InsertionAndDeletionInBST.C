/*****************************************************
Insertion And Deletion Operation In Binary Search Tree
******************************************************/

//Header Files
#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

//Structure for node
struct node {
  int data;
  struct node * llink;
  struct node * rlink;
};

//Typedefining the node pointer
typedef struct node *NODE;

//Function prototype
NODE insertion(NODE, int);
NODE deletion(NODE, int);

//Inorder traversal
void inorder(NODE root) {
  if (root != NULL) {
    inorder(root -> llink);
    printf("%d\t", root -> data);
    inorder(root -> rlink);
  }
}

//Preorder traversal
void preorder(NODE root) {
  if (root != NULL) {
    printf("%d\t", root -> data);
    preorder(root -> llink);
    preorder(root -> rlink);
  }
}

//Postorder traversal
void postorder(NODE root) {
  if (root != NULL) {
    postorder(root -> llink);
    postorder(root -> rlink);
    printf("%d\t", root -> data);
  }
}

//Main function
void main() {
  int option, key;
  NODE root = NULL;//Initially root is not present
  clrscr();
  while (1) {
    printf("\nTree operations\n");
    printf("1.Insert\n2.Delete\n3.Display\n4.Exit\n");
    printf("Enter your choice: ");
    scanf("%d", &option);
    switch (option) {
    case 1:
      printf("Enter the data to be Inserted: ");
      scanf("%d", &key);//Taking element to be inserted
      root = insertion(root, key);
      getch();
      clrscr();
      break;
    case 2:
      if(root!=NULL){//Checking whether it is a non-empty tree
	printf("Enter the data to be Deleted: ");
	scanf("%d", &key);//Taking element to be deleted;
	root = deletion(root, key);
	getch();
	clrscr();
	break;
      }
      else{
       printf("Root Node is not inserted");
       getch();
       clrscr();
       break;
      }
    case 3:
      printf("\nDisplay options\n");
      printf("1.Inorder\n2.Preorder\n3.Postorder\n");
      printf("Enter your choice: ");//Selecting type of traversal
      scanf("%d", & option);
      switch (option) {
      case 1:
	printf("\nInorder traversal\n");
	inorder(root);
	getch();
	clrscr();
	break;
      case 2:
	printf("\nPreorder traversal\n");
	preorder(root);
	getch();
	clrscr();
	break;
      case 3:
	printf("\nPostorder traversal\n");
	postorder(root);
	getch();
	clrscr();
	break;
      default:
	printf("Invalid choice\n");
      }
      break;
    case 4:
      exit(0);
    default:
      printf("Invalid choice\n");
      getch();
      clrscr();
    }
  }
}

NODE insertion(NODE root, int key) {
  // If the tree is empty, return a new node or base case
  if (root == NULL) {
    NODE temp;
    temp = (NODE) malloc(sizeof(struct node));
    temp -> data = key;
    printf("%d is successfully inserted", temp -> data);
    temp -> llink = temp -> rlink = NULL;
    return temp;
  }

  // Otherwise, recur down the tree
  if (key < root -> data)
    root -> llink = insertion(root -> llink, key);
  else if (key > root -> data)
    root -> rlink = insertion(root -> rlink, key);
  else if (key == root -> data)
    printf("Already data present");

  // Return the (unchanged) node pointer
  return root;
}

NODE deletion(NODE root, int key) {
  NODE succParent, succ;
  // Base case
  if (root == NULL){
    printf("Not Found");
    return root;
 }

  // If the key to be deleted is smaller than the root's key,
  // then it lies in the left subtree
  if (key < root -> data) {
    root -> llink = deletion(root -> llink, key);
    return root;
  }
  // If the key to be deleted is greater than the root's key,
  // then it lies in the right subtree
  else if (key > root -> data) {
    root -> rlink = deletion(root -> rlink, key);
    return root;
  }

  // If key is same as root's key, then this is the node to be deleted
  // Node with only one child or no child
  if (root -> llink == NULL) {
    NODE temp = root -> rlink;
    printf("%d is successfully deleted", root -> data);
    free(root);
    return temp;
  }
  else if (root -> rlink == NULL) {
    NODE temp = root -> llink;
    printf("%d is successfully deleted", root -> data);
    free(root);
    return temp;
  }

  // Node with two children: Get the inorder successor (smallest in the right subtree)
  succParent = root;
  succ = root -> rlink;
  while (succ -> llink != NULL) {
    succParent = succ;
    succ = succ -> llink;
  }

  printf("%d is successfully deleted",root->data);

  // Copy the inorder successor's content to this node
  root -> data = succ -> data;

  // Delete the inorder successor
  if (succParent -> llink == succ)
    succParent -> llink = succ -> rlink;
  else
    succParent -> rlink = succ -> rlink;

  free(succ);
  return root;
}
