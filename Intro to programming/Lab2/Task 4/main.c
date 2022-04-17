#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>
void gotoxy1(int x, int y)
{
    COORD coord;
    coord.X = x;
    coord.Y = y;
    SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);
}
int main()
{
    int size,num,col,row;
    printf("Please enter size of magic box:\n");
    scanf("%d",&size);
    for(num=1;num<=size*size;num++){
      if(num==1){
        col=(size+1)/2;
        row=1;
      }
      else if((num-1)%size){
        row--;
        if(row<1){
            row=size;
        }
        col--;
        if(col<1){
            col=size;
        }
      }
      else{
        row++;
        if(row>size){
            row=1;
        }
      }
      gotoxy1(col,row+1);
      printf("%d",num);
    }
    return 0;
}
