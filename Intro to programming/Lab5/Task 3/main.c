#include <stdio.h>
#include <stdlib.h>

int main()
{
    char fname[3][10],lname[3][10],fullname[3][20];
    for(int i=0;i<3;i++){
        printf("Enter first name of student %d:",i+1);
        scanf("%s",fname[i]);
        printf("Enter second name of student %d:",i+1);
        scanf("%s",lname[i]);
    }
    for(int i=0;i<3;i++){
    strcpy(fullname[i],fname[i]);
    strcat(fullname[i]," ");
    strcat(fullname[i],lname[i]);
    strcat(fullname[i]," ");
    printf("%s",fullname[i]);

    }
    return 0;
}
