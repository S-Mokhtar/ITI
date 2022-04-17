#include <stdio.h>
#include <stdlib.h>
#include<conio.h>
#include<Windows.h>

int add(int x, int y){
system("cls");
int z;
printf("Enter the first number:");
scanf("%d",&x);
printf("Enter the second number:");
scanf("%d",&y);
z=x+y;
printf("\nSummation is: %d",z);
}

int sub(int x, int y){
system("cls");
int z;
printf("Enter the first number:");
scanf("%d",&x);
printf("Enter the second number:");
scanf("%d",&y);
z =x-y;
printf("\nSubtraction is: %d",z);
}

int mul(int x, int y){
system("cls");
printf("Enter the first number:");
scanf("%d",&x);
printf("Enter the second number:");
scanf("%d",&y);
int z =x*y;
printf("\nMultiplication is %d",z);
}

void gotoxy1(int x, int y)
{
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}

int main()
{
    int row,a,b,flag=1;
    printf("Add\nSub\nMult\nExit\n");
    gotoxy1(0,0);
    char ch;
    do{
     ch=getch();
     if(ch==-32){
       ch=getch();
       if (ch==80)
        row++;
       if (ch==71)
        row=0;
       if(ch==72)
        row--;
       if(ch==79)
        row=3;
       gotoxy1(0,row);
    }
    else if(ch==13){
       if(row==0)
            add(a,b);
    else if(row==1)
            sub(a,b);
    else if(row==2)
            mul(a,b);
    else if(row==3)
            flag=0;}
 } while(flag);
    return 0;
}
