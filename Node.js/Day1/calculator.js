var add = function (x, y) {
    if (isNaN(x) || isNaN(y)) {
        console.log("Error! please enter numbers")
    } else {
        console.log(x + y)
    }
}

var sub = function (x, y) {
    if (isNaN(x) || isNaN(y)) {
        console.log("Error! please enter numbers")
    } else {
        console.log(x - y)
    }
}

var mult = function (x, y) {
    if (isNaN(x) || isNaN(y)) {
        console.log("Error! please enter numbers")
    } else {
        console.log(x * y)
    }
}

module.exports = {
    addition: add,
    subtraction: sub,
    multiplication: mult
}