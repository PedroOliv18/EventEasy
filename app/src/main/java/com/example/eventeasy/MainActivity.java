package com.example.eventeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView cadastrese;
    private EditText email, senha;
    private Button btEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastrese = findViewById(R.id.cadastrese);
        email = findViewById(R.id.loginEmail);
        senha = findViewById(R.id.loginSenha);
        btEntrar = findViewById(R.id.loginBtEntrar);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Entrando", Toast.LENGTH_SHORT).show();
            }
        });

        cadastrese.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, tpCad.class);
                startActivity(it);
            }

        });
    }
}
