package ch.teko.contact;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;


public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    protected String TAG = this.getClass().getSimpleName();

    protected FirebaseAuth mAuth;

    /*
     * Views
     */
    private EditText mEmailField;
    private EditText mPasswordField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        setTitle("Sign In");

        mAuth = FirebaseAuth.getInstance();

        // View
        mEmailField = (EditText) findViewById(R.id.login_fld_email);
        mPasswordField = (EditText) findViewById(R.id.login_fld_password);

        // Set listener to Login Button
        findViewById(R.id.login_btn_login).setOnClickListener(this);
        findViewById(R.id.signin_register).setOnClickListener(this);

    }

    private void signInWithMail(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()){
                        Toast.makeText(SignInActivity.this, "Fehler", Toast.LENGTH_SHORT).show();
                    }
                    if(task.isSuccessful()){
                        startActivity(new Intent(getBaseContext(), MainActivity.class));
                        finish();
                    }
                }
        });
    }


    @Override
    public void onClick(View v) {
        // Login Button
        if(v.getId() == R.id.login_btn_login){
            this.signInWithMail(mEmailField.getText().toString(), mPasswordField.getText().toString());
        }
        if(v.getId() == R.id.signin_register){
            startActivity(new Intent(getBaseContext(), RegisterActivity.class));
        }
    }
}
