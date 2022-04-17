var http = require('http')
var fs = require('fs')
var data = JSON.parse(fs.readFileSync('data.json', 'utf8'));

http.createServer(function (req, res) {
    if (req.url === '/') {
        res.writeHead(200, { 'content-type': "text/html" })
        var html = fs.readFileSync('homepage.html')
        res.write(html)
    }
    else if (req.url === '/signup' && req.method === 'POST') {
        var reqData = "";
        req.on('data', function (chunk) {
            reqData += chunk;
        });
        req.on('end', function () {
            reqData = JSON.parse(reqData);
            checkSignUp(reqData, res);
        });
    }
    else if (req.url === '/login' && req.method === 'POST') {
        var reqData = "";
        req.on('data', function (chunk) {
            reqData += chunk;
        });
        req.on('end', function () {
            reqData = JSON.parse(reqData);
            checkLogin(reqData, res);
        });
    }
    else {
        res.writeHead(404)
        res.write('Error page not found')
        res.end()
    }

}).listen(3000)

function checkLogin(reqData, res) {
    console.log("in function")
    var flag = 0;
    for (var i = 0; i < data.length; i++) {
        console.log(i);
        if (reqData.email === data[i].email && reqData.password === data[i].password) {
            res.writeHead(200, { 'content-type': "text/html" })
            var html = fs.readFileSync('profile.html')
            res.write(html)
            flag = 0;
            break;
        }
        else if (data[i].email === reqData.email && data[i].password !== reqData.password) {
            res.writeHead(400)
            res.write('You entered wrong password ')
            flag = 0;
            break;
        }
        else if (data[i].email !== reqData.email && data[i].password === reqData.password) {
            res.writeHead(400)
            res.write('You entered wrong email ')
            flag = 0;
            break;
        }
        else {
            flag = 1;
        }
    }
    if (flag == 1) {
        res.writeHead(400)
        res.write('Email not exist! Please sign up')
    }
    res.end()
}
function checkSignUp(reqData, res) {
    var flag = 0;
    for (var i = 0; i < data.length; i++) {
        if (data[i].email === reqData.email) {
            flag = 1;
            break;
        }
    }
    if (flag == 0) {
        data.push(reqData);
        fs.writeFile("data.json", JSON.stringify(data), (err) => {
            if (err) throw err;
        });
        var html = fs.readFileSync('profile.html')
        res.write(html)
    }
    else {
        res.writeHead(400)
        res.write('Email already exit ')
    }
    res.end()
}