package com.example.projetoaplicadopos;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public class HttpRequest {

    private final String baseUrl = "https://projetoposgraduacao-backend.herokuapp.com/";

    public <T> void send(final int method, final String endpoint, final Map<String, String> headers, final Class<T> response, final Object body, Context context){

        RequestQueue queue = Volley.newRequestQueue(context);

        final String url = baseUrl.concat(endpoint);

        StringRequest stringRequest = new StringRequest(method, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println("Response is: "+ response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work!");
            }
        });

        queue.add(stringRequest);

    }
}
