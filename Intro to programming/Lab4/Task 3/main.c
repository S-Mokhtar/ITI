#include <stdio.h>
#include <stdlib.h>
    int power(int x, int y){
      if(y!=0){
        return (x*power(x,y-1));
      }
      else{
        return 1;
      }
    }
int main()
{
    int result,base,pow;
    printf("Enter the base:\n");
    scanf("%d",&base);
    printf("Enter the power:\n");
    scanf("%d",&pow);
    result= power(base,pow);
    printf("The result is: %d",result);
    return 0;
}
