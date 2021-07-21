package com.example.projetoaplicadopos.categoria;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.example.projetoaplicadopos.HttpRequest;
import com.example.projetoaplicadopos.R;
import com.example.projetoaplicadopos.StatusResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static android.view.View.VISIBLE;

public class CriarCategoria extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.criar_categoria);
        cadastrarCategoria();
    }

    private void cadastrarCategoria(){
        Button cadastrarCategoria = findViewById(R.id.botao_cadastrar_categoria);
        cadastrarCategoria.setOnClickListener(new View.OnClickListener(){

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                TextView idCategoria = findViewById(R.id.cadastro_codigo_categoria);
                TextView nomeCategoria = findViewById(R.id.cadastro_nome_categoria);

                HttpRequest http = new HttpRequest("categoria");
                Map<String, String> bodyParams = new HashMap<>();
                bodyParams.put("name_categoria", nomeCategoria.getText().toString());
                StatusResponse statusResponse = http.sendPostRequest(Request.Method.POST, bodyParams, context);

                if (Objects.isNull(statusResponse.getMessage())){
                    TextView textView = findViewById(R.id.categoria_cadastrada);
                    textView.setVisibility(VISIBLE);
                }
            }
        });
    }
}