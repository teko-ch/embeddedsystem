package ch.teko.contact.contact;

import android.app.DownloadManager;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import ch.teko.contact.R;
import ch.teko.contact.db.Contact;
import ch.teko.contact.db.ContactDao;


/**
 * Created by jonathan on 19.06.17.
 */

public class ContactFragmentList extends Fragment {
    private View mView;
    private RecyclerView mRecycler;
    private FloatingActionButton mAddButton;

    private ContactAdapter contactAdapter;
    private ContactDao contactDao;
    private Query<Contact> contactQuery;

    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactDao = ((ContactActivity)getActivity()).contactDao();
        contactQuery = contactDao.queryBuilder().orderDesc(ContactDao.Properties.Name).build();

        //contactDao.insert(new Contact(0, "test name"));

    }

    @Override
    public void onResume() {
        super.onResume();

        ((ContactActivity)getActivity()).setTitle("Contact List");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_contact_list, container, false);

        mAddButton = (FloatingActionButton) mView.findViewById(R.id.fab_add);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ContactActivity)getActivity()).goAddFragment();
            }
        });

        mRecycler = (RecyclerView) mView.findViewById(R.id.contact_recyler);
        mRecycler.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecycler.setLayoutManager(mLayoutManager);

        contactAdapter = new ContactAdapter();
        mRecycler.setAdapter(contactAdapter);

        updateContacts();
        return mView;
    }

    private void updateContacts() {
        List<Contact> contacts = contactQuery.list();
        contactAdapter.setContacts(contacts);
    }
}
