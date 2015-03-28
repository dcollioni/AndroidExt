package com.collioni.douglas.tradutorrapido;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    Spinner spIdiomaDe, spIdiomaPara;
    EditText etValor;
    Button btTraduzir;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarElementos();

        configurarSpinners();
    }

    private void carregarElementos() {
        spIdiomaDe = (Spinner) findViewById(R.id.sp_idioma_de);
        spIdiomaPara = (Spinner) findViewById(R.id.sp_idioma_para);
        etValor = (EditText) findViewById(R.id.et_valor);
        btTraduzir = (Button) findViewById(R.id.bt_traduzir);
        tvResultado = (TextView) findViewById(R.id.tv_resultado);
    }

    private void configurarSpinners() {
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(
                        getBaseContext(),
                        R.array.idiomas,
                        android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spIdiomaDe.setAdapter(adapter);
        spIdiomaPara.setAdapter(adapter);

        spIdiomaPara.setSelection(1);
    }
}
