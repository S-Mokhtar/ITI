const mongoose=require('mongoose')
const schema=mongoose.schema

const UserSchema=new schema({
    email:{
        type:String,
        required:true
    },
    username:{
        type:String,
        unique:true,
        required:true

    },
    password:{
        type:String
    },
    firstname:{
        type:String
    },
    lastname:{
        type:String
    }
})