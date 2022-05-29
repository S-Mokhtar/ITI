from django.urls import path
from .views import todo_list,todo_detail,todo_done,delete,edit,update

app_name='todo'
urlpatterns=[
    path('lists',todo_list, name='lists'),
    path('detail/<str:todo_name>',todo_detail, name='detail'),
    path('done/<str:todo_name>',todo_done, name='done'),
    path('delete/<str:todo_name>',delete, name='delete'),
    path('edit/<str:todo_name>',edit, name='edit'),
    path('update/<str:todo_name>',update, name='update'),
]