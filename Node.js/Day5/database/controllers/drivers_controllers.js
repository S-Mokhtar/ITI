const driver=require('../models/drivers')
module.exports={

    all(req,res,next){
      const limit=parseInt(req.param.limit)||''
      driver.find({}).limit()
      .then(users=>res.status(200).send(users))
      .catch(next)
    },
   createUser(req,res,next){
       const user=req.body
       driver.create(user)
       .then(users=>res.status(200).send(users))
       .catch(next)
   },
   edit(req,res,next){
       const userid=req.param.driver
       const user=req.body
  driver.findByIdAndUpdate({_id: userid},user )

    .then(()=> driver.findById({_id:userid}))
    .then(user => res.status(200).send(user))
    .catch(next)
   },
   delete(req,res,next)
   {
       const userid=req.param.id
       Driver.findByIdAndRemove({_id: userid})
    .then(users => res.status(204).send(users))
    .catch(next)

   },
   details(req,res,next)
   {
       const userid=req.param.id
       driver.findById({_id:userid})
       .then(user=>res.status(200).send(user))
       .catch(next)

   }
}