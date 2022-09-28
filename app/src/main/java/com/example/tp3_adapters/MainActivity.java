package com.example.tp3_adapters;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Adapter;
        import android.widget.AdapterView;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Lenguaje> portafolio= new ArrayList<Lenguaje>();
        portafolio.add(new Lenguaje("C++", R.drawable.c_icon));
        portafolio.add(new Lenguaje("Python", R.drawable.python_icon));
        portafolio.add(new Lenguaje("Java", R.drawable.java_icon));

        AdapterLenguaje adaptador = new AdapterLenguaje(this,portafolio);


        ListView miLista = (ListView)findViewById(R.id.lenguajes);
        miLista.setAdapter(adaptador);
        miLista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ListAdapter la = (ListAdapter) adapterView.getAdapter();
        Lenguaje lenguaje = (Lenguaje) la.getItem(i);

        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        Intent intent = null;

        switch (lenguaje.getImagen()) {
            case R.drawable.java_icon:
                proyectos.add(new Proyecto("Adapter", "Ejemplo sobre como utilizar adaptores", R.drawable.adapter));
                proyectos.add(new Proyecto("Login", "Pantalla Login con layout dinamico", R.drawable.login));
                proyectos.add(new Proyecto("Calculator", "Calculadora con operaciones basicas para numeros doubles", R.drawable.calculator));
                intent = new Intent(this, SecondActivity.class);
                intent.putExtra("imagen", lenguaje.getImagen());
                intent.putParcelableArrayListExtra("proyectos", proyectos);
                startActivity(intent);
                break;

            case R.drawable.python_icon:
                proyectos.add(new Proyecto("TKinter", "Elementos de GUI hechos con Tkinter", R.drawable.gui));
                proyectos.add(new Proyecto("Django", "Backend con Django", R.drawable.django));
                intent = new Intent(this, SecondActivity.class);
                intent.putExtra("imagen", lenguaje.getImagen());
                intent.putParcelableArrayListExtra("proyectos", proyectos);
                startActivity(intent);
                break;

            case R.drawable.c_icon:
                proyectos.add(new Proyecto("Opengl", "Metodos de Computacion Grafica aplicados mediante OpenGL", R.drawable.opengl));
                intent = new Intent(this, SecondActivity.class);
                intent.putExtra("imagen", lenguaje.getImagen());
                intent.putParcelableArrayListExtra("proyectos", proyectos);
                startActivity(intent);
                break;


        }
    }
}

