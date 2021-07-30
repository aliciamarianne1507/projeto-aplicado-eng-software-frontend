package com.example.frontend.navegacao.itempedidos;

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
import com.example.frontend.itempedidos.buscarItemPedido.BuscarItemPedido;
import com.example.frontend.itempedidos.criarItemPedido.CriarItemPedido;
import com.example.frontend.itempedidos.editarItemPedido.EditarItemPedido;
import com.example.frontend.itempedidos.excluirItemPedido.ExcluirItemPedido;
import com.example.frontend.navegacao.categoria.NavegacaoCategoria;

public class NavegacaoItemPedidos extends AppCompatActivity {

    private Button criar,buscar,editar,excluir, sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_navegacao_itempedidos);
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
            Intent it = new Intent(NavegacaoItemPedidos.this, MainActivity.class);
            startActivity(it);
        });
    }

    private void criar(){
        criar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoItemPedidos.this, CriarItemPedido.class);
            startActivity(it);
        });
    }
    private void buscar(){
        buscar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoItemPedidos.this, BuscarItemPedido.class);
            startActivity(it);
        });
    }
    private void editar(){
        editar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoItemPedidos.this, EditarItemPedido.class);
            startActivity(it);
        });
    }
    private void excluir(){
        excluir.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoItemPedidos.this, ExcluirItemPedido.class);
            startActivity(it);
        });
    }
}
