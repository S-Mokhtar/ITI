#!/bin/bash
USR="moustafa"
PASSWORD=$(cat passfile.txt)
DBNAME="newDb"  
T1="inv_master"
T2="inv_detail"


##exit codes 
#                  0:success
#                  1:invoice not exist
#                  2:invoice already exists
#adding sourc files
source menu.sh
source checker.sh
source db.sh
displayMenu

exit 0 