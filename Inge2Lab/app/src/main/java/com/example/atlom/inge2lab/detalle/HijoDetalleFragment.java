package com.example.atlom.inge2lab.detalle;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.atlom.inge2lab.R;
import com.example.atlom.inge2lab.hijo.Hijo;


public class HijoDetalleFragment extends Fragment {

    private Hijo hijo;
    private int id_usuario;

    private TextView mHijoId;
    private TextView mFechaNac;
    private TextView mNacionalidad;
    private TextView mLugarNac;
    private TextView mSex;
    private TextView mDomic;
    private TextView mTelefono;
    private TextView mAlergias;

    public HijoDetalleFragment() {
        // Required empty public constructor
    }
public static HijoDetalleFragment newInstance() {
        HijoDetalleFragment fragment = new HijoDetalleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        hijo = (Hijo) getArguments().getSerializable("hijo");
        id_usuario=getArguments().getInt("id_usuario");

        View root =inflater.inflate(R.layout.fragment_hijo_detalle
                , container, false);

        mHijoId = root.findViewById(R.id.tv_id);
        mFechaNac = root.findViewById(R.id.tv_fecha_nac);
        mNacionalidad = root.findViewById(R.id.tv_nacionalidad);
        mLugarNac = root.findViewById(R.id.tv_lugar_nac);
        mSex = root.findViewById(R.id.tv_sex);
        mDomic= root.findViewById(R.id.tv_domic);
        mTelefono = root.findViewById(R.id.tv_telefono);
        mAlergias = root.findViewById(R.id.tv_alergias);

        mHijoId.setText(hijo.getId());
        mFechaNac.setText(hijo.getFechaNacimiento());
        mNacionalidad.setText(hijo.getNacionalidad());
        mLugarNac.setText(hijo.getLugarNacimiento());
        mSex.setText(hijo.getSexo());
        mDomic.setText(hijo.getDireccion());
        mTelefono.setText(hijo.getTelefonoContacto());
        mAlergias.setText(hijo.getAlergia());
        return root;
    }

}
