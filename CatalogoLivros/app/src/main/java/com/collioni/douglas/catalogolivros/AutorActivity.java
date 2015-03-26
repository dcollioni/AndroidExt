package com.collioni.douglas.catalogolivros;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class AutorActivity extends ActionBarActivity {

    final static String AUTOR_CHAVE = "autor";

    ListView lvAutores;
    ArrayAdapter<Autor> adapter;
    ArrayList<Autor> autores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor);

        lvAutores = (ListView) findViewById(R.id.lvAutores);

        autores = new ArrayList<>();
        carregarAutores();

        adapter = new ArrayAdapter<Autor>(getBaseContext(), android.R.layout.simple_list_item_1, autores);

        lvAutores.setAdapter(adapter);

        lvAutores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Autor a = (Autor) parent.getItemAtPosition(position);

                Intent i = new Intent(AutorActivity.this, LivroActivity.class);
                i.putExtra(AUTOR_CHAVE, a);

                startActivity(i);
            }
        });

        // TODO: registrar lvAutores para ContextMenu
    }

    private void carregarAutores() {
        autores.add(new Autor("William Shakespeare", "Britânico", 1564));
        autores.add(new Autor("Victor Hugo", "Francês", 1802));
        autores.add(new Autor("J. K. Rowling", "Britânica", 1965));
        autores.add(new Autor("George R. R. Martin", "Norte Americano", 1948));
    }

    private void excluirAutores() {
        autores.clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_autor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            // TODO: adicionar tratamento para os itens

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // TODO: implementar método onCreateContextMenu

    // TODO: implementar método onContextItemSelected

    private void editarAutor(int position) {
        // TODO: pegar o autor da lista e abrir a tela de edição
    }

    private void excluirAutor(int position) {
        // TODO: remover o autor da lista pela posição
    }
}
