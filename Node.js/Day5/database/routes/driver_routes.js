const userController=require('../controllers/drivers_controllers')

module.exports=(app)=>
{
    app.get('/api/users',userController.all)
    app.post('/api/users',usersController.creatUser)
    app.put('/api/user/:id',userController.edit)
    app.delete('/api/user/:id',userController.delete)
    app.get('/api/users/:id',userController.details)
}
