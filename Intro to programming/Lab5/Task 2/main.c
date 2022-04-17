#include <stdio.h>
#include <stdlib.h>
#include <String.h>
void concat(char fn[],char ln[]);
int main()
{
    char fn[10],ln[10],FullName[20];
    printf("Enter your first name:\n");
    gets(fn);
    printf("Enter your second name:\n");
    gets(ln);
    strcpy(FullName,fn);
    strcat(FullName," ");
    strcat(FullName,ln);
    printf("%s",FullName);
    return 0;
}

/*void concat(char Fname[10],char Lname[10]){
char FullName[20];
int i=0;
int s=strlen(Fname);
for(i;i<s;i++){
    FullName[i]=Fname[i];
}
FullName[s]='\0';
int start=s+1;
int j=0;
for(start;start<strlen(Lname);start++,j++){
       FullName[start]=Lname[j];
}
printf("%s",FullName);
}*/
