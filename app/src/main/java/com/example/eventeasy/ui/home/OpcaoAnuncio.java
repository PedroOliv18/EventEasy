package com.example.eventeasy.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.eventeasy.CadCliente;
import com.example.eventeasy.R;
import com.example.eventeasy.TpCad;

public class OpcaoAnuncio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcao_anuncio);
        ImageButton imageButton = findViewById(R.id.imageButton);
        ImageButton imageButton2 = findViewById(R.id.imageButton2);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(OpcaoAnuncio.this, CriarEspaco.class);
                startActivity(it);
            }

        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(OpcaoAnuncio.this, CriarServico.class);
                startActivity(it);
            }

        });

    }
}