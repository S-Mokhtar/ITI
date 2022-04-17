function person() {
    this.getPerson = function (name, bdate) {
        const date = new Date(bdate);
        if (date instanceof Date && isNaN(date.getTime())) {
            console.log("Invalid date");
        }
        else {
            var diff = Date.now() - date.getTime();
            var age_date = new Date(diff);
            age = Math.abs(age_date.getUTCFullYear() - 1970);
            if(age <= 3){
                console.log("Not accepted");

            }
            else
            console.log("Hello", name, ", Your age is:", age);
        }
    }

}

module.exports = person;