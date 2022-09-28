package com.example.tp3_adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView image=findViewById(R.id.iconoLenguaje);
        Bundle extras=getIntent().getExtras();
        image.setImageResource(extras.getInt("imagen"));


        ArrayList<Proyecto> proyectos = getIntent().getParcelableArrayListExtra("proyectos");

        AdapterProyecto adaptador = new AdapterProyecto(this, proyectos);


        ListView miLista = (ListView) findViewById(R.id.proyectos);
        miLista.setAdapter(adaptador);
    }

}