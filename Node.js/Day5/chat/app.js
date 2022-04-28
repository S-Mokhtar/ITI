import express from 'express';
import { Server } from "socket.io";
import {
  createServer
} from "http";
import path, { dirname } from 'path';
import { fileURLToPath } from 'url';
import faker from '@faker-js/faker';
const __dirname = dirname(fileURLToPath(import.meta.url));
const app = express();
const http = createServer(app);
const io = new Server(http);
io.on('connect', function (client) {
  const randomName = faker.name.findName();
  client.emit('join', function (name) {

    client.nickname = name;
  })
  client.broadcast.emit('addclient', randomName)
  client.on('clientmessage', function (data) {
    data = randomName + ' : ' + data
    client.broadcast.emit('messages', data)

  });


});

app.get('/', function (req, res) {
  res.sendFile(__dirname + '/chat.html')
})
http.listen(3000)