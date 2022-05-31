import re
from django.shortcuts import render,HttpResponse,redirect,reverse
from django.http.response import JsonResponse

my_todos={
    'first': {'name':'breakfast','priority':1,'is_finished':False} ,
    'second': {'name':'lunch','priority':2,'is_finished':False},
    'third': {'name':'dinner','priority':3,'is_finished':False}
}

def todo_list(request):
    return render(request , 'todo/todo.html', context={'my_todos':my_todos})

def todo_detail(request, **kwargs):
    todo_key= kwargs.get('todo_name')
    todo_detail=my_todos.get(todo_key)
    return render(request,'todo/todo_detail.html',context={'my_todos':todo_detail})

def todo_done(request, **kwargs):
    todo_key= kwargs.get('todo_name')
    todo_detail=my_todos.get(todo_key)
    todo_detail['is_finished']=True
    return redirect(reverse('todo:lists'))

def delete(request,**kwargs):
    todo_key= kwargs.get('todo_name')
    todo_detail=my_todos.get(todo_key)
    if todo_detail.get('is_finished'):
        my_todos.pop(todo_key)
    return redirect(reverse('todo:lists'))    

def edit(request,**kwargs):
    todo_key= kwargs.get('todo_name')
    todo_detail=my_todos.get(todo_key)
    return render(request,'todo/updateForm.html',context={'my_todos':todo_detail,'todo_key':todo_key})

def update(request, **kwargs):
    todo_key= kwargs.get('todo_name')
    todo_detail=my_todos.get(todo_key)
    todo_detail['name']=request.POST.get('name')
    todo_detail['priority']=request.POST.get('priority')
    return redirect(reverse('todo:lists'))  
