package com.example.tp3_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterProyecto extends BaseAdapter {
    private ArrayList<Proyecto> portafolio;
    private LayoutInflater inflater;
    private Context contexto;

    public AdapterProyecto(Context contexto, ArrayList<Proyecto> portafolio) {
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

        ContenedorViewProyecto contenedorProyecto = null;
        LayoutInflater inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

        if (view==null){
            view=inflater.inflate(R.layout.proyecto,null);
            contenedorProyecto = new ContenedorViewProyecto();
            contenedorProyecto.nombre=(TextView) view.findViewById(R.id.nombreProyecto);
            contenedorProyecto.descripcion=(TextView) view.findViewById(R.id.descripcion);
            contenedorProyecto.imagen= (ImageView) view.findViewById(R.id.imagenProyecto);

            Proyecto proyecto_i = (Proyecto) getItem(i);

            contenedorProyecto.nombre.setText(proyecto_i.getNombre());
            contenedorProyecto.descripcion.setText(proyecto_i.getDescripcion());
            contenedorProyecto.imagen.setImageResource(proyecto_i.getImagen());
            view.setTag(contenedorProyecto);
        }
        else {
            contenedorProyecto = (ContenedorViewProyecto)view.getTag();
            Proyecto proyecto_i = (Proyecto)getItem(i);
            contenedorProyecto.nombre.setText(proyecto_i.getNombre());
            contenedorProyecto.descripcion.setText(proyecto_i.getDescripcion());
            contenedorProyecto.imagen.setImageResource(proyecto_i.getImagen());

        }

        return view;
    }
}
