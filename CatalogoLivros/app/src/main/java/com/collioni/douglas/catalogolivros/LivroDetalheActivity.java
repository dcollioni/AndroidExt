package com.collioni.douglas.catalogolivros;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LivroDetalheActivity extends ActionBarActivity {

    EditText etTitulo, etGenero, etAnoPublicacao;
    Button btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro_detalhe);

        etTitulo = (EditText) findViewById(R.id.et_titulo_livro);
        etGenero = (EditText) findViewById(R.id.et_genero_livro);
        etAnoPublicacao = (EditText) findViewById(R.id.et_ano_publicacao_livro);
        btCancelar = (Button) findViewById(R.id.bt_cancelar);

        Intent i = getIntent();

        if (i.hasExtra(LivroActivity.LIVRO_CHAVE)) {
            Livro l = (Livro)
                    i.getSerializableExtra(LivroActivity.LIVRO_CHAVE);

            etTitulo.setText(l.getTitulo());
            etGenero.setText(l.getGenereo());
            etAnoPublicacao.setText(Integer.toString(l.getAnoPublicacao()));
        }

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
