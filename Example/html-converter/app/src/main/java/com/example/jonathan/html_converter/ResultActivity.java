package com.example.jonathan.html_converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setTitle("HTML");

        final WebView webView = (WebView) findViewById(R.id.view_html);
        final Bundle extras = getIntent().getExtras();

        webView.loadData(extras.getString(MainActivity.HTML),"text/html; charset=UTF-8", null);
    }
}
