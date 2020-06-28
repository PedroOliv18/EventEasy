package com.example.eventeasy.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.eventeasy.R;

public class CriarEspaco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_espaco);
        setTitle("");
        //Seta voltar no appBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}