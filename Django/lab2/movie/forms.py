from django.forms import ModelForm
from django import forms
from .models import Movie


class MovieForm(ModelForm):

    # def clean(self):
    #     if self.cleaned_data.get('watch_count'):
    #         if self.cleaned_data.get('watch_count') < 10:
    #             raise forms.ValidationError("Watch count is too low")

    #     return self.cleaned_data

    class Meta:
        model = Movie
        fields = '__all__'
