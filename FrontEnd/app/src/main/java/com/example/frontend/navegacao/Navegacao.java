package com.example.frontend.navegacao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.frontend.MainActivity;
import com.example.frontend.R;
import com.example.frontend.cliente.criarCliente.CriarCliente;
import com.example.frontend.login.Login;
import com.example.frontend.navegacao.categoria.NavegacaoCategoria;
import com.example.frontend.navegacao.clientes.NavegacaoClientes;
import com.example.frontend.navegacao.itempedidos.NavegacaoItemPedidos;
import com.example.frontend.navegacao.pedidos.NavegacaoPedidos;
import com.example.frontend.navegacao.produtos.NavegacaoProdutos;

public class Navegacao  extends AppCompatActivity {
    private Button irCategorias,irProdutos,irPedidos,irItemPedido,irClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_navegacao);
        components();
        goCategoria();
        goProdutos();
        goPedidos();
        goClientes();
        goItemPedido();
    }
    private void components(){
        irCategorias = findViewById(R.id.categorias);
        irProdutos = findViewById(R.id.produtos);
        irPedidos = findViewById(R.id.pedidos);
        irClientes = findViewById(R.id.clientes);
        irItemPedido = findViewById(R.id.itempedido);
    }
    private void goCategoria(){
        irCategorias.setOnClickListener(v->{
            Intent it = new Intent(Navegacao.this, NavegacaoCategoria.class);
            startActivity(it);
        });
    }
    private void goProdutos(){
        irProdutos.setOnClickListener(v->{
            Intent it = new Intent(Navegacao.this, NavegacaoProdutos.class);
            startActivity(it);
        });
    }
    private void goPedidos(){
        irPedidos.setOnClickListener(v->{
            Intent it = new Intent(Navegacao.this, NavegacaoPedidos.class);
            startActivity(it);
        });
    }
    private void goClientes(){
        irClientes.setOnClickListener(v->{
            Intent it = new Intent(Navegacao.this, NavegacaoClientes.class);
            startActivity(it);
        });
    }
    private void goItemPedido(){
        irItemPedido.setOnClickListener(v->{
            Intent it = new Intent(Navegacao.this, NavegacaoItemPedidos.class);
            startActivity(it);
        });
    }
}
