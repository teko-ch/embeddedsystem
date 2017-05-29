from rest_framework import serializers
from .models import Contact, ContactMail


class ContactMailSerializer(serializers.ModelSerializer):
    class Meta:
        model = ContactMail
        fields = ('mail',)


class ContactListSerlializer(serializers.ModelSerializer):
    class Meta:
        model = Contact
        fields = ('id', 'firstname', 'lastname', 'owner',)


class ContactDetailSerlializer(serializers.ModelSerializer):
    mails = serializers.SlugRelatedField(
        read_only=True,
        many=True,
        slug_field='mail'
    )

    class Meta:
        model = Contact
        fields = ('id', 'firstname', 'lastname', 'mails')
