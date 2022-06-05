from django.forms import ModelForm
from .models import Actor


class ActorForm(ModelForm):
    class Meta:
        model = Actor
        fields = '__all__'

    def as_my_custom_display(self):
        return "<h1>HIii</h1>"

    #  def save()
            #self.model.obejcts.create(name=name)
