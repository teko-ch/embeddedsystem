package ch.teko.contact.contact;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ch.teko.contact.MyContactApp;
import ch.teko.contact.R;
import ch.teko.contact.db.Contact;
import ch.teko.contact.db.ContactDao;
import ch.teko.contact.db.DaoSession;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_placeholder, new ContactFragmentList())
                    .commit();
        }
    }


    protected ContactDao contactDao(){
        DaoSession daoSession = ((MyContactApp) getApplication()).getDaoSession();
        return daoSession.getContactDao();
    }

    protected void createContact(String name){
        contactDao().insert(new Contact(null, name));

    }

    protected void goAddFragment(){
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_placeholder, new ContactFragmentAdd())
                .addToBackStack("fragment-list")
                .commit();
    }
}
