#include <iostream.h>
#include <string.h>
#include <conio.h>

class Shape
{
	protected:
	int dim1,dim2;
	public:
	Shape()
	{
		dim1=dim2=0;
	}
	Shape(int m)
	{
		dim1=dim2=m;
	}
	Shape(int m, int n)
	{
		dim1=m;
		dim2=n;
	}
	void setD1(int m)
	{
		dim1=m;
	}
	void setD2(int n)
	{
		dim2=n;
	}
	int GetD1()
	{
		return dim1;
	}
	int GetD2()
	{
		return dim2;
	}
	virtual float Area()=0;
};

class Circle : public Shape
{
	public:
	Circle()
	{}
	Circle(int r):Shape(r)
	{}
	float Area()
	{
		return(3.14*dim1*dim2);
	}
};

class Triangle:public Shape
{
	public:
	Triangle()
	{}
	Triangle(int b,int h):Shape(b,h)
	{}
	float Area()
	{
		return (0.5*dim1*dim2);
	}
};

class Rectangle:public Shape
{
	public:
	Rectangle()
	{}
	Rectangle(int l,int w):Shape(l,w)
	{}
	float Area()
	{
		return (1.0*dim1*dim2);
	}
};

class Square:public Rectangle
{
	public:
	Square()
	{}
	Square(int s):Rectangle(s,s)
	{}
};

class Geoshape
{
	Shape* p[4];
	public:
	Geoshape(Shape* p1,Shape* p2,Shape* p3,Shape* p4)
	{
		p[0]=p1;
		p[1]=p2;
		p[2]=p3;
		p[3]=p4;
	}
	float TotalArea();
};
float Geoshape :: TotalArea()
	{
		float sum=0;
		for(int i=0;i<4;i++)
		{
			sum+=p[i]->Area();
		}
		return sum;
	}

int main()
{
	clrscr();
	Circle c(7);
	Triangle t(20,10);
	Rectangle r(20,5);
	Square s(6);
	Geoshape g(&c,&t,&r,&s);
	cout<<g.TotalArea();
	return 0;
}