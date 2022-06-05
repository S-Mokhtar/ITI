from django.shortcuts import render, redirect,reverse
from .models import Movie 
from .forms import MovieForm


def movies_list(request):
    return render(request, template_name='movie/movie_list.html', context={'movies': Movie.objects.all()})


#/////////////////////////////////////////////////
def movie_create(request):
    form = MovieForm(data=request.POST or None, files=request.FILES)
    if form.is_valid():
        form.save()
        return redirect('movie:list')

    return render(request, template_name='movie/movie_create.html', context={'form': form})

def movie_detail(request, pk):
    movie= Movie.objects.get(pk=pk)
    return render(request, template_name='movie/movie_detail.html', context={'movie': movie})

def movie_update(request, pk):
    movie = Movie.objects.get(pk=pk)
    if request.method == 'GET':
        form = MovieForm(instance=movie)
        return render(request, template_name='movie/movie_update.html', context={'form': form, 'movie': movie})

    elif request.method == 'POST':
        form = MovieForm(request.POST, instance=movie)
        if form.is_valid():
            form.save()
            return redirect(reverse('movie:list'))

def movie_delete(request, pk):
    movie = Movie.objects.get(pk=pk)
    movie.delete()
    return redirect(reverse('movie:list'))
