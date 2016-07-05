package com.example.jonathan.brutto_netto_rechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ErgebnisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnis);

        final Bundle extras = getIntent().getExtras();

        Log.v("ErgebinsActivity", "BETRAG_ART: "+ extras.getBoolean(FormularActivity.BETRAG_ART));
    }
}
