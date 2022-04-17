#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i,j,sum,avg;
    int arr[3][4];
    for(i=0;i<3;i++){
        for(j=0;j<4;j++){
            printf("Enter the grade %d of the student %d:\n",j+1,i+1);
            scanf("%d",&arr[i][j]);
        }
    }

    for(i=0;i<3;i++){
        for(j=0;j<4;j++){
            sum+=arr[i][j];
        }
        printf("The sum of the grades of the student %d is: %d\n",i+1,sum);
        sum=0;
    }

    for(j=0;j<4;j++){
        for(i=0;i<3;i++){
            sum+=arr[i][j];
        }
        avg=sum/4;
        printf("The average of the grades of subject %d is: %d\n",j+1,avg);
        sum=0;
        avg=0;
    }
    return 0;
}
