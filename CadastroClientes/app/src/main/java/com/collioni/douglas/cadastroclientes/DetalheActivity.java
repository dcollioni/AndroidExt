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

        Intent i = getIntent();
        clienteId = i.getLongExtra(MainActivity.CLIENTE_ID, 0);

        configurarDb4o();

        carregarElementos();
        atualizarTitulo();

        configurarBtCancelar();
        configurarBtSalvar();
    }

    private void configurarDb4o() {
        String dir = getDir("data", 0) + "/";
        db4o = new Db4oHelper(dir);
        clienteDao = new ClienteDao(db4o);
    }

    @Override
    protected void onResume() {
        super.onResume();
        db4o.abrirConexao();

        if (clienteId > 0) {
            atualizarCampos();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        db4o.fecharConexao();
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
        if (clienteId == 0) {
            setTitle(R.string.novo_cliente);
        } else {
            setTitle(R.string.atualizar_cliente);
        }
    }

    private void atualizarCampos() {
        Cliente c = clienteDao.buscar(clienteId);

        etNome.setText(c.getNome());
        etEmail.setText(c.getEmail());
        etTelefone.setText(c.getTelefone());
        etCidade.setText(c.getCidade());
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
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();
                String email = etEmail.getText().toString();
                String telefone = etTelefone.getText().toString();
                String cidade = etCidade.getText().toString();

                if (nome.isEmpty() || email.isEmpty() ||
                    telefone.isEmpty() || cidade.isEmpty()) {

                    trace(getString(
                            R.string.preencha_todos_campos));

                    return;
                }

                Cliente c = new Cliente(nome,
                                        email,
                                        telefone,
                                        cidade);

                salvarCliente(c);

                finish();
            }
        });
    }

    private void salvarCliente(Cliente c) {
        if (clienteId == 0) {

            clienteDao.inserir(c);

        } else {

            clienteDao.atualizar(c, clienteId);
        }
    }

    private void trace(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
















