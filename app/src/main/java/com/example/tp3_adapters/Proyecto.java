package com.example.tp3_adapters;


import android.os.Parcel;
import android.os.Parcelable;

public class Proyecto implements Parcelable {
    private String nombre;
    private String descripcion;
    private int imagen;


    public Proyecto(String name, String description, int image){
        nombre=name;
        descripcion=description;
        imagen=image;
    }

    protected Proyecto(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        imagen = in.readInt();
    }

    public static final Creator<Proyecto> CREATOR = new Creator<Proyecto>() {
        @Override
        public Proyecto createFromParcel(Parcel in) {
            return new Proyecto(in);
        }

        @Override
        public Proyecto[] newArray(int size) {
            return new Proyecto[size];
        }
    };

    public Proyecto getProyecto(){
        return this;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }


    public int getImagen(){
        return imagen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(descripcion);
        parcel.writeInt(imagen);

    }
}

