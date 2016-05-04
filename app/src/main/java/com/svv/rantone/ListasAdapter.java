package com.svv.rantone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;

import com.svv.rantone.control.GestionListas;
import com.svv.rantone.objetos.ListaReproduccion;

import java.util.ArrayList;

/**
 * Created by Sebas on 28/04/2016.
 */
public class ListasAdapter extends ArrayAdapter<ListaReproduccion> {

    private ArrayList<ListaReproduccion> _listas;
    private Context _contexto = null;
    private ViewHolder holder;
    private GestionListas gestionListas;

    public ListasAdapter(Context context, ArrayList<ListaReproduccion> listas) {
        super(context, R.layout.adapter_lista, listas);

        this._listas=listas;
        this._contexto=context;

        gestionListas = new GestionListas(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //Version 3
        View item = convertView;


        if(item==null){
            LayoutInflater inflater =  LayoutInflater.from(_contexto);
            item = inflater.inflate(R.layout.adapter_lista, parent, false);

            holder = new ViewHolder();
            holder.etNombre = (EditText) item.findViewById(R.id.etNombre);
            holder.btnEditar = (ImageButton) item.findViewById(R.id.btnEditar);

            item.setTag(holder);
        }else{
            holder = (ViewHolder) item.getTag();
        }

        holder.etNombre.setText(_listas.get(position).getNombre());

        holder.etNombre.requestFocus();

        holder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.etNombre.setEnabled(true);
            }
        });

        holder.etNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    EditText etActual = (EditText) v;
                    _listas.get(position).setNombre(etActual.getText().toString());
                    etActual.setEnabled(false);
                    int indice = gestionListas.insertarLista(_listas.get(position));
                    if(indice != -1) {
                        _listas.get(position).setId(indice);
                    }
                }
            }
        });

        return item;
    }

    static class ViewHolder{
        EditText etNombre;
        ImageButton btnEditar;
    }
}
