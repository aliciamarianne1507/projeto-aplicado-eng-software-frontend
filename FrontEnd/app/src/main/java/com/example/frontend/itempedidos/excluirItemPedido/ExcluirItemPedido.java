package com.example.frontend.itempedidos.excluirItemPedido;

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

public class ExcluirItemPedido extends AppCompatActivity {
    private RequestQueue queue;
    private Button excluirItemPedido;
    private EditText codItemPedido;
    private TextView statusExclusao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_itempedido);
        components();
        delete();
    }

    @SuppressLint("WrongViewCast")
    private void components(){
        queue = Volley.newRequestQueue(this);
        excluirItemPedido = findViewById(R.id.delete_button_itempedido);
        codItemPedido = findViewById(R.id.cod_itempedido);
        statusExclusao = findViewById(R.id.title_status_exclusao);


    }
    private void delete(){
        excluirItemPedido.setOnClickListener(v -> deleteItemPedido());

    }
    private void deleteItemPedido(){
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.DELETE,
                U.BASE_URL + "/itempedido/" + codItemPedido.getText(),
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
                            statusExclusao.setText("Item Pedido não excluido");
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
