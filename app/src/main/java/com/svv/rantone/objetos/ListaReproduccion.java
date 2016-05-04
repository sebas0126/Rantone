package com.svv.rantone.objetos;

import java.util.ArrayList;

/**
 * Created by Sebas on 27/04/2016.
 */
public class ListaReproduccion {

    private int id;
    private String nombre;
    private ArrayList<Pista> pistas;

    public void setPistas(ArrayList<Pista> pistas) {
        this.pistas = pistas;
    }

    public ArrayList<Pista> getPistas() {
        return pistas;
    }

    public ListaReproduccion(){
        pistas = new ArrayList<>();
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

    public void agregarPista(Pista pista){
        pistas.add(pista);
    }

    public Pista pistaSinGuardar(){
        for (Pista pista:pistas) {
            if(pista.getId()==-1) return pista;
        }
        return null;
    }

    public boolean sinGuardar(){
        if(pistaSinGuardar()!=null) return true;
        else return false;
    }

}
