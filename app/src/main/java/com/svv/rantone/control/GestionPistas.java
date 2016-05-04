package com.svv.rantone.control;

import android.content.Context;
import com.svv.rantone.accesoDatos.ADPista;
import com.svv.rantone.objetos.ListaReproduccion;
import com.svv.rantone.objetos.Pista;

import java.util.ArrayList;

/**
 * Created by Sebas on 29/04/2016.
 */
public class GestionPistas {

    private ADPista _adPista;

    public GestionPistas(Context context){
        _adPista = new ADPista(context);
    }

    public int insertarPista(ListaReproduccion lista){
        if(lista.sinGuardar()){
            return _adPista.insertarPista(lista);
        }
        return -1;
    }

    public ListaReproduccion cargarPistas(ListaReproduccion lista){
        return _adPista.cargarPistas(lista);
    }
}
