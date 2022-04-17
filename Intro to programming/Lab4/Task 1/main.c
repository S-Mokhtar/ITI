#include <stdio.h>
#include <stdlib.h>

int main()
{
    int arr[5];
    int i,min, max;
    for (i=0;i<5;i++){
        printf("Enter the %d number:\n",i+1);
        scanf("%d",&arr[i]);
    }
    min=arr[0];
    for (i=0;i<5;i++){
        if(min>arr[i]){
           min=arr[i];
        }
    }
    printf("The minimum is: %d\n",min);
    max=arr[0];
     for (i=0;i<5;i++){
        if(max<arr[i]){
           max=arr[i];
        }
     }
    printf("The maximum is: %d",max);
    return 0;
}
