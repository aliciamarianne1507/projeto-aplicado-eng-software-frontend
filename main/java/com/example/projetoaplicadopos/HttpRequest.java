package com.example.projetoaplicadopos;

import android.content.Context;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class HttpRequest {

    private final String baseUrl = "https://projetoposgraduacao-backend.herokuapp.com/";
    private String endpoint;

    public HttpRequest(final String endpoint){
        this.endpoint = endpoint;
    }


    public StatusResponse sendPostRequest(final int method, final Map<String, String> bodyParams, Context context){

        RequestQueue queue = Volley.newRequestQueue(context);

        final String url = baseUrl.concat(endpoint);

        final StatusResponse statusResponse = new StatusResponse();
        StringRequest stringRequest = new StringRequest(method, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println("Response is: "+ response.toString());
                    statusResponse.setCode(0);
                    statusResponse.setMessage(null);
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                    statusResponse.setCode(1);
                    statusResponse.setMessage(error.getMessage());
                    System.out.println("That didn't work!");
                }

        }){

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return bodyParams;
            }
        };
        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        JsonObjectRequest request = new JsonObjectRequest(url, new JSONObject(), future, future);
        queue.add(request);

        try {
            JSONObject response = future.get(); // this will block
        } catch (InterruptedException e) {
            // exception handling
        } catch (ExecutionException e) {
            // exception handling
        }
        return statusResponse;
    }
}
