package com.collioni.douglas.agendacontatos;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetalheAcitivity extends ActionBarActivity {

    TextView tvNome, tvEmail, tvTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        tvNome = (TextView) findViewById(R.id.tvNome);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvTelefone = (TextView) findViewById(R.id.tvTelefone);

        Contato c = (Contato)
                        getIntent()
                        .getSerializableExtra(
                            MainActivity.CONTATO_CHAVE);

        tvNome.setText(c.getNome());
        tvEmail.setText(c.getEmail());
        tvTelefone.setText(c.getTelefone());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhe, menu);
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
