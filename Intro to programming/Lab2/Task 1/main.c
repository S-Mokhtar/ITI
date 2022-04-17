#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num1,num2,num3,num4,num5;
    printf("Enter the first number:\n");
    scanf("%d",&num1);
    printf("Enter the second number:\n");
    scanf("%d",&num2);
    printf("Enter the third number:\n");
    scanf("%d",&num3);
    printf("Enter the fourth number:\n");
    scanf("%d",&num4);
    printf("Enter the fifth number:\n");
    scanf("%d",&num5);

    if(num1>num2 && num1>num3 && num1>num4 && num1>num5){
        printf("The maximum number is %d",num1);
    }
    else if (num2>num3 && num2>num4 && num2>num5){
        printf("The maximum number is %d",num2);
    }
    else if (num3>num4 && num3>num5){
        printf("The maximum number is %d",num3);
    }
    else if (num4>num5){
        printf("The maximum number is %d",num4);
    }
    else{
        printf("The maximum number is %d\n",num5);
    }

    if(num1<num2 && num1<num3 && num1<num4 && num1<num5){
        printf("The minimum number is %d",num1);
    }
    else if (num2<num3 && num2<num4 && num2<num5){
        printf("The minimum number is %d",num2);
    }
    else if (num3<num4 && num3<num5){
        printf("The minimum number is %d",num3);
    }
    else if (num4<num5){
        printf("The minimum number is %d",num4);
    }
    else{
        printf("The minimum number is %d",num5);
    }
    return 0;
}
