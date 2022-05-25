#!/bin/bash

function create {
    # create database if not exits
    mysql -u ${USR} -p${PASSWORD}  -e "CREATE DATABASE IF NOT EXISTS ${DBNAME}"

    #creat tables if not exists 
    mysql -u ${USR} -p${PASSWORD}  -e "CREATE TABLE IF NOT EXISTS ${DBNAME}.${T1}(invID int PRIMARY KEY,custname varchar(100), invdate date, invtotal float )"
    mysql -u ${USR} -p${PASSWORD}  -e "CREATE TABLE IF NOT EXISTS ${DBNAME}.${T2}(seq int PRIMARY KEY AUTO_INCREMENT,invID int REFERENCES ${DBNAME}.${T1}(invID), itemname varchar(50), unitprice int, quantity int)"
}
#function to display an invoice
function display {
    local INVID 
    read -p "please enter the invoice id to display:" INVID
    set -x 
    [ $(checkInvoice ${INVID}) = 1 ] || exit 1
    echo "###################inv master################################"
    mysql -u ${USR} -p${PASSWORD}  -e "SELECT * FROM ${DBNAME}.${T1} WHERE invID = ${INVID}"
    set +x
    echo  "##################inv details################################"
    mysql -u ${USR} -p${PASSWORD}  -e "SELECT * FROM ${DBNAME}.${T2} WHERE invID = ${INVID}" 2>/dev/null


}

#function to insert into database
function insert {
    local FLAG="y"
    local INVID
    read -p "please enter the invoice id:" INVID
    [ $(checkInvoice ${INVID}) = 0 ] || exit 2
    local CUSTNAME
    read -p "please enter the customer name:" CUSTNAME
    local INVTOTAL
    read -p "please enter the invoice total:" INVTOTAL
    mysql -u ${USR} -p${PASSWORD}  -e "INSERT INTO ${DBNAME}.${T1}(invID,custname,invdate,invtotal) VALUES(${INVID},\"${CUSTNAME}\",curdate(),${INVTOTAL})"
    echo -e "invoice master inserted successfully\n"
    while [ ${FLAG} = "Y" ] || [ ${FLAG} = 'y' ] || [ ${FLAG} = 'YES' ] || [ ${FLAG} = 'yes' ]
    do
    local ITEMNAME
    read -p "please enter the item name:" ITEMNAME
    local UPRICE
    read -p "please enter the unti price:" UPRICE
    local QUANTITY
    read -p "please enter the item quantity:" QUANTITY
    mysql -u ${USR} -p${PASSWORD}  -e "INSERT INTO ${DBNAME}.${T2}(invID,itemname,unitprice,quantity) VALUES(${INVID},\"${ITEMNAME}\",${UPRICE},${QUANTITY})"
    read -p "Do you want to insert another item? Y/N" FLAG
    done
}

# function to delete an invoice from the database
function delete { 
    local INVID 
    read -p "please enter the invoice id to delete:" INVID
    [ $(checkInvoice ${INVID}) = 1 ] || exit 1
    mysql -u ${USR} -p${PASSWORD}  -e "DELETE FROM ${DBNAME}.${T1} WHERE invID = ${INVID}"
    mysql -u ${USR} -p${PASSWORD}  -e "DELETE FROM ${DBNAME}.${T2} WHERE invID = ${INVID}"
}

# function to show all tables contents for testing
function show {
    echo "###############database details################################"
    mysql -u ${USR} -p${PASSWORD}  -e "(SELECT * FROM ${DBNAME}.${T1})"
    mysql -u ${USR} -p${PASSWORD}  -e "SELECT * FROM ${DBNAME}.${T2}"

}

