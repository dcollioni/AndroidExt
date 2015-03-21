package com.collioni.douglas.agendacontatos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    final static String CONTATO_CHAVE = "CONTATO";

    ListView lvContatos;
    ArrayList<Contato> contatos;
    ArrayAdapter<Contato> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContatos = (ListView)
                      findViewById(R.id.lvContatos);

        contatos = new ArrayList<>();

        contatos.add(new Contato(
                        "Ana da Silva",
                        "ana@gmail.com",
                        "99887766"));

        contatos.add(new Contato(
                        "Bruno Santos",
                        "bruno@outlook.com",
                        "88659781"));

        contatos.add(new Contato(
                        "Camila Reis",
                        "camila@yahoo.com",
                        "45697722"));

        contatos.add(new Contato(
                        "Daniel Machado",
                        "daniel@live.com",
                        "89657782"));

        adapter = new ArrayAdapter<Contato>(
                        getBaseContext(),
                        android.R.layout.simple_list_item_1,
                        contatos);

        lvContatos.setAdapter(adapter);

        lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {

                Contato c = (Contato)
                            parent.getItemAtPosition(position);

                Intent i = new Intent(
                                MainActivity.this,
                                DetalheAcitivity.class);

                i.putExtra(CONTATO_CHAVE, c);

                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
