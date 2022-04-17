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
	Employee operator = (Employee e);
    Employee operator + (Employee e);
	Employee operator + (int m);
	Employee operator + (char* n);
	operator char*();
	operator int();
	int operator ++(int d);
	Employee operator ++();
	int operator == (Employee e);
	Employee& operator = (Employee& e);
};
Employee operator + (int m,Employee e);
Employee operator + (char*n,Employee e);

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


Employee Employee::operator = (Employee e){
	id=e.id;
	strcpy(name,e.name);
	salary=e.salary;
    return e;
}

Employee Employee::operator + (Employee e){
	Employee temp;
	temp.id=id+e.id;
	temp.name = strcat(name,e.name);
	temp.salary=salary+e.salary;
	return temp;
}

Employee Employee::operator + (int m){
	Employee temp;
	temp.id=id;
	strcpy(name,temp.name);
	temp.salary=salary+m;
	return temp;
}

Employee operator + (int m,Employee e){
	return(e+m);
}

Employee Employee::operator + (char* n){
	Employee temp;
	temp.id=id;
	temp.name=strcat(name,n);
	temp.salary=salary;
	return temp;
}

Employee operator + (char*n,Employee e){
	return(e+(*n));
}

Employee::operator char*(){
	return name;
}

Employee::operator int(){
	return id;
}

int Employee::operator ++(int d){
	id++;
	return id;
}

Employee Employee::operator ++(){
	id++;
	return *this;
}

int Employee::operator == (Employee e){
	return (id==e.id && strcmp(name,e.name) && salary==e.salary);
}

Employee& Employee::operator = (Employee& e){
    id=e.id;
    strcpy(name,e.name);
    salary=e.salary;
    delete(name);
    name= new char[strlen(e.name)+1];
    for(int i=0;i<strlen(e.name)+1;i++){
        name[i]=e.name[i];
    }
    return *this;
}

int main()
{
    Employee e1(10,"esraa",11);
    Employee e2(20,"shaimaa",21);
	//e1=e2;
//	e1+e2;
	//e1+1000;
//	1000+e1;
//	e1+"Ahmed";
//	"Ahmed"+e1;
//	(char*)e1;
//	(int)e1;
	e1++;
//	++e1;
//	e1==e2;
    PrintEmployee(e1);
    PrintEmployee(e2);
    return 0;
}
