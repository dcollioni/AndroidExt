package com.collioni.douglas.tradutorrapido;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;


public class MainActivity extends ActionBarActivity {

    final String URL_TRADUTOR =
            "http://www.worldlingo.com/S3704.3/texttranslate?";

    final String PARAM_IDIOMA_DE = "wl_srclang";
    final String PARAM_IDIOMA_PARA = "wl_trglang";
    final String PARAM_TEXTO = "wl_text";

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
        configurarBtTraduzir();
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

    private void configurarBtTraduzir() {
        btTraduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idiomaDe = spIdiomaDe
                                .getSelectedItem().toString();

                String idiomaPara = spIdiomaPara
                                    .getSelectedItem().toString();

                String texto = etValor.getText().toString();

                String url = URL_TRADUTOR;
                url += PARAM_IDIOMA_DE + "=" + idiomaDe;
                url += "&" + PARAM_IDIOMA_PARA + "=" + idiomaPara;
                url += "&" + PARAM_TEXTO + "=" + texto;

                ConsultaTask ct = new ConsultaTask();
                ct.execute(url);
            }
        });
    }

    private class ConsultaTask
                extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String url = params[0];

            HttpClient client = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet();

            String resultado = "";

            try {

                getRequest.setURI(new URI(url));

                BufferedReader in = null;
                HttpResponse response = null;

                response = client.execute(getRequest);

                in = new BufferedReader(
                        new InputStreamReader(
                                response
                                        .getEntity()
                                        .getContent()));

                StringBuffer buff = new StringBuffer("");
                String line = "";

                while ((line = in.readLine()) != null) {
                    buff.append(line);
                }

                in.close();

                resultado = buff.toString();

                Log.d("TRADUCAO", resultado);

            } catch (Exception e) {
                Log.e("TRADUCAO", e.toString());
            }

            return resultado;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // TODO: atualizar o tvResultado com a string
        }
    }
}


















