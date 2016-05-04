package com.svv.rantone.control;

import android.content.Context;

import com.svv.rantone.accesoDatos.ADListaReproduccion;
import com.svv.rantone.objetos.ListaReproduccion;

import java.util.ArrayList;

/**
 * Created by Sebas on 29/04/2016.
 */
public class GestionListas {

    private ADListaReproduccion _adListaReproduccion;

    public GestionListas(Context context){
        _adListaReproduccion = new ADListaReproduccion(context);
    }

    public int insertarLista(ListaReproduccion lista){
        if(lista.getId()==-1){
            return _adListaReproduccion.insertarLista(lista);
        }
        return -1;
    }

    public ArrayList<ListaReproduccion> cargarListas(){
        return _adListaReproduccion.cargarListas();
    }

}
