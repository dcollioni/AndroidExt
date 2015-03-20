package com.collioni.douglas.calculadoraluz;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {

    // declara os elementos da tela
    EditText etKwh;
    RadioGroup rgTipoConta;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // carrega os componentes da tela
        carregarComponentes();

        // aplica evento de click no botão calcular
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // pega o texto digitado no campo kwh
                String kwh = etKwh.getText().toString();

                // verifica se o texto é diferente de vazio
                if (!kwh.isEmpty()) {

                    // converte o texto para um valor double (número decimal)
                    double valorKwh = Double.parseDouble(kwh);

                    // pega o id do radio button selecionado (residencial, comercial ou rural)
                    int rbId = rgTipoConta.getCheckedRadioButtonId();

                    // pega a taxa de acordo com o radio button selecionado
                    double taxa = pegarTaxa(rbId);

                    // calcula o total
                    double total = valorKwh * taxa;

                    // formata o total com dois números decimais
                    String totalFormatado = formatarDouble(total);

                    // mostra uma mensagem com o resultado
                    trace(getString(R.string.total) + " " + totalFormatado);
                } else {
                    // se o campo kwh estiver vazio...
                    // mostra uma mensagem pedindo para informar o valor
                    trace(getString(R.string.informe_valor));
                }
            }
        });
    }

    // carrega os componentes da tela pelos ids
    private void carregarComponentes() {
        etKwh = (EditText) findViewById(R.id.etKwh);
        rgTipoConta = (RadioGroup) findViewById(R.id.rgTipoConta);
        btCalcular = (Button) findViewById(R.id.btCalcular);
    }

    // define a taxa para o cálculo de acordo com o tipo de conta recebido
    private double pegarTaxa(int rbId) {
        double taxa;

        switch (rbId) {
            case R.id.rbResidencial:
                taxa = 0.29;
                break;
            case R.id.rbComercial:
                taxa = 0.25;
                break;
            case R.id.rbRural:
                taxa = 0.2;
                break;
            default:
                taxa = 0;
        }

        return taxa;
    }

    // formata um valor double para ter sempre duas casas após a vírgula
    private String formatarDouble(Double valor) {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        return formatter.format(valor);
    }

    // mostra uma mensagem usando toast
    private void trace(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
