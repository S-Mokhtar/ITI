#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Employee
{
    int id;
    char name[10];
    int salary;
};

struct Node
{
    struct Employee employee;
    struct Node *prev;
    struct Node *next;
};

struct Node *head;
struct Node *tail;


struct Employee fillEmp();
struct Node* createEmp(struct Employee emp);
int addEmp(struct Employee emp);
struct Node* searchId(int id);
struct Node* searchName(char name[10]);
void freeList(void);
void printEmp(struct Employee emp);
void traverse();
int insertEmp(struct Employee emp,int loc);
int deleteEmp(int loc);

int main()
{
    struct Employee emp;
    struct Node *ptr;
    int num,retval,i,flag=1,id,loc;
    char sname[10];
    if(ptr!=NULL)
    {
        do
        {
            printf("1)Add employee\n2)Delete employee\n3)Insert employee\n4)Search by ID\n5)Search by name\n6)Display all\n7)Free list\n8)Exit\n");
            scanf("%d",&num);
            switch(num)
            {
            case 1:
                emp=fillEmp();
                retval=addEmp(emp);
                break;
            case 2:
                printf("Enter the location of employee:");
                scanf("%d",&loc);
                retval=deleteEmp(loc);
                break;
            case 3:
                printf("Enter the location of employee:");
                scanf("%d",&loc);
                emp=fillEmp();
                retval=insertEmp(emp,loc);
                break;
            case 4:
                printf("Enter the ID of employee:");
                scanf("%d",&id);
                ptr=searchId(id);
                break;
            case 5:
                printf("Enter the name of employee:");
                scanf("%s",sname);
                ptr=searchName(sname);
                break;
            case 6:
                traverse();
                break;
            case 7:
                freeList();
                break;
            case 8:
                flag=0;
                break;
            }
        }
        while(flag);
        free(ptr);
    }
    return 0;
}

void traverse()
{
    struct Node* ptr = head;
    if(ptr ==NULL)
    {
        printf("There is no employees!\n");
    }
    else
    {
        do
        {
            printEmp(ptr->employee);
            if(ptr->next != NULL)
            {
                ptr=ptr->next;
                printEmp(ptr->employee);
            }
        }
        while(ptr->next);
    }
}

struct Node* createEmp(struct Employee emp)
{
    struct Node* ptr;
    ptr=(struct Node*)malloc(sizeof(struct Node));
    if(ptr)
    {
        ptr->employee=emp;
        ptr->prev=NULL;
        ptr->next=NULL;
    }
    return ptr;
}

struct Employee fillEmp()
{
    struct Employee emp;
    printf("Enter employee id:");
    scanf("%d",&emp.id);
    printf("Enter employee name:");
    scanf("%s",emp.name);
    printf("Enter employee salary:");
    scanf("%d",&emp.salary);
    return emp;
}

int addEmp(struct Employee emp)
{
    int retval=0;
    struct Node *ptr;
    ptr=createEmp(emp);
    if(ptr)
    {
        if(!head)
        {
            head=tail=ptr;
        }
        else
        {
            ptr->prev=tail;
            tail->next=ptr;
            tail=ptr;
        }
        retval=1;
    }
    return retval;
}

struct Node* searchId(int Id)
{
    struct Node* ptr;
    ptr=head;
    while((ptr->employee.id!=Id) && (ptr))
    {
        ptr=ptr->next;
    }
    if (ptr!=NULL)
    {
        printf("Employee ID: %d\nEmployee Name: %s\nEmployee Salary: %d\n",ptr->employee.id,ptr->employee.name,ptr->employee.salary);
    }
    else
    {
        printf("Not found\n");
    }
    return ptr;
}

struct Node* searchName(char name[10])
{
    struct Node* ptr;
    ptr=head;
    while(strcmp(ptr->employee.name,name) && (ptr))
    {
        ptr=ptr->next;
    }
    if (ptr!=NULL)
    {
        printf("Employee ID: %d\nEmployee Name: %s\nEmployee Salary: %d\n",ptr->employee.id,ptr->employee.name,ptr->employee.salary);
    }
    else
    {
        printf("Not found\n");
    }
    return ptr;
}

void freeList(void)
{
    struct Node *ptr;
    while(head)
    {
        ptr=head;
        head=head->next;
        free(ptr);
    }
    tail=NULL;
}

void printEmp(struct Employee emp)
{
    printf("ID is:%d\n",emp.id);
    printf("Name is:%s\n",emp.name);
    printf("The salary is:%d\n",emp.salary);
}

int insertEmp(struct Employee emp,int loc){
    int retval=0,i;
    struct Node *ptr, *pcurr;
    ptr=createEmp(emp);
    if(ptr){
        if(!head){
            head=tail=ptr;
        }
        else{
            if(loc==0){
                ptr->next=head;
                head->prev=ptr;
                head=ptr;
            }
            else{
                pcurr=head;
                for(i=0;i<loc-1 && pcurr;i++){
                    pcurr=pcurr->next;
                }
                if(pcurr==tail || pcurr==NULL){
                    ptr->prev=tail;
                    tail->next=ptr;
                    tail=ptr;
                }
                else{
                   ptr->next=pcurr->next;
                   pcurr->next->prev=ptr;
                   pcurr->next=ptr;
                   ptr->prev=pcurr;
                }
            }
        }
       retval=1;
    }
    return retval;
}

int deleteEmp(int loc){
    int retval=0,i;
    struct Node *ptr;
    if(head){
        if(loc==0){
            ptr=head;
            head=head->next;
            if(head!=NULL){
                head->prev=NULL;
            }
            else{
                tail=NULL;
            }
            retval=1;
            free(ptr);
        }
        else{
            ptr=head;
            for(i=0;i<loc && ptr;i++){
                ptr=ptr->next;
            }
            if(ptr){
                if(ptr==tail){
                    tail=tail->prev;
                    tail->next=NULL;
                }
                else{
                    ptr->prev->next=ptr->next;
                    ptr->next->prev=ptr->prev;
                }
                retval=1;
                free(ptr);
            }
        }
    }
    return retval;
}
