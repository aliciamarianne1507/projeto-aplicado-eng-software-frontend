package com.example.projetoaplicadopos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetoaplicadopos.usuarios.CadastroUsuario;
import com.example.projetoaplicadopos.admin.PaginaInicialAdmin;

public class MainActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        setClickListener(findViewById(R.id.login_cadastro), CadastroUsuario.class);
        login();
    }

    private void setClickListener(View id, Class<?> activity){

        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, activity);
                startActivity(intent);
            }
        });
    }

    private void login(){

        Button btnEntrar = findViewById(R.id.login_botao_entrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, PaginaInicialAdmin.class);
                startActivity(intent);
            }
        });

    }
}