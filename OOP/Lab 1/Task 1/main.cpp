#include <iostream>

using namespace std;

struct Employee {
int id;
char name[10];
int salary;
};

struct Employee FillEmployee(){
    Employee emp;
    cout<<"Enter employee id:";
    cin>>emp.id;
    cout<<"Enter employee name:";
    cin>>emp.name;
    cout<<"Enter employee salary:";
    cin>>emp.salary;
    return emp;
}

void PrintEmployee(Employee emp){
    cout<<"Enter employee id:"<<emp.id<<endl;
    cout<<"Enter employee name:"<<emp.name<<endl;
    cout<<"Enter employee salary:"<<emp.salary<<endl;
}

int main()
{
    int i=0;
    Employee *emp;
    emp= new Employee[3];
   while(i<3){
          emp[i]=FillEmployee();
          i++;
        }
    for(i=0;i<3;i++){
          PrintEmployee(emp[i]);
         }
    return 0;
}
