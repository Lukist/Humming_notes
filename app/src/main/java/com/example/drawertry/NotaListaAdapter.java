package com.example.drawertry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NotaListaAdapter extends ArrayAdapter<Notas> {

    private List<Notas> mList;
    private Context mContext;
    private int resourceLayout;

    public NotaListaAdapter(@NonNull Context context, int resource, @NonNull List<Notas> objects) {
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

        Notas nota = mList.get(position);

        TextView textoAsunto = view.findViewById(R.id.asuntoTitulo);
        textoAsunto.setText(nota.getAsunto());

//        TextView textoNombre = view.findViewById(R.id.textNombre);
//        textoNombre.setText(cliente.getNombre());

        /*TextView textoEdad = view.findViewById(R.id.textoEdad);
        textoEdad.setText(cliente.getFecha_nacimiento());*/

        return view;
    }
}
