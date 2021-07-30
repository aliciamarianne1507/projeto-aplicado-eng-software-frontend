package com.example.frontend.pedidos.buscarPedido;

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
import com.example.frontend.pedidos.Pedido;

import org.json.JSONException;
import org.json.JSONObject;

public class BuscarPedido extends AppCompatActivity {

    private TextView codigoPedido, cpfPedido,quantidadePedido,titleCodigoPedido, titleCpfPedido,titleQuantidade;
    private EditText idPedido;
    private Button buscarPedido;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_pedido);
        components();
        search();
    }

    private void components(){
        codigoPedido = findViewById(R.id.codigo_pedido);
        cpfPedido = findViewById(R.id.cpf_cliente);
        quantidadePedido= findViewById(R.id.quantidade_pedido);
        titleCodigoPedido = findViewById(R.id.title_codigo_pedido);
        titleCpfPedido= findViewById(R.id.title_cpf_cliente);
        titleQuantidade = findViewById(R.id.title_quantidade);
        idPedido = findViewById(R.id.id_pedido);
        buscarPedido = findViewById(R.id.search_pedido);
        queue = Volley.newRequestQueue(this);
    }
    private void search(){
        buscarPedido.setOnClickListener(v -> buscarPedido());

    }
    private void buscarPedido(){
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                U.BASE_URL + "/pedidos/" + idPedido.getText(),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            System.out.println(response);
                            Pedido pedido = new Pedido(
                                    response.getString("codigo_pedido"),
                                    response.getString("cpf"),
                                    response.getString("created_at"),
                                    response.getString("updated_at"),
                                    response.getInt("quantidade")

                            );
                            setComponents(pedido);

                        } catch (JSONException e) {
                            System.out.println(response);
                            e.printStackTrace();
                            titleCodigoPedido.setText("Pedido não encontrado");
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

    private void setComponents(Pedido pedido){
        String quantidade = String.valueOf(pedido.getQuantidade());
        codigoPedido.setText(pedido.getCodigo_pedido());
        cpfPedido.setText(pedido.getCpf());
        quantidadePedido.setText(quantidade);
        titleCodigoPedido.setText("Código do Pedido:");
        titleCpfPedido.setText("CPF do Cliente:");
        titleQuantidade.setText("Quantidade:");

    }
}

