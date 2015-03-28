package com.collioni.douglas.catalogolivros;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class LivroActivity extends ActionBarActivity {

    final static String LIVRO_CHAVE = "livro";

    ListView lvLivros;
    ArrayAdapter<Livro> adapter;
    ArrayList<Livro> livros;

    Autor autor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);

        lvLivros = (ListView) findViewById(R.id.lvLivros);

        livros = new ArrayList<>();

        adapter = new ArrayAdapter<Livro>(
                            getBaseContext(),
                            android.R.layout.simple_list_item_activated_1,
                            livros);

        lvLivros.setAdapter(adapter);

        Intent i = getIntent();

        if (i.hasExtra(AutorActivity.AUTOR_CHAVE)) {
            autor = (Autor) i.getSerializableExtra(AutorActivity.AUTOR_CHAVE);
            carregarLivros(autor);
            adapter.notifyDataSetChanged();

            atualizarTitulo(autor);
        }

        lvLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Livro l = (Livro) parent.getItemAtPosition(position);

                Intent i = new Intent(LivroActivity.this, LivroDetalheActivity.class);
                i.putExtra(LIVRO_CHAVE, l);

                startActivity(i);
            }
        });

        lvLivros.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        lvLivros.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            ArrayList<Livro> livrosSelecionados = new ArrayList<Livro>();

            @Override
            public void onItemCheckedStateChanged(ActionMode mode,
                                                  int position,
                                                  long id,
                                                  boolean checked) {

                int count = lvLivros.getCheckedItemCount();
                mode.setTitle(Integer.toString(count));

                Livro l = livros.get(position);

                if (checked) {
                    livrosSelecionados.add(l);
                } else {
                    livrosSelecionados.remove(l);
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu_lv_livros, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.menu_compartilhar_livros:

                        String msg = getString(R.string.compartilhar) + ": ";

                        for (Livro l : livrosSelecionados) {
                            msg += "\n" + l.getTitulo();
                        }

                        Toast.makeText(
                                getBaseContext(),
                                msg,
                                Toast.LENGTH_SHORT).show();

                        return true;

                    case R.id.menu_excluir_livros:

                        for (Livro l : livrosSelecionados) {
                            livros.remove(l);
                        }

                        adapter.notifyDataSetChanged();

                        mode.finish();

                        return true;

                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                livrosSelecionados.clear();
            }
        });
    }

    private void atualizarTitulo(Autor a) {
        setTitle(a.getNome());
    }

    private void carregarLivros(Autor a) {
        if (a.getNome().equals("William Shakespeare")) {
            livros.add(new Livro("Hamlet", "Tragédia", 1603));
            livros.add(new Livro("Macbeth", "Tragédia", 1611));
            livros.add(new Livro("Romeu e Julieta", "Tragédia", 1597));
            livros.add(new Livro("Sonho de uma Noite de Verão", "Fantasia", 1605));
        } else if (a.getNome().equals("Victor Hugo")) {
            livros.add(new Livro("Os Miseráveis", "Romance", 1862));
            livros.add(new Livro("Notre-Dame de Paris", "Ficção", 1831));
        } else if (a.getNome().equals("J. K. Rowling")) {
            livros.add(new Livro("Harry Potter e a Pedra Filosofal", "Ficção", 1997));
            livros.add(new Livro("Harry Potter e a Câmara Secreta", "Ficção", 1998));
            livros.add(new Livro("Harry Potter e o Prisioneiro de Azkaban", "Ficção", 1999));
            livros.add(new Livro("Harry Potter e o Cálice de Fogo", "Ficção", 2000));
            livros.add(new Livro("Harry Potter e a Ordem da Fênix", "Ficção", 2003));
            livros.add(new Livro("Harry Potter e o Enigma do Príncipe", "Ficção", 2005));
            livros.add(new Livro("Harry Potter e as Relíquias da Morte", "Ficção", 2007));
        } else if (a.getNome().equals("George R. R. Martin")) {
            livros.add(new Livro("A Guerra dos Tronos", "Ficção", 1996));
            livros.add(new Livro("A Fúria dos Reis", "Ficção", 1998));
            livros.add(new Livro("A Tormenta de Espadas", "Ficção", 2000));
            livros.add(new Livro("O Festim dos Corvos", "Ficção", 2005));
            livros.add(new Livro("A Dança dos Dragões", "Ficção", 2011));
        }
    }

    private void excluirLivros() {
        livros.clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_livro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_novo_livro:
                Intent i = new Intent(
                                LivroActivity.this,
                                LivroDetalheActivity.class);

                startActivity(i);

                return true;

            case R.id.menu_excluir_todos_livros:
                excluirLivros();
                adapter.notifyDataSetChanged();

                return true;

            case R.id.menu_recarregar_livros:
                excluirLivros();
                carregarLivros(autor);
                adapter.notifyDataSetChanged();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
