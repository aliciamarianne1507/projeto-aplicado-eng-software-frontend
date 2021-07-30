package com.example.frontend.navegacao.categoria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.example.frontend.MainActivity;
import com.example.frontend.R;
import com.example.frontend.categoria.buscarCategorias.BuscarCategorias;
import com.example.frontend.categoria.criarCategoria.CriarCategoria;
import com.example.frontend.categoria.editarCategoria.EditarCategoria;
import com.example.frontend.categoria.excluirCategoria.ExcluirCategoria;

public class NavegacaoCategoria extends AppCompatActivity {

    private Button criar,buscar,editar,excluir, sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_navegacao_categorias);
        components();
        criar();
        buscar();
        editar();
        excluir();
        sair();
    }

    private void components() {
        criar = findViewById(R.id.post);
        buscar = findViewById(R.id.get);
        editar = findViewById(R.id.put);
        excluir = findViewById(R.id.delete);
        sair = findViewById(R.id.sair);
    }

    private void sair(){
        sair.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoCategoria.this, MainActivity.class);
            startActivity(it);
        });
    }

    private void criar(){
        criar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoCategoria.this, CriarCategoria.class);
            startActivity(it);
        });
    }
    private void buscar(){
        buscar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoCategoria.this, BuscarCategorias.class);
            startActivity(it);
        });
    }
    private void editar(){
        editar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoCategoria.this, EditarCategoria.class);
            startActivity(it);
        });
    }
    private void excluir(){
        excluir.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoCategoria.this, ExcluirCategoria.class);
            startActivity(it);
        });
    }
}