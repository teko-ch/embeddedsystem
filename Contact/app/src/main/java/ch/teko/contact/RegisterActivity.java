package ch.teko.contact;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    protected String TAG = this.getClass().getSimpleName();

    private FirebaseAuth mAuth;

    private EditText mEmailField;
    private EditText mPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("Register");

        mAuth = FirebaseAuth.getInstance();

        //Views
        mEmailField = (EditText) findViewById(R.id.register_fld_email);
        mPasswordField = (EditText) findViewById(R.id.register_fld_password);

        // Buttons
        findViewById(R.id.register_btn_login).setOnClickListener(this);
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Shit",
                                    Toast.LENGTH_SHORT).show();
                        }else {
                            startActivity(new Intent(getBaseContext(), MainActivity.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.register_btn_login){
            Log.d(TAG, "Register Button" + mEmailField.getText().toString() + mPasswordField.getText().toString());
            createAccount(mEmailField.getText().toString(), mPasswordField.getText().toString());
        }

    }
}
