#include <stdio.h>
#include <stdlib.h>

struct Employee
{
    int id;
    char name[20];
    int salary;
};

struct Employee emp[3];
struct Employee fillEmp();
void printEmp(struct Employee emp);
void sortIdBubble();
void sortNameMerge(int low,int high,int mid);
void mergeSort(int low,int high);
struct Employee searchIdBinary(int Id);

int main()
{
    struct Employee employee;
    int num,i,flag=1,id;
    do
    {
        printf("1)Add employee\n2)Display all\n3)Sort by ID (Bubble)\n4)Sort by name (Merge)\n5)Search by ID (Binary)\n");
        scanf("%d",&num);
        switch(num)
        {
        case 1:
            for (i=0; i<3; i++)
            {
                emp[i]=fillEmp();
            }
            break;
        case 2:
            for (i=0; i<3; i++)
            {
                printEmp(emp[i]);
            }
            break;
        case 3:
            sortIdBubble();
            break;
        case 4:
            mergeSort(0,2);
            break;
        case 5:
            printf("Enter ID:");
            scanf("%d",&id);
            sortIdBubble();
            employee=searchIdBinary(id);
            break;
        }
        printf("\nPress any key to continue");
        getch();
        system("cls");
    }
    while(flag);
    return 0;
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

void printEmp(struct Employee emp)
{
    printf("ID is:%d\n",emp.id);
    printf("Name is:%s\n",emp.name);
    printf("The salary is:%d\n",emp.salary);
}

struct Employee searchIdBinary(int Id)
{
    int mid,loc=-1,i,LB=0,UB=3;
    while(LB<=UB && loc==-1)
    {
        mid=(LB+UB)/2;
        if (emp[mid].id==Id)
        {
            loc=mid;
        }
        else if (emp[mid].id<Id)
        {
            LB=mid+1;
        }
        else
        {
            UB=mid-1;
        }
        printf("Employee ID: %d\nEmployee Name: %s\nEmployee Salary: %d\n",emp[loc].id,emp[loc].name,emp[loc].salary);
        return emp[loc];
    }
}

void sortIdBubble()
{
    int n=3,i,j,swapped=1;
    struct Employee temp;
    for(i=0; i<n-1 && swapped ; i++)
    {
        swapped=0;
        for(j=0; j<n-1-i; j++)
        {
            if (emp[j].id>emp[j+1].id)
            {
                temp=emp[j];
                emp[j]=emp[j+1];
                emp[j+1]=temp;
                swapped=1;
            }
        }
    }
}

void mergeSort(int low,int high)
{
    int mid;
    if (low<high)
    {
        mid=(low+high)/2;
        mergeSort(low,mid);
        mergeSort(mid+1,high);
        sortNameMerge(low,mid,high);
    }
}

void sortNameMerge(int low,int mid,int high)
{
    struct Employee temp[3];
    int list1,list2,i=low;
    list1=low;
    list2=mid+1;
    while(list1<=mid && list2<=high)
    {
        if(strcmp(emp[list1].name,emp[list2].name)<0)
        {
            temp[i]=emp[list1];
            list1++;
            i++;
        }
        else
        {
            temp[i]=emp[list2];
            list2++;
            i++;
        }
    }
    while(list1<=mid)
    {
        temp[i]=emp[list1];
        list1++;
        i++;
    }
    while(list2<=high)
    {
        temp[i]=emp[list2];
        list2++;
        i++;
    }
    for(i=low; i<=high; i++)
    {
        emp[i]=temp[i];
    }
}
