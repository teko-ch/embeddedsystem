from django.contrib.auth.models import User
from django.db.models.signals import post_save, post_delete
from django.contrib.auth.signals import user_logged_out, user_logged_in
from django.dispatch import receiver
from rest_framework.authtoken.models import Token

@receiver(user_logged_in, sender=User)
@receiver(post_save, sender=User)
def create_token(sender, instance=None, created=False, **kwargs):
    if created:
        Token.objects.create(user=instance)
    else:
        Token.objects.get_or_create(user=instance)

