package com.svv.rantone.accesoDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.svv.rantone.objetos.ListaReproduccion;
import com.svv.rantone.objetos.Pista;

import java.util.ArrayList;

/**
 * Created by Sebas on 29/04/2016.
 */
public class ADPista {

    private SQLiteDatabase db;

    public ADPista(Context context){
        RantoneDAL rantoneDAL = RantoneDAL.getInstancia(context);
        db = rantoneDAL.getWritableDatabase();
    }

    public int insertarPista(ListaReproduccion lista){
        Pista nueva = lista.pistaSinGuardar();
        ContentValues nuevaPista = new ContentValues();
        nuevaPista.put("NombrePista", nueva.getNombre());
        nuevaPista.put("Ruta", nueva.getRuta());
        nuevaPista.put("IdLista", lista.getId());

        return (int) db.insert("Pistas", null, nuevaPista);
    }

    public ListaReproduccion cargarPistas(ListaReproduccion lista){
        lista.setPistas(new ArrayList<Pista>());

        Cursor cursorPista = db.rawQuery("SELECT Id, NombrePista, Ruta FROM Pistas WHERE IdLista="+lista.getId()+" ORDER BY NombrePista", null);

        if(cursorPista.moveToFirst()){
            do{
                Pista pista = new Pista();

                pista.setId(cursorPista.getInt(0));
                pista.setNombre(cursorPista.getString(1));
                pista.setRuta(cursorPista.getString(2));

                lista.agregarPista(pista);
            }while(cursorPista.moveToNext());
        }
        cursorPista.close();
        return lista;
    }

}
