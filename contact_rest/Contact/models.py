# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models
from django.contrib.auth.models import User


class Contact(models.Model):
    firstname = models.CharField(max_length=200)
    lastname = models.CharField(max_length=200)
    owner = models.ForeignKey(User, related_name='contacts')

    def __str__(self):
        return '%s %s' % (self.firstname, self.lastname)


class ContactMail(models.Model):
    mail = models.EmailField()
    contact = models.ForeignKey('Contact', related_name='mails')

    def __str__(self):
        return self.mail
