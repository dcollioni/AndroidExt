package com.collioni.douglas.paiseseuropeus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    // TODO: declarar ListView

    Button btNenhuma, btUnica1, btUnica2, btMultipla1, btMultipla2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: pegar ListView pelo ID

        btNenhuma = (Button) findViewById(R.id.btNenhuma);
        btUnica1 = (Button) findViewById(R.id.btUnica1);
        btUnica2 = (Button) findViewById(R.id.btUnica2);
        btMultipla1 = (Button) findViewById(R.id.btMultipla1);
        btMultipla2 = (Button) findViewById(R.id.btMultipla2);

        btNenhuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: configurar lista
            }
        });

        btUnica1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: configurar lista
            }
        });

        btUnica2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: configurar lista
            }
        });

        btMultipla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: configurar lista
            }
        });

        btMultipla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: configurar lista
            }
        });
    }
}
