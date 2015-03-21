package com.collioni.douglas.paiseseuropeus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    ListView lvPaises;
    Button btNenhuma, btUnica1, btUnica2, btMultipla1, btMultipla2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPaises = (ListView) findViewById(R.id.lvPaises);
        btNenhuma = (Button) findViewById(R.id.btNenhuma);
        btUnica1 = (Button) findViewById(R.id.btUnica1);
        btUnica2 = (Button) findViewById(R.id.btUnica2);
        btMultipla1 = (Button) findViewById(R.id.btMultipla1);
        btMultipla2 = (Button) findViewById(R.id.btMultipla2);

        btNenhuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<CharSequence> adapter = ArrayAdapter
                                                    .createFromResource(
                                                            getBaseContext(),
                                                            R.array.paises,
                                                            android.R.layout.simple_list_item_1
                                                    );

                lvPaises.setChoiceMode(ListView.CHOICE_MODE_NONE);
                lvPaises.setAdapter(adapter);
            }
        });

        btUnica1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<CharSequence> adapter =
                                    ArrayAdapter
                                         .createFromResource(
                                                 getBaseContext(),
                                                 R.array.paises,
                                                 android.R.layout.simple_list_item_single_choice
                                         );

                lvPaises.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                lvPaises.setAdapter(adapter);
            }
        });

        btUnica2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<CharSequence> adapter =
                                ArrayAdapter
                                .createFromResource(
                                    getBaseContext(),
                                    R.array.paises,
                                    android.R.layout.simple_list_item_activated_1
                                );

                lvPaises.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                lvPaises.setAdapter(adapter);
            }
        });

        btMultipla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<CharSequence> adapter =
                                ArrayAdapter
                                .createFromResource(
                                    getBaseContext(),
                                    R.array.paises,
                                    android.R.layout.simple_list_item_multiple_choice
                                );

                lvPaises.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                lvPaises.setAdapter(adapter);
            }
        });

        btMultipla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<CharSequence> adapter =
                                ArrayAdapter
                                .createFromResource(
                                    getBaseContext(),
                                    R.array.paises,
                                    android.R.layout.simple_list_item_checked
                                );

                lvPaises.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                lvPaises.setAdapter(adapter);
            }
        });
    }
}
