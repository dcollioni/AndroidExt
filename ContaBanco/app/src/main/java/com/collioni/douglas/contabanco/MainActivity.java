package com.collioni.douglas.contabanco;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    RadioGroup rgTipoPessoa;
    EditText etCpfCnpj, etNumeroConta;
    CheckBox cbCartao, cbSeguro, cbTalao;
    Button btnConcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgTipoPessoa = (RadioGroup) findViewById(R.id.rgTipoPessoa);
        etCpfCnpj = (EditText) findViewById(R.id.etCpfCnpj);
        cbCartao = (CheckBox) findViewById(R.id.cbCartao);
        cbSeguro = (CheckBox) findViewById(R.id.cbSeguro);
        cbTalao = (CheckBox) findViewById(R.id.cbTalao);
        btnConcluir = (Button) findViewById(R.id.btnConcluir);
        etNumeroConta = (EditText) findViewById(R.id.etNumeroConta);

        rgTipoPessoa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbPF) {
                    etCpfCnpj.setHint(R.string.cpf);
                }
                else if (checkedId == R.id.rbPJ) {
                    etCpfCnpj.setHint(R.string.cnpj);
                }
            }
        });

        cbCartao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(
                    CompoundButton buttonView,
                    boolean isChecked) {

                if (isChecked) {
                    cbSeguro.setEnabled(true);
                } else {
                    cbSeguro.setEnabled(false);
                    cbSeguro.setChecked(false);
                }
            }
        });

        btnConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroConta = etNumeroConta.getText().toString();

                int rbId = rgTipoPessoa.getCheckedRadioButtonId();
                RadioButton rbPessoa = (RadioButton) findViewById(rbId);
                String tipoPessoa = rbPessoa.getText().toString();
                String tipo = rbId == R.id.rbPF ?
                                    getString(R.string.cpf) :
                                    getString(R.string.cnpj);

                String cpfCnpj = etCpfCnpj.getText().toString();
                String cartao = cbCartao.isChecked() ? "Sim" : "Não";
                String seguro = cbSeguro.isChecked() ? "Sim" : "Não";
                String talao = cbTalao.isChecked() ? "Sim" : "Não";

                String msg = getString(R.string.n_conta) + ": " + numeroConta;
                msg += "\n" + "Tipo: " + tipoPessoa;
                msg += "\n" + tipo + ": " + cpfCnpj;
                msg += "\n" + cbCartao.getText().toString() + ": " + cartao;
                msg += "\n" + cbSeguro.getText().toString() + ": " + seguro;
                msg += "\n" + cbTalao.getText().toString() + ": " + talao;

                Toast.makeText(
                        getBaseContext(),
                        msg,
                        Toast.LENGTH_LONG).show();
            }
        });

    } // fecha onCreate


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
