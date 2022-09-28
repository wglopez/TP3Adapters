package com.example.tp3_adapters;

public class Lenguaje{
    private String nombre;
    private int imagen;


    public Lenguaje(String name, int image){
        nombre=name;
        imagen=image;
    }

    public Lenguaje getLenguaje(){
        return this;
    }

    public String getNombre(){
        return nombre;
    }

    public int getImagen(){
        return imagen;
    }

}
