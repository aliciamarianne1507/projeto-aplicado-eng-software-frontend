package com.example.frontend;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.frontend.categoria.Excluir;
import com.example.frontend.categoria.excluirCategoria.ExcluirCategoria;
import com.example.frontend.login.Login;
import com.example.frontend.produto.buscarProduto.BuscarProduto;
import com.example.frontend.produto.criarProduto.CriarProduto;
import com.example.frontend.produto.editarProduto.EditarProduto;
import com.example.frontend.produto.excluirProduto.ExcluirProduto;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Button accessButton = findViewById(R.id.access_button);

        accessButton.setOnClickListener(v -> {
            Intent it = new Intent(MainActivity.this, ExcluirProduto.class);
            startActivity(it);
        });
    }

}
