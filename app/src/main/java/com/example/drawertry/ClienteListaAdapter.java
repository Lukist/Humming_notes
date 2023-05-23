package com.example.drawertry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.List;

public class ClienteListaAdapter extends ArrayAdapter<ModeloClientes> implements Serializable {

    private List<ModeloClientes> mList;
    private Context mContext;
    private int resourceLayout;

    public ClienteListaAdapter(@NonNull Context context, int resource, @NonNull List<ModeloClientes> objects) {
        super(context, resource, objects);
        mList = objects;
        mContext = context;
        resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null)
            view = LayoutInflater.from(mContext).inflate(resourceLayout, null);

        ModeloClientes cliente = mList.get(position);

        TextView textoNombre = view.findViewById(R.id.textNombre);
        textoNombre.setText(cliente.getNombre());

        /*TextView textoEdad = view.findViewById(R.id.textoEdad);
        textoEdad.setText(cliente.getFecha_nacimiento());*/

        return view;
    }
}
