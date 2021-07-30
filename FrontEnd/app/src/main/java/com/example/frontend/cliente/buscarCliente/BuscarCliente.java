package com.example.frontend.cliente.buscarCliente;

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
import com.example.frontend.cliente.Cliente;

import org.json.JSONException;
import org.json.JSONObject;

public class BuscarCliente extends AppCompatActivity {

    private TextView nomeCliente, cpfCliente,emailCliente, telefoneCliente,enderecoCliente,estadoCliente,municipioCliente;
    private TextView titleNomeCliente, titleCpfCliente,titleEmailCliente, titleTelefoneCliente,titleEnderecoCliente,titleEstadoCliente,titleMunicipioCliente;
    private EditText cpfClientPesquisa;
    private Button buscarCliente;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_cliente);
        components();
        search();
    }

    private void components(){
        cpfClientPesquisa = findViewById(R.id.cpf_cliente_pesquisa);
        nomeCliente = findViewById(R.id.nome_cliente);
        cpfCliente = findViewById(R.id.cpf_cliente);
        emailCliente = findViewById(R.id.email_cliente);
        telefoneCliente = findViewById(R.id.telefone_cliente);
        enderecoCliente = findViewById(R.id.endereco_cliente);
        estadoCliente = findViewById(R.id.estado_cliente);
        municipioCliente = findViewById(R.id.municipio_cliente);
        titleNomeCliente = findViewById(R.id.title_nome_cliente);
        titleCpfCliente = findViewById(R.id.title_cpf_cliente);
        titleEmailCliente = findViewById(R.id.title_email_cliente);
        titleTelefoneCliente = findViewById(R.id.title_telefone_cliente);
        titleEnderecoCliente = findViewById(R.id.title_endereco_cliente);
        titleEstadoCliente = findViewById(R.id.title_estado_cliente);
        titleMunicipioCliente = findViewById(R.id.title_municipio_cliente);
        buscarCliente = findViewById(R.id.search_cliente);
        queue = Volley.newRequestQueue(this);
    }
    private void search(){
        buscarCliente.setOnClickListener(v -> buscarCliente());

    }
    private void buscarCliente(){
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                U.BASE_URL + "/cliente/" + cpfClientPesquisa.getText(),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            System.out.println(response);
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
                            setComponents(cliente);

                        } catch (JSONException e) {
                            System.out.println(response);
                            e.printStackTrace();
                            titleNomeCliente.setText("Cliente não encontrado");
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

    private void setComponents(Cliente cliente){
        nomeCliente.setText(cliente.getName());
        cpfCliente.setText(cliente.getCpf());
        emailCliente.setText(cliente.getEmail());
        telefoneCliente.setText(cliente.getTelefone());
        enderecoCliente.setText(cliente.getEndereco());
        estadoCliente.setText(cliente.getEstado());
        municipioCliente.setText(cliente.getMunicipio());
        titleNomeCliente.setText("Nome do Cliente:");
        titleCpfCliente.setText("CPF Cliente:");
        titleEmailCliente.setText("Email do cliente:");
        titleTelefoneCliente.setText("Telefone");
        titleEnderecoCliente.setText("Endereço:");
        titleEstadoCliente.setText("Estado:");
        titleMunicipioCliente.setText("Municipio:");

    }
}
