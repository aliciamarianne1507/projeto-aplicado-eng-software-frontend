package com.example.frontend.categoria.excluirCategoria;

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
import com.example.frontend.Excluir;

import org.json.JSONException;
import org.json.JSONObject;


public class ExcluirCategoria extends AppCompatActivity {
    private EditText codigoCategoria;
    private TextView statusExclusao;
    private Button deleteButton;
    private RequestQueue queue;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excluir_categoria);
        components();
        delete();
    }

    public void components() {
       codigoCategoria = findViewById(R.id.cod_categoria);
       statusExclusao = findViewById(R.id.title_status_exclusao);
       deleteButton = findViewById(R.id.delete_button);
       queue = Volley.newRequestQueue(this);
    }

    public void delete(){deleteButton.setOnClickListener(v-> deleteCategory());}

    public void deleteCategory(){
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.DELETE,
                U.BASE_URL + "/categoria/" + codigoCategoria.getText(),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Excluir excluir = new Excluir(
                                    response.getString("message")
                            );
                            setComponents(excluir);
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                            statusExclusao.setText("Erro ao excluir categoria");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        statusExclusao.setText("Erro ao excluir categoria");
                    }
                }
        );
        queue.add(request);
    }

    private void setComponents(Excluir excluir){
        statusExclusao.setText(excluir.getMessage());
    }
}
