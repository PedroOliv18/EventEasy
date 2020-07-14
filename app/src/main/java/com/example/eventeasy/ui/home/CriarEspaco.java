package com.example.eventeasy.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.eventeasy.Conexao;
import com.example.eventeasy.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CriarEspaco extends AppCompatActivity {

    private Button btCriar,btEscolher,btLista;

    EditText nomeEspaco, descricaoEspaço, precoEspaco, enderecoEspaco;

    ImageView imageView;

    final int REQUEST_CODE_GALLERY = 999;
    public static Conexao conexao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_espaco);
        setTitle("");
        //Seta voltar no appBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nomeEspaco = (EditText) findViewById(R.id.nomeEspaco);
        descricaoEspaço = (EditText) findViewById(R.id.descricaoEspaço);
        precoEspaco = (EditText) findViewById(R.id.precoEspaco);
        enderecoEspaco = (EditText) findViewById(R.id.enderecoEspaco);
        imageView = (ImageView) findViewById(R.id.imageView);


        btCriar = findViewById(R.id.adicionarServico);
        btEscolher = findViewById(R.id.btEscolher);
        btLista = findViewById(R.id.btLista);

        conexao = new Conexao(getBaseContext());

        conexao.consulta("CREATE TABLE IF NOT EXISTS ESPACO(Id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, descricao VARCHAR, preco VARCHAR, endereco VARCHAR, imagem BLOB)");
        btEscolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        CriarEspaco.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        btCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    conexao.inserirDadosEsp(
                            nomeEspaco.getText().toString().trim(),
                            descricaoEspaço.getText().toString().trim(),
                            precoEspaco.getText().toString().trim(),
                            enderecoEspaco.getText().toString().trim(),
                            imageViewToByte(imageView)
                    );
                    String descricaoEspaçoo = descricaoEspaço.getText().toString().trim();
                    Toast.makeText(CriarEspaco.this, "Espaço adicionado", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CriarEspaco.this, EspacosActivity.class);
                startActivity(intent);
            }
        });

    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(), "Você não tem permissão para acessar", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }



}