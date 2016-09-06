package ch.teko.jonathan.amando5;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GeokontaktAuflisten extends ListActivity {

    private String[] NAMEN =new String[5];

    private ArrayAdapter<String> mKontaktAdpater;

    private void initialisierungNamen(){
        NAMEN[0] = "Hans Muster 1";
        NAMEN[1] = "Hans Muster 3";
        NAMEN[2] = "Hans Muster 5";
        NAMEN[3] = "Hans Muster 4";
        NAMEN[4] = "Hans Muster 3";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geokontakt_auflisten);

        zeigeGeokontakte();
    }

    private void zeigeGeokontakte(){
        initialisierungNamen();

        mKontaktAdpater = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, NAMEN);

        setListAdapter(mKontaktAdpater);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        final Toast hinweis = Toast.makeText(this,
                "Element " + ((TextView) v).getText(),
                Toast.LENGTH_LONG);

        hinweis.show();
    }


}
