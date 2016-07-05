package com.example.jonathan.brutto_netto_rechner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class FormularActivity extends AppCompatActivity {
    public static final String BETRAG_ART = "art";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular);

    }



    public void onClickBerechnen(View Button) {
        final EditText txtBetrag = (EditText) findViewById(R.id.edt_betrag);
        final String tmpBetrag = txtBetrag.getText().toString();
        Log.v("FormularActivity", "Betrag: " + tmpBetrag);


        boolean isNetto = true;
        final RadioGroup rg = (RadioGroup) findViewById(R.id.rg_art);
        switch (rg.getCheckedRadioButtonId()){
            case R.id.rb_art_netto:
                isNetto = true;
                break;
            case R.id.rb_art_brutto:
                isNetto = false;
                break;
            default:
        }
        Log.v("FormularActivity", "RadioGroup: "+isNetto);

        final Spinner spinner = (Spinner) findViewById(R.id.sp_umsatzsteuer);
        final int pos = spinner.getSelectedItemPosition();
        Log.v("FormularActivity", "Spinner selected item position: " + pos);

        final int[] prozentwerte = getResources().getIntArray(R.array.ust_wert);
        final int prozentwert = prozentwerte[pos];
        Log.v("FormularActivity", "Prozent: " + prozentwert);


        final Intent intent = new Intent(this, ErgebnisActivity.class);

        intent.putExtra("BETRAG_KEY", tmpBetrag);
        intent.putExtra(BETRAG_ART, isNetto);
        intent.putExtra("UST_PROZENT", prozentwert);

        startActivity(intent);


    }
}
