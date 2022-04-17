#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b,c;
    float d,x,x1,x2;
    printf("Enter the coefficient a:\n");
    scanf("%d",&a);
    printf("Enter the coefficient b:\n");
    scanf("%d",&b);
    printf("Enter the coefficient c:\n");
    scanf("%d",&c);
    d=(b*b)-4*a*c;
    if(d>0){
        printf("You have two solutions\n");
        x1=(-b+sqrt(d))/2*a;
        x2=(-b-sqrt(d))/2*a;
        printf("The first solution is %f\n",x1);
        printf("The second solution is %f\n",x2);
    }
    else if (d==0){
        printf("You have one solution");
        x=-b/2*a;
        printf("The solution is %f",x);
    }
    else{
        printf("You have an imaginary solution");
    }
    return 0;
}
