#include <stdio.h>
#include <stdlib.h>

int arr[5];
int rear=0;
int front=0;

int main()
{
    int m,x;
    printf("Enter queue value:\n");
    scanf("%d",&x);
    m=inqueue(x);
    if(m==0)
    {
        printf("Queue is full\n");
    }
    else
    {
        printf("Value added\n");
    }
    m=dequeue();
    if(m==-1)
    {
        printf("Queue is empty\n");
    }
    else
    {
        printf("Value=%d\n",m);
    }
    return 0;
}

int inqueue(int data)
{
    int retval=0;
    if(rear<5)
    {
        arr[rear]=data;
        rear++;
        retval=1;
    }
    return retval;
}

int dequeue()
{
    int retval=-1;
    if(front>-1){
        retval=arr[front];
        front++;
    }
    return retval;
}
