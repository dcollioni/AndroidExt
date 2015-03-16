package com.collioni.douglas.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    final String EMAIL_CORRETO = "teste@email.com";
    final String SENHA_CORRETA = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // busca os elementos da tela pelo id
        Button btnEntrar = (Button) findViewById(R.id.btnEntrar);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etSenha = (EditText) findViewById(R.id.etSenha);
        Button btnLimpar = (Button) findViewById(R.id.btnLimpar);

        // adiciona evento de clique no botão
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pega o texto do campo etEmail
                String email = etEmail.getText().toString();

                // pega o texto do campo etSenha
                String senha = etSenha.getText().toString();

                //trace(email + " - " + senha);

                if (email.equals(EMAIL_CORRETO) && senha.equals(SENHA_CORRETA)) {
                    trace(getString(R.string.bem_vindo));
                } else {
                    trace(getString(R.string.info_invalidas));
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alert = new AlertDialog.Builder(MainActivity.this)
                                            .setTitle(getString(R.string.confirmar))
                                            .setMessage(getString(R.string.deseja_limpar))
                                            .setNegativeButton(R.string.nao, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    trace(getString(R.string.cancelado));
                                                }
                                            })
                                            .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    etEmail.setText(null);
                                                    etSenha.setText(null);
                                                }
                                            })
                                            .create();
                alert.show();
            }
        });

    } // fecha onCreate

    // recebe uma string e mostra um Toast
    private void trace(String msg) {
        // Mensagem que fecha sozinha
        Toast.makeText(
                getBaseContext(), // esse parâmetro nunca altera
                msg, // mensagem a ser mostrada
                Toast.LENGTH_SHORT).show(); // tempo para fechar
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
