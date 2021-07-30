package com.example.frontend;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.frontend.cliente.buscarCliente.BuscarCliente;
import com.example.frontend.cliente.excluirCliente.ExcluirCliente;
import com.example.frontend.itempedidos.buscarItemPedido.BuscarItemPedido;
import com.example.frontend.itempedidos.excluirItemPedido.ExcluirItemPedido;
import com.example.frontend.pedidos.buscarPedido.BuscarPedido;
import com.example.frontend.pedidos.excluirPedido.ExcluirPedido;
import com.example.frontend.produto.excluirProduto.ExcluirProduto;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Button accessButton = findViewById(R.id.access_button);

        accessButton.setOnClickListener(v -> {
            Intent it = new Intent(MainActivity.this, BuscarPedido.class);
            startActivity(it);
        });
    }

}
