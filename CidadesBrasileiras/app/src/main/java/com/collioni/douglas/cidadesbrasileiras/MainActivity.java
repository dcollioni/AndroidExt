package com.collioni.douglas.cidadesbrasileiras;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    Spinner spRegiao, spEstado, spCidade;
    TextView tvArea, tvPopulacao;
    ImageView ivFoto;

    private void carregarElementos() {

        spRegiao = (Spinner) findViewById(R.id.spRegiao);
        spEstado = (Spinner) findViewById(R.id.spEstado);
        spCidade = (Spinner) findViewById(R.id.spCidade);
        tvArea = (TextView) findViewById(R.id.tvArea);
        tvPopulacao = (TextView) findViewById(R.id.tvPopulacao);
        ivFoto = (ImageView) findViewById(R.id.ivFoto);
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
        // cria um adapter com o array de strings
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                                                getBaseContext(),
                                                R.array.regioes,
                                                android.R.layout.simple_spinner_item);

        // configura o layout padrão para spinners
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // adiciona o adapter no spinner
        spRegiao.setAdapter(adapter);

        // configura o evento de seleção
        spRegiao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CharSequence regiaoSelecionada = (CharSequence)
                                                  parent.getItemAtPosition(position);

                carregarEstados(regiaoSelecionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void configurarSpEstado() {
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
                                                getBaseContext(),
                                                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spEstado.setAdapter(adapter);

        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CharSequence estadoSelecionado = (CharSequence)
                                                 parent.getItemAtPosition(position);

                carregarCidades(estadoSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void configurarSpCidade() {
        ArrayAdapter<Cidade> adapter = new ArrayAdapter<Cidade>(
                                        getBaseContext(),
                                        android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spCidade.setAdapter(adapter);

        spCidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Cidade cidadeSelecionada = (Cidade)
                                            parent.getItemAtPosition(position);

                carregarInformacoesCidade(cidadeSelecionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void carregarEstados(CharSequence regiao) {
        ArrayList<CharSequence> estados = new ArrayList<>();

        if (regiao.equals(getString(R.string.sudeste))) {
            estados = BancoDados.getEstadosSudeste();
        } else if (regiao.equals(getString(R.string.sul))) {
            estados = BancoDados.getEstadosSul();
        }

        ArrayAdapter<CharSequence> adapter = (ArrayAdapter<CharSequence>)
                                             spEstado.getAdapter();

        adapter.clear();
        adapter.addAll(estados);
        spEstado.setAdapter(adapter);
    }

    private void carregarCidades(CharSequence estado) {
        ArrayList<Cidade> cidades = new ArrayList<>();

        if (estado.equals("ES")) {
            cidades = BancoDados.getCidadesES();
        } else if (estado.equals("MG")) {
            cidades = BancoDados.getCidadesMG();
        } else if (estado.equals("RJ")) {
            cidades = BancoDados.getCidadesRJ();
        } else if (estado.equals("SP")) {
            cidades = BancoDados.getCidadesSP();
        } else if (estado.equals("PR")) {
            cidades = BancoDados.getCidadesPR();
        } else if (estado.equals("RS")) {
            cidades = BancoDados.getCidadesRS();
        } else if (estado.equals("SC")) {
            cidades = BancoDados.getCidadesSC();
        }

        ArrayAdapter<Cidade> adapter = (ArrayAdapter<Cidade>)
                                        spCidade.getAdapter();

        adapter.clear();
        adapter.addAll(cidades);
        spCidade.setAdapter(adapter);
    }

    private void carregarInformacoesCidade(Cidade cidade) {
        tvArea.setText(cidade.getExtensao() + " " + getString(R.string.km2));
        tvPopulacao.setText(Integer.toString(cidade.getPopulacao()));
        ivFoto.setImageResource(cidade.getFoto());
    }
}
