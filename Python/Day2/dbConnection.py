import mysql.connector

def connect():
    mydb = mysql.connector.connect(
        host="localhost",
        user="root",
        password="",
        database='python2'
    )
    return mydb