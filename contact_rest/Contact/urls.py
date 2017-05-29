from rest_framework import routers
from .views import ContactListView

router = routers.SimpleRouter()
router.register(r'contact', ContactListView, base_name='contact')

urlpatterns = router.urls