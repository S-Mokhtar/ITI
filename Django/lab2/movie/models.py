from pickle import TRUE
from django.db import models


class Movie(models.Model):
    name = models.fields.CharField(verbose_name='Movie Name', max_length=50)
    production_year =models.fields.DateField(null=TRUE)
    actors = models.ManyToManyField('actor.actor')
    creation_time =models.DateTimeField(auto_now_add=True,null=TRUE)
    update_time =models.DateTimeField(auto_now=True,null=TRUE)
    def __str__(self):
        return self.name
