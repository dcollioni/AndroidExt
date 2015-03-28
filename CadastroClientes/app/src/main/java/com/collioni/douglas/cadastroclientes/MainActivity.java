package com.collioni.douglas.cadastroclientes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    final static String CLIENTE_ID = "clienteId";

    Db4oHelper db4o;
    ClienteDao clienteDao;

    ListView lvClientes;
    ArrayAdapter<Cliente> adapter;
    ArrayList<Cliente> clientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarDb4o();
        configurarLvClientes();
    }

    private void configurarDb4o() {
        // TODO: criar db4oHelper e clienteDao
    }

    private void configurarLvClientes() {
        lvClientes = (ListView) findViewById(R.id.lv_clientes);

        clientes = new ArrayList<>();

        adapter = new ArrayAdapter<Cliente>(
                        getBaseContext(),
                        android.R.layout.simple_list_item_activated_1,
                        clientes);

        lvClientes.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // TODO: abrir conexão e carregar clientes
    }

    @Override
    protected void onPause() {
        super.onPause();

        // TODO: fechar conexão
    }

    private void carregarClientes() {

        // TODO: carregar clientes do banco e atualizar adapter
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
