package com.example.jonathan.example_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    public final static String SUBJECT = "subject";
    public final static String MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSendData(View Button){
        final EditText txt_subject = (EditText) findViewById(R.id.edt_subject);
        final EditText txt_message = (EditText) findViewById(R.id.edt_message);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SUBJECT, txt_subject.getText().toString());
        intent.putExtra(MESSAGE, txt_message.getText().toString());

        startActivity(intent);



    }
}
