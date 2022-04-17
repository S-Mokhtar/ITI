#include <stdio.h>
#include <stdlib.h>

struct Student{
int id;
char name[10];
int grade[3];
};

struct Student FillStudent();
void PrintStudent(struct Student s);

int main()
{
    int num,ch,i,order,flag=1;
    static int count=0;
    printf("Enter number of students:\n");
    scanf("%d",&num);
    struct Student *st;
    st=(struct Student*)malloc(sizeof(struct Student)*num);
    system("cls");
    if(st!=NULL){
    do{
    printf("1.Add student\n2.Display student\n3.Display all\n4.Exit\nEnter your choice(1-4):\n");
    scanf("%d",&ch);
    switch(ch){
    case 1:
        if(count<num){
          st[count]=FillStudent();
          count++;
        }
        break;
    case 2:
        printf("Enter student order:\n");
        scanf("%d",&order);
        if (order<count){
            PrintStudent(st[order+1]);
        }
        break;
    case 3:
        for(i=0;i<count;i++){
          PrintStudent(st[i]);
         }
         break;
    case 4:
        flag=0;
        break;
    }

  }while(flag);
  free(st);
}
    return 0;
}

struct Student FillStudent(){
    struct Student s;
    printf("Enter student id:");
    scanf("%d",&s.id);
    printf("Enter student Name:");
    scanf("%s",s.name);
    for(int i=0;i<3;i++){
       printf("Enter student grade %d:",i+1);
       scanf("%d",&s.grade[i]);
    }
    return s;
}

void PrintStudent(struct Student s){
    printf("ID is:%d\n",s.id);
    printf("Name is:%s\n",s.name);
    for(int i=0;i<3;i++){
      printf("The %d grade is:%d\n",i+1,s.grade[i]);
    }
}
