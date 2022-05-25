#!/bin/bash

function displayMenu {
    local OP=0
    while [ ${OP} -ne 4 ]
    do
        echo -e "1.display invoice\n2.insert invoice\n3.delete invoice\n4.quit" 
        read OP
        case ${OP} in 
            1)
                display
                ;;
            2)
                insert
                ;;
            3)
                delete
                ;;
            4) 
                ;;
            *)
                echo -e "invalid option\n"
        esac
    done
    
}