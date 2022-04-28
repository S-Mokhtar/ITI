const express=require('express')
const app=express()
const mongoose=require('mongoose')
const index_routes=require('./routes/index_routes')
const driver_routes=require('./routes/driver_routes')


mongoose.connect('mongodb://localhost/userdb',{
    useNewUrlParser: true,
  useUnifiedTopology: true
})


app.use(express.json())
index_routes(app)

module.exports=app;