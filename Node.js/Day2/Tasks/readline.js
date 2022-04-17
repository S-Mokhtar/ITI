const fs = require('fs');
const readline = require('readline');

const file = readline.createInterface({
    input: fs.createReadStream('greet.txt'),
    output: process.stdout,
    terminal: false
});

module.exports=file;