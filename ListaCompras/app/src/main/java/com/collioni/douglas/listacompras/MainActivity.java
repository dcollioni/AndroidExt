package com.collioni.douglas.listacompras;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    EditText etProduto, etQtd;
    Button btAdicionar;
    ListView lvProdutos;
    ArrayAdapter<ItemCompra> adapter;
    ArrayList<ItemCompra> produtos;

    private void carregarElementos() {
        etProduto = (EditText) findViewById(R.id.etProduto);
        etQtd = (EditText) findViewById(R.id.etQtd);
        btAdicionar = (Button) findViewById(R.id.btAdicionar);
        lvProdutos = (ListView) findViewById(R.id.lvProdutos);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarElementos();
        configurarBtAdicionar();
        configurarLvProdutos();
    }

    private void configurarBtAdicionar() {
        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String produto = etProduto.getText().toString();
                String strQtd = etQtd.getText().toString();

                if (!produto.isEmpty() && !strQtd.isEmpty()) {
                    int qtd = Integer.parseInt(strQtd);

                    // TODO: adicionar item na lista

                    etProduto.setText(null);
                    etProduto.requestFocus();
                    etQtd.setText(null);
                }
            }
        });
    }

    private void configurarLvProdutos() {
        produtos = new ArrayList<>();

        adapter = new ArrayAdapter<ItemCompra>(
                getBaseContext(),
                android.R.layout.simple_list_item_1,
                produtos);

        lvProdutos.setChoiceMode(ListView.CHOICE_MODE_NONE);
        lvProdutos.setAdapter(adapter);

        // TODO: adicionar evento de click

        // TODO: adicionar evento de long click
    }

    private void trace(String msg) {

        Toast.makeText(
                getBaseContext(),
                msg,
                Toast.LENGTH_SHORT).show();
    }
}
