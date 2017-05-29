# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from rest_framework import viewsets
from rest_framework.decorators import detail_route
from rest_framework.response import Response

from .searializers import ContactListSerlializer, ContactDetailSerlializer
from .models import Contact, ContactMail


class ContactListView(viewsets.ModelViewSet):
    queryset = Contact.objects.all()
    serializer_class = ContactListSerlializer

    @detail_route(
        methods=['post'],
        url_path='add-mail',
        serializer_class=ContactDetailSerlializer
    )
    def add_mail(self, request, pk=None):
        # Get Contact
        contact = Contact.objects.get(pk=pk)
        # Looking for mail address with current contact
        mail, created = ContactMail.objects.get_or_create(mail=request.data['mail'], contact=contact)
        if created:
            return Response({'created': mail.mail})
        return Response({'mail exists'})

    def get_serializer_class(self):
        if self.action == 'list':
            return ContactListSerlializer
        return ContactDetailSerlializer

