#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>
#include <string.h>
void gotoxy1(int x, int y);
void lineeditor(int size,char* str);

int main()
{
    int size,i;
    char* ptr;
    printf("Enter the size:\n");
    scanf("%d",&size);
    ptr=(char*)malloc(sizeof(char)*size);
    for(i=0;i<size;i++)
    {
        ptr[i]=0;
    }
    lineeditor(size,ptr);
    return 0;
}
void gotoxy1(int x, int y)
{
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}
void lineeditor(int size,char* str)
{
    int col;
    int i,flag=1;
    char ch;
    gotoxy1(0,2);
    col=0;
    do
    {
        ch=getch();
        if (ch==-32)
        {
            ch=getch();
            if(ch==75 && ch!=0)
                col--;
            if(ch==77 && col<strlen(str))
                col++;
            if(ch==71)
                col=0;
            if(ch==79)
                col=strlen(str);
        gotoxy1(col,2);
        }
        else
        {
            if(isprint(ch))
            {
                if(col<size)
                {
                    printf("%c",ch);
                    str[col]=ch;
                    col++;
                    gotoxy1(col,2);
                }
            }
            if(ch==13)
            {
                gotoxy1(0,3);
                printf("%s",str);
            }
            if(ch==27)
                flag=0;
        }
    }
    while(flag);
}
