package com.example.frontend.cliente.criarCliente;

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
import com.example.frontend.cliente.Cliente;

import org.json.JSONException;
import org.json.JSONObject;

public class CriarCliente extends AppCompatActivity {

    private EditText nomeCliente,telefoneCliente,cpfCliente,emailCliente,enderecoCliente,estadoCliente,municipioCliente,senhaCliente;
    private Button criarCliente;
    private TextView titleStatusCreated;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_cliente);
        components();
        create();
    }

    private void components(){
        nomeCliente = findViewById(R.id.nome_cliente);
        telefoneCliente = findViewById(R.id.telefone_cliente);
        cpfCliente = findViewById(R.id.cpf_cliente);
        emailCliente = findViewById(R.id.email_cliente);
        enderecoCliente = findViewById(R.id.endereco_cliente);
        estadoCliente= findViewById(R.id.estado_cliente);
        municipioCliente = findViewById(R.id.municipio_cliente);
        senhaCliente = findViewById(R.id.senha);
        criarCliente = findViewById(R.id.create_client_button);
        titleStatusCreated= findViewById(R.id.title_status_created);
        queue = Volley.newRequestQueue(this);

    }

    private void create(){
        criarCliente.setOnClickListener(v->createCliente());
    }

    private void createCliente(){
        JSONObject postData = new JSONObject();
        try{
            postData.put("name",nomeCliente.getText());
            postData.put("cpf",cpfCliente.getText());
            postData.put("email",emailCliente.getText());
            postData.put("telefone",telefoneCliente.getText());
            postData.put("endereco",enderecoCliente.getText());
            postData.put("estado",estadoCliente.getText());
            postData.put("municipio",municipioCliente.getText());
            postData.put("senha",senhaCliente.getText());
        }catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                U.BASE_URL + "/cliente",
                postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Cliente cliente = new Cliente(
                                    response.getString("name"),
                                    response.getString("cpf"),
                                    response.getString("email"),
                                    response.getString("telefone"),
                                    response.getString("endereco"),
                                    response.getString("estado"),
                                    response.getString("municipio"),
                                    response.getString("created_at"),
                                    response.getString("updated_at")
                            );
                            titleStatusCreated.setText("Cliente Criado com sucesso!!!");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            titleStatusCreated.setText("Erro ao criar a cliente");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        titleStatusCreated.setText("Erro ao criar a cliente");
                    }
                }
        );
        queue.add(request);
    }

}

