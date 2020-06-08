package com.example.eventeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadPrestador extends AppCompatActivity {

    private EditText nome, usuario, email, telefone, dataNasc, senha;
    private Button btEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prestador);

        nome = findViewById(R.id.cadPresnome);
        usuario = findViewById(R.id.cadPresUsuario);
        email = findViewById(R.id.cadPresEmail);
        telefone = findViewById(R.id.cadPresTelefone);
        dataNasc = findViewById(R.id.cadPresDatanasc);
        senha = findViewById(R.id.cadPresSenha);
        btEntrar = findViewById(R.id.cadPresBtEntrar);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cadPrestador.this, "cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
