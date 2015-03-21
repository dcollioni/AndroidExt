package com.collioni.douglas.seletortemas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TemasActivity extends ActionBarActivity {

    final static String TEMA_CHAVE = "TEMA";

    ListView lvTemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);

        lvTemas = (ListView) findViewById(R.id.lvTemas);

        ArrayAdapter<CharSequence> adapter =
                    ArrayAdapter
                        .createFromResource(
                                getBaseContext(),
                                R.array.temas,
                                android.R.layout.simple_list_item_1
                        );

        lvTemas.setAdapter(adapter);

        lvTemas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {


                Intent i = new Intent(
                                TemasActivity.this,
                                FinalActivity.class);

                CharSequence temaSelecionado = (CharSequence)
                                parent.getItemAtPosition(position);

                i.putExtra(TEMA_CHAVE, temaSelecionado);

                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.wtf("Temas", "onResume Temas");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.wtf("Temas", "onStop Temas");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
