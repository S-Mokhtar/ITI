#include <stdio.h>
#include <stdlib.h>

int main()
{
    char str[10];
    printf("Enter 10 characters:\n");
    gets(str);
    copy(str);
    return 0;
}

void copy(char arr1[10]){
char arr2[10];
for(int i=0;i<10;i++){
    arr2[i]=arr1[i];
}
printf("%s",arr2);
}
