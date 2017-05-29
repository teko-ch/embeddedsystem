# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.contrib import admin
from .models import Contact, ContactMail


class ContactInlineAdmin(admin.TabularInline):
    model = ContactMail


class ContactAdmin(admin.ModelAdmin):
    inlines = [ContactInlineAdmin]
    list_display = ('firstname', 'lastname',)
    search_fields = ('firstname', 'lastname',)


admin.site.register(Contact, ContactAdmin)

