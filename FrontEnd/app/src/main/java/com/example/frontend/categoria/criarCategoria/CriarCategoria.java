package com.example.frontend.categoria.criarCategoria;

import android.os.Bundle;
import android.text.Editable;
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

public class CriarCategoria extends AppCompatActivity {

    private EditText nomeNovaCategoria;
    private Button criarCategoria;
    private TextView statusCriacao, nomeCategoriaCriada, codigoCategoriaCriada, titleNomeCategoria, titleCodigoCategoria;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_categoria);
        components();
        create();
    }

    private void components(){
        nomeNovaCategoria= findViewById(R.id.nova_categoria_nome);
        titleCodigoCategoria = findViewById(R.id.title_codigo_categoria);
        titleNomeCategoria = findViewById(R.id.title_nome_categoria);
        statusCriacao = findViewById(R.id.title_status_criacao);
        nomeCategoriaCriada = findViewById(R.id.nome_categoria);
        codigoCategoriaCriada = findViewById(R.id.codigo_categoria);
        criarCategoria = findViewById(R.id.create_category_button);
        queue = Volley.newRequestQueue(this);

    }

    private void create(){
        criarCategoria.setOnClickListener(v->createCategory());
    }

    private void createCategory(){
        JSONObject postData = new JSONObject();
        try{
            postData.put("name_categoria",nomeNovaCategoria.getText());
        }catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                U.BASE_URL + "/categoria",
                postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Categoria categoria = new Categoria(
                                    response.getInt("id"),
                                    response.getString("name_categoria"),
                                    response.getString("codigo_categoria"),
                                    response.getString("created_at"),
                                    response.getString("updated_at")
                            );
                            setComponents(categoria);
                            statusCriacao.setText("Categoria Criada com Sucesso!!!");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            statusCriacao.setText("Erro ao criar a categoria");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        statusCriacao.setText("Erro ao criar a categoria");
                    }
                }
        );
        queue.add(request);
    }

    private void setComponents(Categoria categoria){
        nomeCategoriaCriada.setText(categoria.getName_categoria());
        codigoCategoriaCriada.setText(categoria.getCodigo_categoria());
        titleNomeCategoria.setText("Nome da Categoria:");
        titleCodigoCategoria.setText("Código da Categoria: ");
    }
}
