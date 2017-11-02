package com.example.atlom.inge2lab.service;

import android.util.Log;

import com.example.atlom.inge2lab.R;
import com.example.atlom.inge2lab.hijo.Hijo;
import com.example.atlom.inge2lab.registro.RegistroVacuna;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
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

    //private String host = "http://192.168.43.2:8084/Webservice/webresources/usuario/";

    private ArrayList<Hijo> hijoList = new ArrayList<>();
    private ArrayList<RegistroVacuna> vacList = new ArrayList<>();

    public ArrayList<Hijo> getChild(int id_usuario) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost del = new HttpPost(host + "getchilds");
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
            for (int i = 0; i < respJSON.length(); i++) {
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
                if (hijo.getSexo().equals("M")) {
                    hijo.setAvatar(R.drawable.male);
                } else {
                    hijo.setAvatar(R.drawable.female);
                }
                hijoList.add(i, hijo);
            }
        } catch (Exception ex) {
            Log.e("ServicioRest", "Error!", ex);
        }
        return hijoList;
    }

    private void getRegistro(int id_usuario) {
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost del = new HttpPost(host + "getregistroby?estado=");
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
            for (int i = 0; i < respJSON.length(); i++) {
                JSONObject obj = respJSON.getJSONObject(i);
                RegistroVacuna vac = new RegistroVacuna();
                vac.setId_hijo(obj.getString("hijoId"));
                vac.setEdad(obj.getInt("edad"));
                vac.setId_vacuna(obj.getInt("vacunaId"));
                vac.setDosis(obj.getInt("dosis"));
                vac.setLote(obj.getString("lote"));
                vac.setNombre(obj.getString("nombreVacuna"));
                vac.setNombre_medico(obj.getString("responsable"));
                vac.setDescripcion("");
                vac.setAplicada(obj.getInt("estado"));
                vac.setFecha(obj.getString("fecha"));
                vacList.add(vac);
            }
        } catch (Exception ex) {
            Log.e("ServicioRest", "Error!", ex);
        }
    }

    public ArrayList<RegistroVacuna> byEstado(String id,int pos){
        try{
            String url="";
            HttpClient httpClient = new DefaultHttpClient();
            if (pos==1){//Posicion del spinner si es 1 entonces marco aplicada
                url = host + "getregistroby?estado=1";
            }else {
                url = host + "getregistroby?estado=0";
            }
            HttpPost del = new HttpPost(url);
            del.setHeader("Accept", "application/json");
            del.setHeader("Content-type", "application/json");
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("id", id);
            StringEntity se = new StringEntity(jsonParam.toString());
            del.setEntity(se);
            //
            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());
            StatusLine statusLine = resp.getStatusLine();
            JSONArray respJSON = new JSONArray(respStr);
            for (int i = 0; i < respJSON.length(); i++) {
                JSONObject obj = respJSON.getJSONObject(i);
                RegistroVacuna vac = new RegistroVacuna();
                vac.setNombre(obj.getString("nombreVacuna"));
                vac.setFecha(obj.getString("fecha"));
                vacList.add(vac);
            }
        }catch (Exception ex){
            Log.e("ServicioRest", "Error!", ex);
        }
        return vacList;
    }

    public ArrayList<RegistroVacuna> byNombre(String id){
        try{
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost del = new HttpPost(host+"getregistrobynombre");
            del.setHeader("Accept", "application/json");
            del.setHeader("Content-type", "application/json");
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("id", id);
            StringEntity se = new StringEntity(jsonParam.toString());
            del.setEntity(se);
            //
            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());
            StatusLine statusLine = resp.getStatusLine();
            JSONArray respJSON = new JSONArray(respStr);
            for (int i = 0; i < respJSON.length(); i++) {
                JSONObject obj = respJSON.getJSONObject(i);
                RegistroVacuna vac = new RegistroVacuna();
                vac.setNombre(obj.getString("nombreVacuna"));
                vac.setFecha(obj.getString("fecha"));
                vacList.add(vac);
            }
        }catch (Exception ex){
            Log.e("ServicioRest", "Error!", ex);
        }
        return vacList;
    }

    public ArrayList<RegistroVacuna> byFecha(String id){
        try{
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost del = new HttpPost(host+"getregistrobyfecha");
            del.setHeader("Accept", "application/json");
            del.setHeader("Content-type", "application/json");
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("id", id);
            StringEntity se = new StringEntity(jsonParam.toString());
            del.setEntity(se);
            //
            HttpResponse resp = httpClient.execute(del);
            String respStr = EntityUtils.toString(resp.getEntity());
            StatusLine statusLine = resp.getStatusLine();
            JSONArray respJSON = new JSONArray(respStr);
            for (int i = 0; i < respJSON.length(); i++) {
                JSONObject obj = respJSON.getJSONObject(i);
                RegistroVacuna vac = new RegistroVacuna();
                vac.setNombre(obj.getString("nombreVacuna"));
                vac.setFecha(obj.getString("fecha"));
                vacList.add(vac);
            }
        }catch (Exception ex){
            Log.e("ServicioRest", "Error!", ex);
        }
        return vacList;
    }
}
