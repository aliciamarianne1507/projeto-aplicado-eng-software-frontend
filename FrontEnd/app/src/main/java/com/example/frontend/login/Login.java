package com.example.frontend.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.frontend.ErrorDialog;
import com.example.frontend.MainActivity;
import com.example.frontend.R;
import com.example.frontend.U;
import com.example.frontend.navegacao.Navegacao;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    private EditText email,senha;
    private Button login, criarConta,sair;
    private RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        components();
        makeLogin();
        createAccount();
        sair();
    }

    private void components(){
        queue = Volley.newRequestQueue(this);
        login = findViewById(R.id.fazer_login);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        criarConta = findViewById(R.id.criar_conta);
        sair = findViewById(R.id.sair);
    }

    private void makeLogin(){
        login.setOnClickListener(v -> {
            Authentication();
            Intent it = new Intent(Login.this, Navegacao.class);
            startActivity(it);
        });
    }
    private void createAccount(){
        criarConta.setOnClickListener(v->{
            Intent it = new Intent(Login.this, Navegacao.class);
            startActivity(it);
        });
    }
    private void sair(){
        sair.setOnClickListener(v->{
            Intent it = new Intent(Login.this, MainActivity.class);
            startActivity(it);
        });
    }

    private void Authentication(){
        JSONObject postData = new JSONObject();
        try{
            postData.put("email", email.getText());
            postData.put("senha",senha.getText());
        }catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                U.BASE_URL + "/login",
                postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            System.out.println(response);
                            Authentication authentication = new Authentication(
                                    response.getString("status")
                            );

                        } catch (JSONException e) {
                            System.out.println(response);
                            e.printStackTrace();
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

}
