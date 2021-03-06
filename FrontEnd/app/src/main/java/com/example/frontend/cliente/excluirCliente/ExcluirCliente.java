package com.example.frontend.cliente.excluirCliente;

import android.annotation.SuppressLint;
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
import com.example.frontend.Excluir;
import com.example.frontend.R;
import com.example.frontend.U;

import org.json.JSONException;
import org.json.JSONObject;

public class ExcluirCliente extends AppCompatActivity {
    private RequestQueue queue;
    private Button excluirCliente;
    private EditText cpfCliente;
    private TextView statusExclusao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_cliente);
        components();
        delete();
    }

    @SuppressLint("WrongViewCast")
    private void components(){
        queue = Volley.newRequestQueue(this);
        excluirCliente = findViewById(R.id.delete_button_cliente);
        cpfCliente = findViewById(R.id.cpf_cliente);
        statusExclusao = findViewById(R.id.title_status_exclusao);


    }
    private void delete(){
        excluirCliente.setOnClickListener(v -> deleteClient());

    }
    private void deleteClient(){
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.DELETE,
                U.BASE_URL + "/cliente/" + cpfCliente.getText(),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            System.out.println(response);
                            Excluir excluir = new Excluir(
                                    response.getString("message")
                            );
                            setComponents(excluir);

                        } catch (JSONException e) {
                            System.out.println(response);
                            e.printStackTrace();
                            statusExclusao.setText("Produto n??o excluido");
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

    private void setComponents(Excluir excluir){
        statusExclusao.setText(excluir.getMessage());
    }
}
