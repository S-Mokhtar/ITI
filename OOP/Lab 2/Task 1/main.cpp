#include <iostream>
#include <string.h>
using namespace std;

class Employee
{
    int id;
    char name[10];
    int salary;
public:
    void setName(char n[10]);
    void setID (int Id);
    void setSalary (int s);
    int getSalary();
    char* getName();
    int getID();

};

Employee FillEmployee()
{
    Employee emp;
    int ID,s;
    char n[10];
    cout<<"Enter employee id:";
    cin>>ID;
    cout<<"Enter employee name:";
    cin>>n;
    cout<<"Enter employee salary:";
    cin>>s;
    emp.setID(ID);
    emp.setName(n);
    emp.setSalary(s);
    return emp;
}

void PrintEmployee(Employee emp)
{
    cout<<"Enter employee id:"<<emp.getID()<<endl;
    cout<<"Enter employee name:"<<emp.getName()<<endl;
    cout<<"Enter employee salary:"<<emp.getSalary()<<endl;
}

void Employee :: setID (int Id)
{
    id=Id;
}

void Employee :: setName (char n[10])
{
    strcpy(name,n);
}

void Employee :: setSalary (int s)
{
    salary=s;
}

int Employee :: getID()
{
    return id;
}

char* Employee :: getName()
{
    return name;
}

int Employee :: getSalary()
{
    return salary;
}

int main()
{
    Employee e1;
    e1.setID(7);
    e1.setName("shaimaa");
    e1.setSalary(1000);
    PrintEmployee(e1);
    return 0;
}
