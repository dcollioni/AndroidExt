package com.collioni.douglas.desafio2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DetalheActivity extends ActionBarActivity {

    final static String EXCLUIR_CHAVE = "excluir_contato";
    final static String POSICAO_CHAVE = "posicao_contato";

    TextView tvNome, tvEmail, tvTelefone;
    ImageView ivFoto;
    Button btExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        tvNome = (TextView) findViewById(R.id.tvNome);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvTelefone = (TextView) findViewById(R.id.tvTelefone);
        ivFoto = (ImageView) findViewById(R.id.ivFoto);
        btExcluir = (Button) findViewById(R.id.btExcluir);

        Contato c = (Contato) getIntent().getSerializableExtra(MainActivity.CONTATO_CHAVE);

        tvNome.setText(c.getNome());
        tvEmail.setText(c.getEmail());
        tvTelefone.setText(c.getTelefone());
        ivFoto.setImageResource(c.getFoto());

        final int posicao = getIntent().getIntExtra(MainActivity.POSICAO_CHAVE, -1);

        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra(EXCLUIR_CHAVE, true);
                i.putExtra(POSICAO_CHAVE, posicao);

                setResult(1, i);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalhe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
