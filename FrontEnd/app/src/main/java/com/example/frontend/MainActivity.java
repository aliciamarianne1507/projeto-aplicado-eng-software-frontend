package com.example.frontend;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.frontend.categoria.excluirCategoria.ExcluirCategoria;
import com.example.frontend.login.Login;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Button accessButton = findViewById(R.id.access_button);

        accessButton.setOnClickListener(v -> {
            Intent it = new Intent(MainActivity.this, Login.class);
            startActivity(it);
        });
    }

}
