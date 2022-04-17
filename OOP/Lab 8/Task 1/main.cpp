#include <iostream>

using namespace std;

class Point3D
{
    int x,y,z;
public:
    Point3D()
    {
        x=y=z=0;
    }
    Point3D(int l,int m,int n)
    {
        x=l;
        y=m;
        z=n;
    }
    void setX(int l)
    {
        x=l;
    }
    void setY(int m)
    {
        y=m;
    }
    void setZ(int n)
    {
        z=n;
    }
    int getX()
    {
        return x;
    }
    int getY()
    {
        return y;
    }
    int getZ()
    {
        return z;
    }
    friend ostream& operator<<(ostream& out,Point3D p);
    friend istream& operator>>(istream& in,Point3D& p);
};

int main()
{
    Point3D obj(4,5,6);
    cout << obj << endl;
    cin>> obj;
    return 0;
}


ostream& operator<<(ostream& out,Point3D p)
{
    out<<"x= "<<p.x<<endl;
    out<<"y= "<<p.y<<endl;
    out<<"z= "<<p.z<<endl;
    return out;
}


istream& operator>>(istream& in,Point3D& p)
{
    cout<<"Enter x= "<<endl;
    in>>p.x;
    cout<<"Enter y= "<<endl;
    in>>p.y;
    cout<<"Enter z= "<<endl;
    in>>p.z;
    return in;
}
