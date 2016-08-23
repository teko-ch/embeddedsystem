package com.example.jonathan.html_converter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String HTML = "html";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickConvert(View Button){
        final Intent intent = new Intent(this, ResultActivity.class);
        final EditText txt_html = (EditText) findViewById(R.id.edt_text);

        intent.putExtra(HTML,txt_html.getText().toString());

        startActivity(intent);
    }
}
