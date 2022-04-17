#include <iostream>
#include <fstream>

using namespace std;

int main()
{
        ofstream obj1;
        obj1.open("file1.txt", ios::out);
        int output1;
        output1 = 10;
        obj1 << output1 << endl;
        obj1.close();

        ifstream obj2;
        obj2.open("file2.txt", ios::in);
        int input1, input2;
        obj2 >> input1;
        obj2 >> input2;
        cout << "The first input is: " << input1 << endl;
        cout << "The second input is: " << input2 << endl;
        obj2.close();

        ofstream obj3;
        obj3.open("file3.bin", ios::binary|ios::out);
        int output2;
        output2 = 30;
        obj3.write((char*)&output2, sizeof(int));
        obj3 << output2 << endl;
        obj3.close();

        ifstream obj4;
        obj4.open("file4.bin", ios::binary|ios::in);
        int input3;
        obj4.read((char*)&input3, sizeof(int));
        cout << "The file contains: " << input3 << endl;
        obj4.close();
    return 0;
}
