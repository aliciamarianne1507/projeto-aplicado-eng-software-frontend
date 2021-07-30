package com.example.frontend.itempedidos.criarItemPedido;

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
import com.example.frontend.itempedidos.ItemPedido;

import org.json.JSONException;
import org.json.JSONObject;

public class CriarItemPedido extends AppCompatActivity {

    private EditText codigoPedido,codigoProduto,quantidadePedido;
    private Button criarItemPedido;
    private TextView statusCriacao;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_itempedido);
        components();
        create();
    }

    private void components(){
        codigoPedido= findViewById(R.id.codigo_pedido);
        codigoProduto = findViewById(R.id.codigo_produto);
        quantidadePedido = findViewById(R.id.quantidade);
        statusCriacao = findViewById(R.id.title_status_criacao);
        criarItemPedido = findViewById(R.id.create_item_button);
        queue = Volley.newRequestQueue(this);

    }

    private void create(){
        criarItemPedido.setOnClickListener(v->createItemPedido());
    }

    private void createItemPedido(){
        JSONObject postData = new JSONObject();
        try{
            postData.put("codigo_pedido",codigoPedido.getText());
            postData.put("codigo_produto",codigoProduto.getText());
            postData.put("quantidade",quantidadePedido.getText());
        }catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                U.BASE_URL + "/itempedido",
                postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            ItemPedido itemPedido = new ItemPedido(
                                    response.getString("codigo_pedido"),
                                    response.getString("codigo_produto"),
                                    response.getString("created_at"),
                                    response.getString("updated_at"),
                                    response.getInt("quantidade")
                            );
                            statusCriacao.setText("Item Pedido Criado com Sucesso!!!");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            statusCriacao.setText("Erro ao criar Item Pedido");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        statusCriacao.setText("Erro ao criar Item Pedido");
                    }
                }
        );
        queue.add(request);
    }

}

