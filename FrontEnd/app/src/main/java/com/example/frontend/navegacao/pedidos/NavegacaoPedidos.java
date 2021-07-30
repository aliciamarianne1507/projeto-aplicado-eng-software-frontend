package com.example.frontend.navegacao.pedidos;

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
import com.example.frontend.navegacao.categoria.NavegacaoCategoria;
import com.example.frontend.pedidos.buscarPedido.BuscarPedido;
import com.example.frontend.pedidos.criarPedido.CriarPedido;
import com.example.frontend.pedidos.editarPedido.EditarPedido;
import com.example.frontend.pedidos.excluirPedido.ExcluirPedido;

public class NavegacaoPedidos extends AppCompatActivity {

    private Button criar,buscar,editar,excluir, sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_navegacao_pedidos);
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
            Intent it = new Intent(NavegacaoPedidos.this, MainActivity.class);
            startActivity(it);
        });
    }

    private void criar(){
        criar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoPedidos.this, CriarPedido.class);
            startActivity(it);
        });
    }
    private void buscar(){
        buscar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoPedidos.this, BuscarPedido.class);
            startActivity(it);
        });
    }
    private void editar(){
        editar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoPedidos.this, EditarPedido.class);
            startActivity(it);
        });
    }
    private void excluir(){
        excluir.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoPedidos.this, ExcluirPedido.class);
            startActivity(it);
        });
    }
}
