package com.example.jonathan.example_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Bundle extras = getIntent().getExtras();

        final TextView subject = (TextView) findViewById(R.id.var_subject);
        final WebView message = (WebView) findViewById(R.id.wb_message);

        subject.setText(extras.getString(MainActivity.SUBJECT));
        message.loadData(extras.getString(MainActivity.MESSAGE) ,"text/html; charset=UTF-8", null);
    }
}
