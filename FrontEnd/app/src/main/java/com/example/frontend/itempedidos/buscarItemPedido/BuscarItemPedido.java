package com.example.frontend.itempedidos.buscarItemPedido;

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

public class BuscarItemPedido extends AppCompatActivity {

    private TextView codigoPedido, titleCodigoPedido,titleCodigoProduto,codigoProduto,titleQuantidade,quantidadeProduto;
    private EditText idItemPedido;
    private Button buscarItemPedido;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_itempedido);
        components();
        search();
    }

    private void components(){
        codigoPedido = findViewById(R.id.codigo_pedido);
        titleCodigoPedido = findViewById(R.id.title_codigo_pedido);
        titleCodigoProduto = findViewById(R.id.title_codigo_produto);
        codigoProduto = findViewById(R.id.codigo_produto);
        titleQuantidade = findViewById(R.id.title_quantidade_produto);
        quantidadeProduto= findViewById(R.id.quantidade_pedido);
        buscarItemPedido = findViewById(R.id.search_itempedido);
        idItemPedido = findViewById(R.id.id_itempedido);
        queue = Volley.newRequestQueue(this);
    }
    private void search(){
        buscarItemPedido.setOnClickListener(v -> buscarItem());

    }
    private void buscarItem(){
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                U.BASE_URL + "/itempedido/" + idItemPedido.getText(),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            System.out.println(response);
                            ItemPedido itempedido = new ItemPedido(
                                    response.getString("codigo_pedido"),
                                    response.getString("codigo_produto"),
                                    response.getString("created_at"),
                                    response.getString("updated_at"),
                                    response.getInt("quantidade")
                            );
                            setComponents(itempedido);

                        } catch (JSONException e) {
                            System.out.println(response);
                            e.printStackTrace();
                            titleCodigoPedido.setText("Item Pedido n??o encontrado");
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

    private void setComponents(ItemPedido itemPedido){
        String quantidade = String.valueOf(itemPedido.getQuantidade());
        codigoPedido.setText(itemPedido.getCodigo_pedido());
        titleCodigoPedido.setText("C??digo do Pedido: ");
        titleCodigoProduto.setText("C??digo do Produto");
        codigoProduto.setText(itemPedido.getCodigo_produto());
        titleQuantidade.setText("Quantidade:");
        quantidadeProduto.setText(quantidade);

    }
}
