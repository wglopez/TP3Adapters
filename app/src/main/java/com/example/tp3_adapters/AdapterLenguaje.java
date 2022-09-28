package com.example.tp3_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterLenguaje extends BaseAdapter {
    private ArrayList<Lenguaje> portafolio;
    private LayoutInflater inflater;
    private Context contexto;

    public AdapterLenguaje(Context contexto, ArrayList<Lenguaje> portafolio) {
        this.portafolio=portafolio;
        this.contexto=contexto;
    }


    @Override
    public int getCount() {
        return portafolio.size();
    }

    @Override
    public Object getItem(int i) {
        return portafolio.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ContenedorViewLenguaje contenedorLenguaje = null;
        LayoutInflater inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

        if (view==null){
            view=inflater.inflate(R.layout.lenguaje,null);
            contenedorLenguaje = new ContenedorViewLenguaje();
            contenedorLenguaje.nombre=(TextView) view.findViewById(R.id.nombreLenguaje);
            contenedorLenguaje.imagen= (ImageView) view.findViewById(R.id.imagenLenguaje);

            Lenguaje lenguaje_i = (Lenguaje) getItem(i);

            contenedorLenguaje.nombre.setText(lenguaje_i.getNombre());
            contenedorLenguaje.imagen.setImageResource(lenguaje_i.getImagen());
            view.setTag(contenedorLenguaje);
        }
        else {
            contenedorLenguaje = (ContenedorViewLenguaje)view.getTag();
            Lenguaje lenguaje_i = (Lenguaje) getItem(i);
            contenedorLenguaje.nombre.setText(lenguaje_i.getNombre());
            contenedorLenguaje.imagen.setImageResource(lenguaje_i.getImagen());
        }

        return view;
    }
}
