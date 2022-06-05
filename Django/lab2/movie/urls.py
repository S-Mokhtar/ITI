from django.urls import path
from .views import movies_list, movie_create, movie_detail,movie_update,movie_delete

app_name = 'movie'

urlpatterns = [
    path('list', movies_list, name='list'),
    path('movie/create', movie_create, name='create'),
    path('movie/delete/<int:pk>', movie_delete, name='delete'),
    path('movie/<int:pk>', movie_detail, name='detail'),
    path('update/<int:pk>', movie_update, name='update'),

]
