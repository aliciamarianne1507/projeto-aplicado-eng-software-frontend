package com.example.frontend.pedidos.criarPedido;

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
import com.example.frontend.pedidos.Pedido;

import org.json.JSONException;
import org.json.JSONObject;

public class CriarPedido extends AppCompatActivity {

    private EditText cpfPedido,quantidadePedido;
    private Button criarPedido;
    private TextView statusCriacao;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_pedido);
        components();
        create();
    }

    private void components(){
        cpfPedido = findViewById(R.id.cpf_cliente);
        quantidadePedido = findViewById(R.id.quantidade_pedido);
        criarPedido = findViewById(R.id.create_pedido_button);
        statusCriacao = findViewById(R.id.title_status_criacao);
        queue = Volley.newRequestQueue(this);

    }

    private void create(){
        criarPedido.setOnClickListener(v->createPedido());
    }

    private void createPedido(){
        JSONObject postData = new JSONObject();
        try{
            postData.put("cpf",cpfPedido.getText());
            postData.put("quantidade", quantidadePedido.getText());
        }catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                U.BASE_URL + "/pedidos",
                postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Pedido pedido = new Pedido(
                                    response.getString("codigo_pedido"),
                                    response.getString("cpf"),
                                    response.getString("created_at"),
                                    response.getString("updated_at"),
                                    response.getInt("quantidade")
                            );
                            statusCriacao.setText("Pedido Criado com Sucesso!!!");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            statusCriacao.setText("Erro ao criar a pedido");
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

}

