package ch.teko.contact.contact;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.teko.contact.R;

/**
 * Created by jonathan on 19.06.17.
 */

public class ContactFragmentAdd extends Fragment {
    private View mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_contact_add, container, false);

        ((ContactActivity)getActivity()).setTitle(R.string.add_contact_title);


        return mView;
    }
}
