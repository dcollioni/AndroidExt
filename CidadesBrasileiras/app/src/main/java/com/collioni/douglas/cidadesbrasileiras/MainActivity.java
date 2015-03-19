package com.collioni.douglas.cidadesbrasileiras;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    // TODO: declarar os spinners aqui

    TextView tvArea, tvPopulacao;

    private void carregarElementos() {
        // TODO: carregar os spinners aqui

        tvArea = (TextView) findViewById(R.id.tvArea);
        tvPopulacao = (TextView) findViewById(R.id.tvPopulacao);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarElementos();

        configurarSpRegiao();
        configurarSpEstado();
        configurarSpCidade();
    }

    private void configurarSpRegiao() {
        // TODO: preencher
    }

    private void configurarSpEstado() {
        // TODO: preencher
    }

    private void configurarSpCidade() {
        // TODO: preencher
    }

    private void carregarEstados(CharSequence regiao) {
        // TODO: preencher
    }

    private void carregarCidades(CharSequence estado) {
        // TODO: preencher
    }

    private void carregarInformacoesCidade(Cidade cidade) {
        // TODO: preencher
    }
}
