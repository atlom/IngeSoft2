package com.example.atlom.inge2lab.service;

import android.util.Log;

import com.example.atlom.inge2lab.R;
import com.example.atlom.inge2lab.hijo.Hijo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by atlom on 27/10/17.
 */

public class Service {

    private String host = "http://192.168.0.22:8084/Webservice/webresources/usuario/";


    private ArrayList<Hijo> hijoList = new ArrayList<>();

    public ArrayList<Hijo> getChild(int id_usuario){
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost del = new HttpPost(host+"getchilds");
            del.setHeader("Accept", "application/json");
            del.setHeader("Content-type", "application/json");
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("id_usuario", id_usuario);
            StringEntity se = new StringEntity(jsonParam.toString());
            del.setEntity(se);
            //
            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());
            JSONArray respJSON = new JSONArray(respStr);
            for (int i = 0; i <respJSON.length(); i++) {
                JSONObject obj = respJSON.getJSONObject(i);
                Hijo hijo;
                hijo = new Hijo();
                hijo.setId(obj.getString("id"));
                hijo.setNombre(obj.getString("nombre"));
                hijo.setApellido(obj.getString("apellido"));
                hijo.setFechaNacimiento(obj.getString("fechaNacimiento"));
                hijo.setLugarNacimiento(obj.getString("lugarNacimiento"));
                hijo.setBarrio(obj.getString("barrio"));
                hijo.setDepartamento(obj.getString("departamento"));
                hijo.setDireccion(obj.getString("direccion"));
                hijo.setMunicipio(obj.getString("municipio"));
                hijo.setReferenciaDomicilio(obj.getString("referenciaDomicilio"));
                hijo.setTelefonoContacto(obj.getString("telefonoContacto"));
                hijo.setResponsable(obj.getString("responsable"));
                hijo.setSeguroMedico(obj.getString("seguroMedico"));
                hijo.setAlergia(obj.getString("alergia"));
                hijo.setNacionalidad(obj.getString("nacionalidad"));
                hijo.setSexo(obj.getString("sexo"));
                if(hijo.getSexo()=="M"){
                    hijo.setAvatar(R.drawable.male);
                }else{
                    hijo.setAvatar(R.drawable.female);
                }
                hijoList.add(i, hijo);
            }
        } catch (Exception ex) {
            Log.e("ServicioRest", "Error!", ex);
        }
        return hijoList;
    }

}
