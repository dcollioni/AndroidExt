package com.collioni.douglas.consultacep;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;


public class MainActivity extends ActionBarActivity {

    final String URL_CEP = "http://correiosapi.apphb.com/cep/";

    /*
    * {"cep":"93037070",
    * "tipoDeLogradouro":"Rua",
    * "logradouro":"Doralina Silveira Dias",
    * "bairro":"Santa Teresa",
    * "cidade":"São Leopoldo",
    * "estado":"RS"}
    * */

    EditText etCep;
    Button btBuscar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCep = (EditText) findViewById(R.id.et_cep);
        btBuscar = (Button) findViewById(R.id.bt_buscar);
        tvResultado = (TextView) findViewById(R.id.tv_resultado);

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cep = etCep.getText().toString();
                String url = URL_CEP + cep;

                ConsultaTask ct = new ConsultaTask();
                ct.execute(url);
            }
        });
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

    private class ConsultaTask
            extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            publishProgress();

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
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject json = new JSONObject(s);

                String tipoLogradouro =
                        json.getString("tipoDeLogradouro");

                String logradouro =
                        json.getString("logradouro");

                String bairro =
                        json.getString("bairro");

                String cidade =
                        json.getString("cidade");

                String estado =
                        json.getString("estado");

                tvResultado.setText(
                        tipoLogradouro + " "
                        + logradouro + " - " + bairro
                        + " - " + cidade + " - " + estado
                );

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}













