package com.collioni.douglas.seletortemas;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class AvaliarActivity extends ActionBarActivity {

    final static String AVALIACAO_CHAVE = "AVALIACAO";

    RadioGroup rgAvaliacao;
    Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliar);

        rgAvaliacao = (RadioGroup) findViewById(R.id.rgAvaliacao);
        btEnviar = (Button) findViewById(R.id.btEnviar);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rbSelecionado = rgAvaliacao
                                    .getCheckedRadioButtonId();

                String avaliacao = ((RadioButton)
                                    findViewById(rbSelecionado))
                                    .getText()
                                    .toString();

                Intent i = new Intent();
                i.putExtra(AVALIACAO_CHAVE, avaliacao);

                setResult(1, i);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_avaliar, menu);
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
