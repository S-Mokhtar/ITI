#include <iostream.h>
#include <string.h>
#include <conio.h>
#include <math.h>

class Point
{
	int x;
	int y;
	public:
	Point()
	{
		x=y=0;
	}
	Point(int m)
	{
		x=y=m;
	}
	Point(int m,int n)
	{
		x=m;
		y=n;
	}
	void setX(int m)
	{
		x=m;
	}
	void setY(int n)
	{
		y=n;
	}
	int getX()
	{
		return x;
	}
	int getY()
	{
		return y;
	}
};

class Rectangle
{
	Point pt1,pt2;
	int length,width;
	public:
	Rectangle(int x1,int y1,int x2,int y2):pt1(x1,y1),pt2(x2,y2)
	{
		length=abs(x2-x1);
		width=abs(y2-y1);
	}
	void setP1(int x,int y)
	{
		pt1.setX(x);
		pt1.setY(y);
		length=abs(pt2.getX()-x);
		width=abs(pt2.getY()-y);
	}
	
	void setP2(int x,int y)
	{
		pt2.setX(x);
		pt2.setY(y);
		length=abs(pt1.getX()-x);
		width=abs(pt1.getY()-y);
	}

	int Area()
	{
		return (length*width);
	}
};

class Circle
{
	Point* pt1,*pt2;
	int radius;
	static double PI;
	public:
	Circle(){
		pt1=pt2=NULL;
		radius=0;
	}
	Circle(Point* p1,Point* p2){
		pt1=p1;
		pt2=p2;
		if(pt1&&pt2){
			radius=sqrt(pow(pt1->getX()-pt2->getX(),2)+pow(pt1->getY()-pt2->getY(),2));
		}
	}
	void setP1(Point*p1){
		pt1=p1;
		if(pt1&&pt2){
			radius=sqrt(pow(pt1->getX()-pt2->getX(),2)+pow(pt1->getY()-pt2->getY(),2));
		}
	}

	void setP2(Point*p2){
		pt2=p2;
		if(pt1&&pt2){
			radius=sqrt(pow(pt1->getX()-pt2->getX(),2)+pow(pt1->getY()-pt2->getY(),2));
		}
	}
	
	double Area()
	{
		return (PI * (radius*radius));
	}
};
double Circle::PI=3.14;

int main()
{
clrscr();
	Point p1(4,10),p2(6,10);
	Rectangle r(2,3,5,6);
	cout<<"Rectangle Area: "<<r.Area()<<endl;
	Circle c(&p1,&p2);
	cout<<"Circle Area: "<<c.Area()<<endl;
	return 0;
}