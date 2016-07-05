package com.example.jonathan.brutto_netto_rechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ErgebnisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnis);

        final Bundle extras = getIntent().getExtras();
        Log.v("ErgebinsActivity", "BETRAG_ART: "+ extras.getBoolean(FormularActivity.BETRAG_ART));

        if(extras != null){
            final Ergebnis ergebnis = new Ergebnis();

            ergebnis.betrag = extras.getFloat(FormularActivity.BETRAG_KEY);
            ergebnis.isNetto = extras.getBoolean(FormularActivity.BETRAG_ART);
            ergebnis.mwstProzent = extras.getInt(FormularActivity.MWST_PROZENT);

            zeigeErgebnis(ergebnis);

        }

    }

    private void zeigeErgebnis(Ergebnis ergebnis){
        setTitle("Ergebnis");

        ergebnis.berechneErgebnis();

        final TextView txtNettobetrag = (TextView) findViewById(R.id.txt_nettobetrag);
        txtNettobetrag.setText(String.valueOf(ergebnis.betragNetto));

        final TextView txtMWST = (TextView) findViewById(R.id.txt_umsatzsteuer);
        txtMWST.setText(String.valueOf(ergebnis.betragMwst));

        final TextView txtBruttobetrag = (TextView) findViewById(R.id.txt_bruttobetrag);
        txtBruttobetrag.setText(String.valueOf(ergebnis.betragBrutto));
    }


}
