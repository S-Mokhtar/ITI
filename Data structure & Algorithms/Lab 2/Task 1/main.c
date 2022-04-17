#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int Data;
    struct Node *next;
};

struct Node *tos;
struct Node *head;
struct Node *tail;

int main()
{
    int m,x;
    printf("Enter stack value:\n");
    scanf("%d",&x);
    m=push(x);
    if(m==0)
    {
        printf("Stack is full\n");
    }
    else
    {
        printf("Value added\n");
    }
    m=pop();
    if(m==-1)
    {
        printf("Stack is empty\n");
    }
    else
    {
        printf("Value=%d\n",m);
    }
    return 0;
}

int push(int data)
{
    int retval=0;
    struct Node *ptr;
    ptr=(struct Node*)malloc(sizeof(struct Node));
    if(ptr)
    {
        ptr->Data=data;
        ptr->next=NULL;
        if(!head)
        {
            head=tail=ptr=tos;
        }
        else
        {
            tos->next=ptr;
            tail=ptr=tos;
        }
        retval=1;
    }
    return retval;
}

int pop()
{
    int retval=-1;
    struct Node *ptr;
    if (head)
    {
        retval=tail->Data;
        ptr=tail;
        tos=tos->next;
        free(ptr);
    }
    return retval;
}
