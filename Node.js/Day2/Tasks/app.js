//First Requirement
var Emitter=require("./emitter")
var emtr= new Emitter()
emtr.on('content',function(){
    console.log("First custom event inheriting from emitter")
})
emtr.emit('content')

//Second Requirement=> Read file line by line
var rl=require("./readline")
rl.on('line', (line) => {
    console.log(line);
});

//Third Requirement=> Rename file
const fs = require('fs');
fs.rename('test.txt', 'info.txt', () => {
  console.log("\nFile Renamed!\n");
})

//Fourth Requirement=> Remove content from file
fs.truncate('info.txt', 0, function(){
    console.log('\nContent of file removed!\n')
})

//Fifth Requirement=> Read from file 
//As Synchronous
var data= fs.readFileSync('../data.json','utf8')
console.log('\n'+data)
//As Asynchronous
fs.readFile('../data.json','utf8',function(err,data){
    if(err) throw err;
    console.log('\n'+data)
})

//Sixth Requirement=> Write inside file
fs.writeFile("info.txt", "Hello ITI", (err) => {
  if (err)
    console.log(err);
  else 
    console.log("File written successfully\n");
});

//Seventh Requirement(Bonus)=> Create directory 
const path = "./new_dir";
fs.access(path, (error) => {
  if (error) {
    fs.mkdir(path, (error) => {
      if (error) {
        console.log(error);
      } else {
        console.log("New Directory created successfully!");
      }
    });
  } else {
    console.log("Given Directory already exists!");
  }
});