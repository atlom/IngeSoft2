package com.example.atlom.inge2lab;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by atlom on 23/10/17.
 */

public class ServiceHelper {

    public JSONObject validar_usuario(String url, GoogleSignInAccount acct) throws JSONException, IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost request = new HttpPost(url);
        HttpResponse response;

        JSONObject user = new JSONObject();

        user.put("nombre",acct.getDisplayName());
        user.put("correo",acct.getEmail());

        StringEntity jsonEntity = new StringEntity(user.toString());

        request.addHeader("Content-Type","application/json");

        request.setEntity(jsonEntity);

        try {
            response = client.execute(request);

            StatusLine statusLine = response.getStatusLine();
        }catch (Exception e){
            e.getMessage();
        }

        return null;
    }
}
