package com.example.eventeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TpCad extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp_cad);

        Button btCliente = findViewById(R.id.btCliente);
        Button btPrestador = findViewById(R.id.btPrestador);

        btCliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(TpCad.this, CadCliente.class);
                startActivity(it);
            }

        });
        btPrestador.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(TpCad.this, CadPrestador.class);
                startActivity(it);
            }

        });
    }
}