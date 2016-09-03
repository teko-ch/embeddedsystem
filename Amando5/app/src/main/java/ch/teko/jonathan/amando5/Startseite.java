package ch.teko.jonathan.amando5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Startseite extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.startseite);
        setTitle(R.string.startseite_titel);
    }

    /**
     * Wird bei Klick auf Schaltflaeche 'Position senden'
     * aufgerufen.
     *
     * @param sfNormal Schaltfläche
     */
    public void onClickPositionSenden(final View sfNormal) {
        final Intent intent = new Intent(this, PositionSenden.class);
        startActivity(intent);
    }

    /**
     * Wird bei Klick auf Schaltflaeche 'Geokontakte'
     * aufgerufen.
     *
     * @param sfNormal Schaltfläche
     */
    public void onClickGeokontakteVerwalten(final View sfNormal) {
        Context context = getApplicationContext();
        CharSequence text = this.getString(R.string.ts_geo_manage);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    /**
     * Wird bei Klick auf Schaltflaeche 'Karte
     * anzeigen' aufgerufen.
     *
     * @param sfNormal Schaltfläche
     */
    public void onClickKarteAnzeigen(final View sfNormal) {
        final Intent intent = new Intent(this, KarteAnzeigen.class);
        startActivity(intent);
    }

    /**
     * Wird bei Klick auf Schaltflaeche 'Simulation
     * starten' aufgerufen.
     *
     * @param sfNormal Schaltfläche
     */
    public void onClickSimulationStarten(final View sfNormal){
        Context context = getApplicationContext();
        CharSequence text = this.getString(R.string.ts_sim_started);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.hauptmenue, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opt_einstellungenBearbeiten:
                startActivity(new Intent(this,
                        EinstellungenBearbeiten.class));
                return true;
            case R.id.opt_hilfe:
                startActivity(new Intent(this,
                        HilfeAnzeigen.class));
                return true;
            case R.id.opt_amandoBeenden:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
