from asyncio.windows_events import NULL
import re
from dbConnection import connect

global mydb
mydb = connect()

class Person:
    def __init__(self, full_name, healthRate, money, sleepmood):
        self.full_name = full_name
        if healthRate > 0 and healthRate < 100:
            self.healthRate = healthRate
        else:
            self.healthRate = NULL
        self.money = money
        self.sleepmood = sleepmood

    def buy(self):
        print("Buy : ")

    def sleep(self,hours):
        print("Sleep : ")

    def eat(self,meals):
        print("Eat : ")

class Employee(Person):  
    regex = r'\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,}\b'
    def __init__(self, id, email, workmood, salary, is_manager):
        self.id = id
        self.workmood = workmood
        self.is_manager = is_manager

        if(re.fullmatch(regex, email)):
            self.email = email
        else:
            self.email = NULL

        if salary>=1000:
            self.salary = salary
        else:
            self.salary = NULL

    def work(self,hours):
        if hours==8:
            print("Happy")
        elif hours<8:
            print("Lazy")
        else:
            print("Tired")

    def sendEmail(self, to, subject, body, receiver_name):
        f= open('email.txt','w')
        f.write("To:" +to +"Subject" +subject +"Body" +body +"Receiver name" +receiver_name)
        f.close()

    def sleep(self,hours):
        if hours==7:
            print("Happy")
        elif hours<7:
            print("Tired")
        else:
            print("Lazy")

    def eat(self,meals):
        if meals==3:
            self.healthRate=100
            print("HealthRate:" + self.healthRate)
        elif meals==2:
            self.healthRate=75
            print("HealthRate:" + self.healthRate)
        elif meals==1:
            self.healthRate=50
            print("HealthRate:" + self.healthRate)

    def buy(self,items):
        if items==1:
            self.money-=10
            print("Money:" + self.money)

class Office():
    def __init__(self,name,employees):
        self.name = name
        self.employees = employees

    def get_all_employees(self):
        cur =mydb.cursor(buffered=True)
        cur.execute('select * from employees')
        rows = cur.fetchall()
        for row in rows:
            print(row)

    def get_employee(self,empid):
        cur = mydb.cursor(buffered=True)
        cur.execute(f'select * from employees where id='+empid)
        record=cur.fetchone()
        print(record)

    def fire(self,empId):
        cur =mydb.cursor(buffered=True)
        cur.execute('delete from employees where id=' + empId)
        mydb.commit()

    def hire(self,employee):
        cur = mydb.cursor(buffered=True)
        cur.execute(f'Insert into employees(email, workmood, salary, is_manager) values("{employee["Email"]}", "{employee["Workmood"]}","{employee["Salary"]}", "{employee["Manager"]}")')
        mydb.commit()

flag =True
is_manager= True
while(flag):
    office=Office("ITI",[])
    print("1-Add\n2-Get Employee\n3-Get All Employees\n4-Quit\n")
    choice=input("Enter choice: ")
    if choice=="1":
        print("1-mngr\n2-nrml\n")
        add_choice=input("Enter choice again: ")
        if add_choice=="mngr":
            email=input("Enter email for manager: ")
            is_manager= True
            office.hire({"Email":email, "Workmood":NULL, "Salary":NULL, "Manager":is_manager })
        elif add_choice=="nrml":
            email=input("Enter email for normal user: ")
            is_manager= False
            salary=input("Enter salary: ")
            office.hire({"Email":email, "Workmood":NULL, "Salary":salary, "Manager":is_manager})
    elif choice=="2":
        id=input("Enter ID of employee: ")
        office.get_employee(id)
    elif choice=="3":
        office.get_all_employees()
    else:
        print("Bye bye")
        flag=False
        mydb.close()