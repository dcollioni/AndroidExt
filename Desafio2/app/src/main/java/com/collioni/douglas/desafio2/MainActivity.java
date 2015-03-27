package com.collioni.douglas.desafio2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    final static String CONTATO_CHAVE = "contato";
    final static String POSICAO_CHAVE = "posicao_contato";

    ListView lvContatos;
    ContatoAdapter adapter;
    ArrayList<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContatos = (ListView) findViewById(R.id.lvContatos);

        contatos = new ArrayList<>();
        contatos.add(new Contato("Ana da Silva", "ana@gmail.com", "99887766", R.drawable.ana));
        contatos.add(new Contato("Bruno dos Santos", "bruno@gmail.com", "88776655", R.drawable.bruno));
        contatos.add(new Contato("Camila Reis", "camila@gmail.com", "77665544", R.drawable.camila));
        contatos.add(new Contato("Daniel Machado", "daniel@gmail.com", "66554433", R.drawable.daniel));

        adapter = new ContatoAdapter(this, contatos);

        lvContatos.setAdapter(adapter);

        lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contato c = (Contato) parent.getItemAtPosition(position);

                Intent i = new Intent(MainActivity.this, DetalheActivity.class);
                i.putExtra(CONTATO_CHAVE, c);
                i.putExtra(POSICAO_CHAVE, position);

                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {

            boolean excluir = data.getBooleanExtra(DetalheActivity.EXCLUIR_CHAVE, false);

            if (excluir) {
                int posicao = data.getIntExtra(DetalheActivity.POSICAO_CHAVE, -1);

                if (posicao > -1) {
                    contatos.remove(posicao);
                    adapter.notifyDataSetChanged();
                }
            }
        }
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
