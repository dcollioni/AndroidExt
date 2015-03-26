package com.collioni.douglas.catalogolivros;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AutorDetalheActivity extends ActionBarActivity {

    EditText etNome, etNacionalidade, etAnoNascimento;
    Button btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autor_detalhe);

        etNome = (EditText) findViewById(R.id.et_nome_autor);
        etNacionalidade = (EditText) findViewById(R.id.et_nacionalidade_autor);
        etAnoNascimento = (EditText) findViewById(R.id.et_ano_nascimento_autor);
        btCancelar = (Button) findViewById(R.id.bt_cancelar);

        Intent i = getIntent();

        if (i.hasExtra(AutorActivity.AUTOR_CHAVE)) {
            Autor a = (Autor)
                       i.getSerializableExtra(AutorActivity.AUTOR_CHAVE);

            etNome.setText(a.getNome());
            etNacionalidade.setText(a.getNacionalidade());
            etAnoNascimento.setText(Integer.toString(a.getAnoNascimento()));
        }

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
