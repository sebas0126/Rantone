package com.svv.rantone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.svv.rantone.control.GestionListas;
import com.svv.rantone.control.GestionPistas;
import com.svv.rantone.objetos.ListaReproduccion;
import com.svv.rantone.objetos.Pista;

import java.util.ArrayList;

/**
 * Created by Sebas on 29/04/2016.
 */
public class PistasAdapter extends ArrayAdapter<Pista>{
    private ArrayList<Pista> _pistas;
    private Context _contexto = null;
    private ViewHolder holder;
    private GestionPistas gestionPistas;

    public PistasAdapter(Context context, ArrayList<Pista> pistas) {
        super(context, R.layout.adapter_lista, pistas);

        this._pistas = pistas;
        this._contexto=context;

        gestionPistas = new GestionPistas(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View item = convertView;

        if(item==null){
            LayoutInflater inflater =  LayoutInflater.from(_contexto);
            item = inflater.inflate(R.layout.adapter_pista, parent, false);

            holder = new ViewHolder();
            holder.tvNombre = (TextView) item.findViewById(R.id.tvNombre);
            holder.tvRuta = (TextView) item.findViewById(R.id.tvRuta);

            item.setTag(holder);
        }else{
            holder = (ViewHolder) item.getTag();
        }

        holder.tvNombre.setText(_pistas.get(position).getNombre());
        holder.tvRuta.setText(_pistas.get(position).getRuta());

        return item;
    }

    static class ViewHolder{
        TextView tvNombre;
        TextView tvRuta;
    }
}
