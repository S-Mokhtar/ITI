#include <iostream>

using namespace std;

int BoxVolume(int l, int w,int h=1){
return (l*w*h);
}

int x;

int main()
{
    int x=3;
    cout<<x<<endl; //local
    cout<<::x<<endl; //global
    int v=BoxVolume(2,3);
    cout << v << endl;
    return 0;
}
