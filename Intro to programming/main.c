#include <stdio.h>
#include <stdlib.h>
#include<conio.h>

int main()
{   int key;
    printf("Enter your charachter");
    key=getch();
    if(key==224)//
        {printf("\n IT'S AN EXTENDED KEY");
        key=getch();
        printf("\n ASCII= %d",key);}
     else
        { if(isprint(key))
          {
              printf("\n %c is printable\n",key);
          }
          else
            printf("%d",key);
        }
    return 0;
}
