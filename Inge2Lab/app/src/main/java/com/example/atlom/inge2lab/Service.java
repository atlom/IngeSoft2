package com.example.atlom.inge2lab;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

/**
 * Created by atlom on 24/10/17.
 */

public class Service {

    private String host = "http://192.168.0.22:8084/Webservice/webresources/";

    public boolean validar_usuario(String url, GoogleSignInAccount acct){

        boolean val = false;
        try {
            HttpClient client = new DefaultHttpClient();
            HttpResponse response;


            JSONObject parametros = new JSONObject();

            parametros.put("nombre",acct.getDisplayName());
            parametros.put("correo",acct.getEmail());

            StringEntity jsonEntity = new StringEntity(parametros.toString());
            HttpPost request = new HttpPost(host+url);
            request.setHeader("Accept", "application/json");
            request.addHeader("Content-Type","application/json");
            request.setEntity(jsonEntity);
            response = client.execute(request);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK){
                val = true;
            }else {

            }
//
        }catch (Exception E){

        }
        return val;
    }
}
