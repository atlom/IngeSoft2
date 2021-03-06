package com.example.atlom.inge2lab.hijo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.atlom.inge2lab.HijoDetalleActivity;
import com.example.atlom.inge2lab.R;
import com.example.atlom.inge2lab.service.Service;

import java.util.ArrayList;


public class HijoFragment extends Fragment {

    Service sc = new Service();


    private ArrayList lista = new ArrayList();
    private ListView mLista ;
    private HijoAdapterList mAdapter;
    private int id_usuario;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public HijoFragment() {
        // Required empty public constructor
    }

 // TODO: Rename and change types and number of parameters
    public static HijoFragment newInstance() {
        return new HijoFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        id_usuario = getArguments().getInt("id_usuario");
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_hijo,container,false);

        mLista = (ListView) root.findViewById(R.id.hijo_list);

        mAdapter = new HijoAdapterList(getActivity(),lista);

        mLista.setAdapter(mAdapter);
        mLista.setClickable(true);
        mLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hijo current = mAdapter.getItem(position);
                showDetailsHijos(current);
            }
        });
        new HijosLoadTask().execute();
        return root;
    }

    private void showDetailsHijos(Hijo hijo){
        Intent intent = new Intent(getActivity(), HijoDetalleActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtra("id_usuario",id_usuario);
        intent.putExtra("hijo",hijo);
        startActivity(intent);
    }



    private class HijosLoadTask extends AsyncTask<Integer,Void,ArrayList>{
        @Override
        protected ArrayList doInBackground(Integer... integers) {
            lista = sc.getChild(id_usuario);
            return lista;
        }

        @Override
        protected void onPostExecute(ArrayList arrayList) {
            super.onPostExecute(arrayList);
            mAdapter.clear();
            mAdapter.addAll(lista);
            mAdapter.notifyDataSetChanged();
        }
    }
}

