# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.apps import AppConfig


class ContactConfig(AppConfig):
    name = 'Contact'

    def ready(self):
        import Contact.signals
