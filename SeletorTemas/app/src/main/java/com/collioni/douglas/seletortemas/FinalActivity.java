package com.collioni.douglas.seletortemas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FinalActivity extends ActionBarActivity {

    TextView tvTemaSelecionado;
    LinearLayout layoutFinal;
    Button btAvaliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        tvTemaSelecionado = (TextView)
                            findViewById(R.id.tvTemaSelecionado);

        layoutFinal = (LinearLayout)
                        findViewById(R.id.layoutFinal);

        btAvaliar = (Button)
                        findViewById(R.id.btAvaliar);

        Intent i = getIntent();

        String temaSelecionado = i.getStringExtra(
                                    TemasActivity.TEMA_CHAVE);

        tvTemaSelecionado.setText(temaSelecionado);

        if (temaSelecionado.equals(getString(R.string.azul))) {
            layoutFinal.setBackgroundResource(R.color.azul);
        } else if (temaSelecionado.equals(getString(R.string.vermelho))) {
            layoutFinal.setBackgroundResource(R.color.vermelho);
        } else if (temaSelecionado.equals(getString(R.string.amarelo))) {
            layoutFinal.setBackgroundResource(R.color.amarelo);
        } else if (temaSelecionado.equals(getString(R.string.verde))) {
            layoutFinal.setBackgroundResource(R.color.verde);
        }

        btAvaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                                FinalActivity.this,
                                AvaliarActivity.class);

                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            String avaliacao = data.getStringExtra(
                    AvaliarActivity.AVALIACAO_CHAVE);

            Toast.makeText(
                    getBaseContext(),
                    avaliacao,
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_final, menu);
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
