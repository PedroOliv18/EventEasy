package com.example.eventeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadCliente extends AppCompatActivity {

    private EditText usuario, senha, email, telefone, datanasc;
    private Button btentrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_cliente);

        usuario = findViewById(R.id.cadCliUsuario);
        senha = findViewById(R.id.cadCliSenha);
        email = findViewById(R.id.cadCliEmail);
        telefone = findViewById(R.id.cadCliTelefone);
        datanasc = findViewById(R.id.cadCliDataNasc);
        btentrar = findViewById(R.id.cadCliBtEntrar);

        btentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cadCliente.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
