package com.example.projetoaplicadopos.usuarios;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetoaplicadopos.MainActivity;
import com.example.projetoaplicadopos.R;
import com.example.projetoaplicadopos.pedidos.ListaPedidos;
import com.example.projetoaplicadopos.produtos.ListaProdutos;

public class PaginaInicialUsuarios extends AppCompatActivity{

    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_usuario);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        setClickListener(findViewById(R.id.fazer_pedido), ListaProdutos.class);
        setClickListener(findViewById(R.id.ver_meus_pedidos), ListaPedidos.class);
        setClickListener(findViewById(R.id.editar_perfil), EditarUsuario.class);
        setClickListener(findViewById(R.id.botao_sair), MainActivity.class);

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

}
