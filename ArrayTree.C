#include<stdio.h>
#include<conio.h>

void main(){
    static int a[16];
    int i, option;
    clrscr();
    a[0] = 0;
    printf("Tree Operation on arrays\n");
    printf("Enter the value of root node: \n");
    scanf("%d",&a[1]);
    if (a[1] == 0) {
	printf("\nInvalid");
    	return;
    }
    for (i = 1; i <= 7; i++){
	if (a[i] == 0)
	    continue;
	printf("\nIs there a left child node for %d node? YES 1 NO 0: ", a[i]);
	scanf("%d", &option);
	if (option){
	    left: printf("\nEnter left child node for %d node: ", a[i]);
	    scanf("%d",&a[2*i]);
	    if (a[i]<a[2*i] || ((2*i)>4 && i%2!=0 && a[2*i]<a[i/2])) {
		printf("\nInvalid input, please try again.\n");
		goto left;
	    }
	}
	else{
	    a[2*i] = 0;
	}
	right: printf("\nIs there a right child node for %d node? YES 1 NO 0: ", a[i]);
	scanf("%d",&option);
	if (option) {
	    printf("\nEnter right child node for %d node: ", a[i]);
	    scanf("%d",&a[2*i+1]);
	    if (a[i] > a[2*i+1] || ((2*i+1)>4 && i%2==0 && a[2*i+1] > a[i/2])) {
		printf("\nInvalid input, please try again.\n");
		goto right;
	    }
	}
	else{
	    a[2*i+1] = 0;
	}
    }
    printf("\nDo you want to display array? YES 1 NO 0: ");
    scanf("%d", &option);
    if (option) {
	for (i = 0; i < 16; i++)
	    printf("%d\t", a[i]);
    }
    getch();
}
