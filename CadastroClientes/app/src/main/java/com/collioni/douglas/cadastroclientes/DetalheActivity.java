package com.collioni.douglas.cadastroclientes;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DetalheActivity extends ActionBarActivity {

    Db4oHelper db4o;
    ClienteDao clienteDao;

    private long clienteId;

    EditText etNome, etEmail, etTelefone, etCidade;
    Button btSalvar, btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        // TODO: pegar o clienteID da Intent

        configurarDb4o();

        carregarElementos();
        atualizarTitulo();

        configurarBtCancelar();
        configurarBtSalvar();
    }

    private void configurarDb4o() {
        // TODO: criar db4oHelper e clienteDao
    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO: abrir conexão e atualizar campos
    }

    @Override
    protected void onPause() {
        super.onPause();
        // TODO: fechar conexão
    }

    private void carregarElementos() {
        etNome = (EditText) findViewById(R.id.et_nome);
        etEmail = (EditText) findViewById(R.id.et_email);
        etTelefone = (EditText) findViewById(R.id.et_telefone);
        etCidade = (EditText) findViewById(R.id.et_cidade);
        btSalvar = (Button) findViewById(R.id.bt_salvar);
        btCancelar = (Button) findViewById(R.id.bt_cancelar);
    }

    private void atualizarTitulo() {
        // TODO: novo cliente ou atualizar cliente
    }

    private void atualizarCampos() {
        // TODO: buscar cliente no banco e atualizar campos
    }

    private void configurarBtCancelar() {
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void configurarBtSalvar() {
        // TODO: pegar valores dos campos e salvar cliente
    }

    private void salvarCliente(Cliente c) {
        // TODO: inserir ou atualizar cliente
    }

    private void trace(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
