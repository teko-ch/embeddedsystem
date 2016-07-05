package com.example.jonathan.brutto_netto_rechner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class FormularActivity extends AppCompatActivity {
    public static final String BETRAG_KEY = "betrag";
    public static final String BETRAG_ART = "art";
    public static final String MWST_PROZENT = "mwst";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular);

    }


    public void onClickBerechnen(View Button) {
        final EditText txtBetrag = (EditText) findViewById(R.id.edt_betrag);

        final String tmpBetrag = txtBetrag.getText().toString();
        float betrag = 0.0f;
        if(tmpBetrag.length() >0) {
            betrag = Float.parseFloat(tmpBetrag);
        }

        Log.v("FormularActivity", "Betrag: " + betrag);


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

        intent.putExtra(BETRAG_KEY, betrag);
        intent.putExtra(BETRAG_ART, isNetto);
        intent.putExtra(MWST_PROZENT, prozentwert);

        startActivity(intent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.opt_beenden:
                finish();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
