package com.svv.rantone.accesoDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.svv.rantone.objetos.ListaReproduccion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Sebas on 29/04/2016.
 */
public class ADListaReproduccion {

    private SQLiteDatabase db;

    public ADListaReproduccion(Context context){
        RantoneDAL rantoneDAL = RantoneDAL.getInstancia(context);
        db = rantoneDAL.getWritableDatabase();
    }

    public int insertarLista(ListaReproduccion lista){
        ContentValues nuevaLista = new ContentValues();
        nuevaLista.put("NombreLista", lista.getNombre());

        return (int) db.insert("Listas", null, nuevaLista);
    }

    public ArrayList<ListaReproduccion> cargarListas(){
        ArrayList<ListaReproduccion> listas = new ArrayList<>();
        Cursor cursorLista = db.rawQuery("SELECT Id, NombreLista FROM Listas ORDER BY NombreLista", null);

        if(cursorLista.moveToFirst()){
            do{
                ListaReproduccion lista = new ListaReproduccion();

                lista.setId(cursorLista.getInt(0));
                lista.setNombre(cursorLista.getString(1));

                listas.add(lista);
            }while(cursorLista.moveToNext());
        }
        cursorLista.close();
        return listas;
    }

}
