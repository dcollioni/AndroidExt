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

        registerForContextMenu(lvAutores);
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
            case R.id.menu_novo_autor:
                Intent i = new Intent(
                                AutorActivity.this,
                                AutorDetalheActivity.class);

                startActivity(i);
                return true;

            case R.id.menu_excluir_autores:
                excluirAutores();
                adapter.notifyDataSetChanged();
                return true;

            case R.id.menu_recarregar_autores:
                excluirAutores();
                carregarAutores();
                adapter.notifyDataSetChanged();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.lvAutores) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_lv_autores, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (id) {
            case R.id.menu_editar_autor:
                editarAutor(info.position);
                return true;

            case R.id.menu_excluir_autor:
                excluirAutor(info.position);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    private void editarAutor(int position) {
        Autor a = autores.get(position);

        Intent i = new Intent(
                        AutorActivity.this,
                        AutorDetalheActivity.class);

        i.putExtra(AUTOR_CHAVE, a);

        startActivity(i);
    }

    private void excluirAutor(int position) {
        autores.remove(position);
        adapter.notifyDataSetChanged();
    }
}
