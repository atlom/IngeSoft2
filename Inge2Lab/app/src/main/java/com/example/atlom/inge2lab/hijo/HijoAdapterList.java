package com.example.atlom.inge2lab.hijo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.atlom.inge2lab.R;

import java.util.List;


/**
 * Created by atlom on 29/10/17.
 */

public class HijoAdapterList extends ArrayAdapter<Hijo> {
    public HijoAdapterList(Context context, List<Hijo> hijos){
        super(context,0,hijos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.list_item_hijo, parent, false);
        }
        ImageView avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
        TextView nombre = (TextView) convertView.findViewById(R.id.tv_name);
        TextView fecha = (TextView) convertView.findViewById(R.id.tv_fecha);

        Hijo hijo = getItem(position);

        Glide.with(getContext()).load(hijo.getAvatar()).into(avatar);
        nombre.setText(hijo.getNombre());
        fecha.setText(hijo.getFechaNacimiento());

        return convertView;

    }
}
