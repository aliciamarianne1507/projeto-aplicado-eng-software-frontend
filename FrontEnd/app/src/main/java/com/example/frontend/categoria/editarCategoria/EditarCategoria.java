package com.example.frontend.categoria.editarCategoria;

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

public class EditarCategoria extends AppCompatActivity {
    private EditText nomeNovoCategoria, codigoCategoria;
    private TextView statusEdicao;
    private TextView codigoCategoriaEditada;
    private TextView titleCodigoCategoria;
    private TextView titleNomeCategoria;
    private TextView nomeCategoriaEditada;
    private RequestQueue queue;
    private Button editCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_categoria);
        components();
        edit();
    }

    private void components(){
        queue = Volley.newRequestQueue(this);
        nomeNovoCategoria = findViewById(R.id.nome_categoria_nova);
        codigoCategoria = findViewById(R.id.cod_categoria);
        statusEdicao = findViewById(R.id.title_status_criacao);
        nomeCategoriaEditada = findViewById(R.id.nome_categoria);
        codigoCategoriaEditada = findViewById(R.id.codigo_categoria);
        titleCodigoCategoria = findViewById(R.id.title_codigo_categoria);
        titleNomeCategoria = findViewById(R.id.title_nome_categoria);
        editCategoria = findViewById(R.id.edit_category);
    }

    private void edit(){editCategoria.setOnClickListener(v->editCategory());}

    public void editCategory(){
        JSONObject postData = new JSONObject();
        try {
            postData.put("name_categoria", nomeNovoCategoria.getText());
            postData.put("codigo_categoria", codigoCategoria.getText());
        }catch (JSONException e){
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.PUT,
                U.BASE_URL + "/categoria",
                postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            Categoria categoria = new Categoria(
                                    response.getInt("id"),
                                    response.getString("name_categoria"),
                                    response.getString("codigo_categoria"),
                                    response.getString("created_at"),
                                    response.getString("updated_at")
                            );

                            setComponents(categoria);
                            statusEdicao.setText("Categoria Editada com Sucesso!!!");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            statusEdicao.setText("Erro ao editar a categoria");
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        statusEdicao.setText("Erro ao editar a categoria");
                    }
                }
        );
        queue.add(request);
    }

    private void setComponents(Categoria categoria){
        nomeCategoriaEditada.setText(categoria.getName_categoria());
        codigoCategoriaEditada.setText(categoria.getCodigo_categoria());
        titleNomeCategoria.setText("Nome da Categoria:");
        titleCodigoCategoria.setText("Código da Categoria: ");
    }
}
