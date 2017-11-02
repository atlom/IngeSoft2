package com.example.atlom.inge2lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.atlom.inge2lab.entity.Filtro;
import com.example.atlom.inge2lab.entity.Tabla;
import com.example.atlom.inge2lab.registro.RegistroVacuna;
import com.example.atlom.inge2lab.service.Service;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ArrayList<RegistroVacuna> elemento;
    private Spinner spinner;
    private ArrayList<Filtro> filtro = new ArrayList<>();
    private int orden;
    private Tabla tabla;
    private TableLayout tab;

    private String id_hijo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        id_hijo = getIntent().getExtras().getString("id_hijo");
        Filtro aux=new Filtro();
        aux.setNombre("PRESIONE AQUI");
        aux.setPosicion(0);
        filtro.add(aux);
        aux=new Filtro();
        aux.setNombre("Aplicadas");
        aux.setPosicion(1);
        filtro.add(aux);
        aux=new Filtro();
        aux.setNombre("No Aplicadas");
        aux.setPosicion(2);
        filtro.add(aux);
        aux=new Filtro();
        aux.setNombre("Alfabeticamente");
        aux.setPosicion(3);
        filtro.add(aux);
        aux=new Filtro();
        aux.setNombre("Por fecha");
        aux.setPosicion(4);
        filtro.add(aux);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<Filtro> dataAdapter = new ArrayAdapter<>(this
                , android.R.layout.simple_spinner_item, filtro);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        tab = (TableLayout) findViewById(R.id.tabla);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String item = adapterView.getItemAtPosition(position).toString();
        // Muestra el elemento seleccionado y pone los datos en la pantalla
        if(position == 0){
            Toast.makeText(adapterView.getContext(), "Seleccione un Filtro ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(adapterView.getContext(), "Seleccionó: " + item, Toast.LENGTH_SHORT).show();
        }
        tab.removeAllViews();
        tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        //
        if(position!=0){
            Service sc = new Service();
            switch (position){
                case 1:
                    elemento = sc.byEstado(id_hijo,position);
                    break;
                case 2:
                    elemento = sc.byEstado(id_hijo,position);
                    break;
                case 3:
                    elemento = sc.byNombre(id_hijo);
                    break;
                case 4:
                    elemento = sc.byFecha(id_hijo);
                    break;
            }

            int tam = elemento.size();
            tabla.agregarCabecera(R.array.cabecera_tabla);
            for(int i = 0;i < tam;i++){
                ArrayList<String> elementos = new ArrayList<>();
                elementos.add(elemento.get(i).getNombre());
                elementos.add(elemento.get(i).getFecha());
                tabla.agregarFilaTabla(elementos);
            }
        }
        orden=position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
