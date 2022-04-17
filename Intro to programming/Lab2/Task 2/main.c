#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num, sum=0;
    do{
        printf("Enter a number:\n");
        scanf("%d",&num);
        sum+=num;
    } while(sum<100);
    printf("The sum exceeds 100\n");
    return 0;
}
