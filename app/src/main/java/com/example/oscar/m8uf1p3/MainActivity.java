package com.example.oscar.m8uf1p3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    protected String[] arrayMan     = {"Eduardo", "Ivan", "Rodrigo", "Miguel", "José", "Roberto", "Daniel", "Carlos", "Dionisio", "Teleforo", "Hector", "Julio", "Alejandro"};
    protected String[] arrayWoman   = {"Emilia", "Patricia", "Berta", "Maria", "Estefania", "Montse", "Lucia", "Sofia", "Mercedes", "Anabel", "Andrea", "Julia", "Rita"};

    protected ListView listMan      = null;
    protected ListView listWoman    = null;

    protected String selectedMan = null;
    protected String selectedWoman = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listMan = (ListView) findViewById(R.id.listaHombres);
        listWoman = (ListView) findViewById(R.id.listaMujeres);

        final ArrayAdapter<String> adapterMan = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayMan);
        ArrayAdapter<String> adapterWoman = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayWoman);
        listMan.setAdapter(adapterMan);
        listWoman.setAdapter(adapterWoman);

        listMan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
            {
                selectedMan = (String)listMan.getItemAtPosition(pos);
            }
        });
        listWoman.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
            {
                selectedWoman = (String)listWoman.getItemAtPosition(pos);
            }
        });
    }


    public void onClick(View view)
    {
        if(selectedMan == null || selectedWoman == null )
        {
            Toast tosta = Toast.makeText(this, "Selecciona un nombre de cada lista...", Toast.LENGTH_SHORT);
            tosta.show();
            return;
        }

        Persona man = new Persona(selectedMan);
        Persona woman = new Persona(selectedWoman);

        Intent intent = new Intent(this,RelationActivity.class);

        intent.putExtra("man", man.getName());
        intent.putExtra("woman", woman.getName());
        startActivity(intent);
    }
}
