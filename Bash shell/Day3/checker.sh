#!/bin/bash

function checkInvoice {
    local INVID=${1}
    
    local FLAG=$(mysql -u ${USR} -p${PASSWORD}  -sNe "SELECT EXISTS(SELECT '*' FROM ${DBNAME}.${T1} where invID = ${INVID})")
    echo ${FLAG}
}