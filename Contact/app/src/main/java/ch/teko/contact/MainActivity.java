package ch.teko.contact;

import android.app.ListActivity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import ch.teko.contact.contact.ContactActivity;

public class MainActivity extends ListActivity {
    private String TAG = this.getClass().getSimpleName();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private String[] NAMEN =new String[5];
    private ArrayAdapter<String> mContactList;

    private void initName(){
        NAMEN[0] = "Hans Muster 1";
        NAMEN[1] = "Hans Muster 3";
        NAMEN[2] = "Hans Muster 5";
        NAMEN[3] = "Hans Muster 4";
        NAMEN[4] = "Hans Muster 3";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        // Define AuthState Listener
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mAuth.getCurrentUser();
                if(user == null){
                    Log.d(TAG, "Nicht authentifizierter Benutzer");
                    startActivity(new Intent(getBaseContext(), SignInActivity.class));
                }else{
                    Log.d(TAG, "Current User: " + user.getEmail());
                }
            }
        };

        startActivity(new Intent(getBaseContext(), ContactActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.default_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                mAuth.signOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
