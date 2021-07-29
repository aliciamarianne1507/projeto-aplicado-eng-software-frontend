package com.example.frontend.categoria.buscarCategorias;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.frontend.R;
import com.example.frontend.U;
import com.example.frontend.categoria.Categoria;

import org.json.JSONException;
import org.json.JSONObject;


public class BuscarCategorias extends AppCompatActivity {

    private TextView nomeCategoria, codigoCategoria,titleNomeCategoria, titleCodigoCategoria;
    private EditText codCategoria;
    private Button buscarCategoria;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_categoria);
        components();
        search();
    }

    private void components(){
        codCategoria = findViewById(R.id.cod_categoria);
        nomeCategoria = findViewById(R.id.nome_categoria);
        codigoCategoria = findViewById(R.id.codigo_categoria);
        buscarCategoria = findViewById(R.id.search_category);
        titleCodigoCategoria = findViewById(R.id.title_codigo_categoria);
        titleNomeCategoria = findViewById(R.id.title_nome_categoria);
        queue = Volley.newRequestQueue(this);
    }
    private void search(){
        buscarCategoria.setOnClickListener(v -> buscarCategory());

    }
    private void buscarCategory(){
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                U.BASE_URL + "/categoria/" + codCategoria.getText(),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            System.out.println(response);
                            Categoria categoria = new Categoria(
                                    response.getInt("id"),
                                    response.getString("name_categoria"),
                                    response.getString("codigo_categoria"),
                                    response.getString("created_at"),
                                    response.getString("updated_at")


                                    );
                            setComponents(categoria);

                        } catch (JSONException e) {
                            System.out.println(response);
                            e.printStackTrace();
                            titleNomeCategoria.setText("Categoria não encontrada");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );
        queue.add(request);
    }

    private void setComponents(Categoria categoria){
       nomeCategoria.setText(categoria.getName_categoria());
       codigoCategoria.setText(categoria.getCodigo_categoria());
       titleNomeCategoria.setText("Nome da Categoria:");
       titleCodigoCategoria.setText("Código da Categoria: ");

    }
}
