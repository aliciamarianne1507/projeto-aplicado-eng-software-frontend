package com.example.projetoaplicadopos.admin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.example.projetoaplicadopos.HttpRequest;
import com.example.projetoaplicadopos.MainActivity;
import com.example.projetoaplicadopos.R;
import com.example.projetoaplicadopos.categoria.CriarCategoria;
import com.example.projetoaplicadopos.pedidos.ListaPedidos;
import com.example.projetoaplicadopos.produtos.ListaProdutos;

import java.util.HashMap;
import java.util.Map;

public class PaginaInicialAdmin extends AppCompatActivity{

    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_admin);
        abrirTelaCategoria();
    }


    private void abrirTelaCategoria(){

        Button btnCategorias = findViewById(R.id.botao_cadastrar_categoria);
        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CriarCategoria.class);
                startActivity(intent);
            }
        });
    }

}
