#include <iostream>

using namespace std;

void swap(int& x,int& y){
int temp;
temp=x;
x=y;
y=temp;
}

int main()
{
    int a=3,b=4;
    swap(a,b);
    cout << a << endl;
    cout << b << endl;
    return 0;
}
