#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num;

    do{
    printf(" 1.Add\n 2.Edit\n 3.Delete\n 4.Exit\n Enter your choice(1-4):\n");
    scanf("%d",&num);

    switch(num){
    case 1:
        printf("Add\n");
        break;
    case 2:
        printf("Edit\n");
        break;
    case 3:
        printf("Delete\n");
        break;
    case 4:
        break;
    }

    }while(num<4);
        return 0;
    }

