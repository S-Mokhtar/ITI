#include<iostream.h>
#include<string.h>
#include<conio.h>
class person{
	protected:
	int id;
	char name[10];
	public:
	person(){
		id=0;
		strcpy(name,"Shaimaa");
	}
	person(int m){
		id=m;
	}
	person(int m, char* n){
		id=m;
		strcpy(name,n);
	}
	void setID(int m){
		id=m;
	}
	int getID(){
		return id;
	}
	void setName(char* n){
		strcpy(name,n);
	}
	char* getName(){
		return name;
	}
	void print(){
		cout<<id<<endl;
		cout<<name<<endl;
	}
};
class customer: virtual public person{
	int contact;
	public:
	customer(){
		contact=0;
	}
	customer(int i, char* n, int m):person(i,n){
		contact=m;
	}
	void setC(int m){
		contact=m;
	}
	int getC(){
		return contact;
	}
	void print(){
		cout<<id<<endl;
		cout<<name<<endl;
		cout<<contact<<endl;
	}
};
class employee: virtual public person{
	int salary;
	public:
	employee(){
		salary=0;
	}
	employee(int i, char* n, int m):person(i,n){
		salary=m;
	}
	void setS(int m){
		salary=m;
	}
	int getS(){
		return salary;
	}
	void print(){
		cout<<id<<endl;
		cout<<name<<endl;
		cout<<salary<<endl;
	}
};
int main(){
	employee e,e1(1,"Sarrah",1000);
	e.print();
	e1.print();
	customer c,c1(2,"Esraa",2000);
	c.print();
	c1.print();
        return 0;
}