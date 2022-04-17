#include <iostream>
#include <string.h>
using namespace std;

class Employee
{
    int id;
    char* name;
    int salary;
public:
    void setName(char* n);
    void setID (int Id);
    void setSalary (int s);
    int getSalary();
    char* getName();
    int getID();
    Employee(){}
    Employee(int i){
        id=i;
    }
    Employee(int i,char* n){
        id=i;
        name = new char[strlen(n)+1];
        strcpy(name,n);
    }
     Employee(int i,char* n, int s){
        id=i;
        name = new char[strlen(n)+1];
        strcpy(name,n);
        salary=s;
    }
    Employee(Employee &emp);
};

Employee FillEmployee()
{
    Employee emp;
    int ID,s;
    char* n;
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

void Employee :: setName (char* n)
{
    delete(name);
    name= new char[strlen(n)+1];
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

Employee :: Employee(Employee &emp){
       id=emp.id;
       salary=emp.salary;
       name = new char[strlen(emp.name)+1];
       strcpy(name,emp.name);
    }

int main()
{
    Employee e1(10);
    Employee e2(20,"shaimaa",20);
    Employee e3(30,"sara");
    PrintEmployee(e1);
    PrintEmployee(e2);
   PrintEmployee(e3);
    return 0;
}
