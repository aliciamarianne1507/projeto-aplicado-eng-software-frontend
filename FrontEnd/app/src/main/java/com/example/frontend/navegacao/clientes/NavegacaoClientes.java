package com.example.frontend.navegacao.clientes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.frontend.MainActivity;
import com.example.frontend.R;

import com.example.frontend.cliente.buscarCliente.BuscarCliente;
import com.example.frontend.cliente.criarCliente.CriarCliente;
import com.example.frontend.cliente.editarCliente.EditarCliente;
import com.example.frontend.cliente.excluirCliente.ExcluirCliente;


public class NavegacaoClientes extends AppCompatActivity {

    private Button criar,buscar,editar,excluir, sair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_navegacao_clientes);
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
            Intent it = new Intent(NavegacaoClientes.this, MainActivity.class);
            startActivity(it);
        });
    }

    private void criar(){
        criar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoClientes.this, CriarCliente.class);
            startActivity(it);
        });
    }
    private void buscar(){
        buscar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoClientes.this, BuscarCliente.class);
            startActivity(it);
        });
    }
    private void editar(){
        editar.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoClientes.this, EditarCliente.class);
            startActivity(it);
        });
    }
    private void excluir(){
        excluir.setOnClickListener(v->{
            Intent it = new Intent(NavegacaoClientes.this, ExcluirCliente.class);
            startActivity(it);
        });
    }
}
