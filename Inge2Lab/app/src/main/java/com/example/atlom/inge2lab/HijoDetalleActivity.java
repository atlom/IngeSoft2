package com.example.atlom.inge2lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.atlom.inge2lab.detalle.HijoDetalleFragment;
import com.example.atlom.inge2lab.hijo.Hijo;
import com.example.atlom.inge2lab.registro.RegistroVacuna;
import com.example.atlom.inge2lab.RegistroActivity;


public class HijoDetalleActivity extends AppCompatActivity {

    private int id_usuario;
    private Hijo hijo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijo_detalle);

        id_usuario = getIntent().getExtras().getInt("id_usuario");
        hijo = (Hijo) getIntent().getExtras().getSerializable("hijo");

        HijoDetalleFragment fragment = (HijoDetalleFragment) getSupportFragmentManager()
                .findFragmentById(R.id.hijo_detalle_container);

        Bundle bundle = new Bundle();
        bundle.putSerializable("hijo",hijo);
        bundle.putInt("id_usuario",id_usuario);

        if (fragment == null){
            fragment = HijoDetalleFragment.newInstance();
            fragment.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.hijo_detalle_container, fragment)
                    .commit();
        }

    }

    public void mostrarRegistro(View view) {
        Intent intent = new Intent(this, RegistroActivity.class);
        intent.putExtra("id_hijo",hijo.getId());
        startActivity(intent);
    }
}
