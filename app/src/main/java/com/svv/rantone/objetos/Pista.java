package com.svv.rantone.objetos;

/**
 * Created by Sebas on 27/04/2016.
 */
public class Pista {
    private int id;
    private String nombre;
    private String ruta;

    public Pista(){
        id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
