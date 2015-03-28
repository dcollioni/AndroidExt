package com.collioni.douglas.cadastroclientes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends ActionBarActivity {

    final static String CLIENTE_ID = "clienteId";

    Db4oHelper db4o;
    ClienteDao clienteDao;

    ListView lvClientes;
    ArrayAdapter<Cliente> adapter;
    ArrayList<Cliente> clientes;

    EditText etFiltro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarDb4o();
        configurarLvClientes();
        configurarEtFiltro();
    }

    private void configurarEtFiltro() {
        etFiltro = (EditText) findViewById(R.id.et_filtro);

        etFiltro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                carregarClientes();
            }
        });
    }

    private void configurarDb4o() {
        // pegar o diretório do banco
        String dir = getDir("data", 0) + "/" ;

        // abre o dab4o helper
        db4o = new Db4oHelper(dir);

        // abre o cliente dao
        clienteDao = new ClienteDao(db4o);
    }

    private void configurarLvClientes() {
        lvClientes = (ListView) findViewById(R.id.lv_clientes);

        clientes = new ArrayList<>();

        adapter = new ArrayAdapter<Cliente>(
                        getBaseContext(),
                        android.R.layout.simple_list_item_activated_1,
                        clientes);

        lvClientes.setAdapter(adapter);

        lvClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {

                Cliente c = (Cliente)
                            parent.getItemAtPosition(position);

                long clienteId = clienteDao.buscarId(c);

                Intent i = new Intent(
                                MainActivity.this,
                                DetalheActivity.class);

                i.putExtra(CLIENTE_ID, clienteId);

                startActivity(i);
            }
        });

        lvClientes.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        lvClientes.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            ArrayList<Cliente> clientesSelecionados =
                                            new ArrayList<>();

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                int count = lvClientes.getCheckedItemCount();
                mode.setTitle(Integer.toString(count));

                Cliente c = clientes.get(position);

                if (checked) {
                    clientesSelecionados.add(c);
                } else {
                    clientesSelecionados.remove(c);
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu_lv_clientes, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                final ActionMode modeFinal = mode;

                int id = item.getItemId();

                switch (id) {
                    case R.id.menu_excluir:

                        AlertDialog alert =
                                new AlertDialog
                                        .Builder(MainActivity.this)
                                        .setMessage(R.string.confirma_exclusao)
                                        .setNegativeButton(R.string.nao, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        })
                                        .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                excluirClientes(clientesSelecionados);
                                                modeFinal.finish();
                                            }
                                        })
                                        .create();

                        alert.show();

                        return true;

                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                clientesSelecionados.clear();
            }
        });
    }

    private void excluirClientes(
                    ArrayList<Cliente> clientesSelecionados) {

        for (Cliente c : clientesSelecionados) {
            clienteDao.excluir(c);
        }

        carregarClientes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        db4o.abrirConexao();
        carregarClientes();
    }

    @Override
    protected void onPause() {
        super.onPause();
        db4o.fecharConexao();
    }

    private void carregarClientes() {
        String filtro = etFiltro.getText().toString();

        clientes.clear();
        clientes.addAll(clienteDao.pesquisar(filtro));
        Collections.sort(clientes);
        adapter.notifyDataSetChanged();
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

        switch (id) {
            case R.id.menu_novo_cliente:
                Intent i = new Intent(MainActivity.this, DetalheActivity.class);
                startActivity(i);
                return true;

            case R.id.menu_ordenar_asc:
                Collections.sort(clientes);
                adapter.notifyDataSetChanged();
                return true;

            case R.id.menu_ordenar_desc:
                Collections.sort(clientes);
                Collections.reverse(clientes);
                adapter.notifyDataSetChanged();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}












