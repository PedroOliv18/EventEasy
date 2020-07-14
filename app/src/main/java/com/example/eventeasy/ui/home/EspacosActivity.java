package com.example.eventeasy.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.eventeasy.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class EspacosActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Espaco> lista;
    EspacosAdapter adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espacos);
        setTitle("");
        //Seta voltar no appBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridView = (GridView) findViewById(R.id.gridView);
        lista = new ArrayList<>();
        adapter = new EspacosAdapter(this, R.layout.item_espaco, lista);
        gridView.setAdapter(adapter);

        Cursor cursor = CriarEspaco.conexao.getDados("SELECT * FROM ESPACO");
        lista.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String titulo = cursor.getString(1);
            String descricao = cursor.getString(2);
            String preco = cursor.getString(3);
            String endereco = cursor.getString(4);

            byte[] imagem = cursor.getBlob(5);
//            String descricao = cursor.getString(4);
//            String endereco = cursor.getString(5);
            lista.add(new Espaco(titulo, descricao, preco, endereco, imagem, id));
        }
        adapter.notifyDataSetChanged();

    }



    ImageView imageView;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 888){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 888);
            }
            else {
                Toast.makeText(getApplicationContext(), "Sem permissão para acessar a galeria", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 888 && resultCode == RESULT_OK && data != null){
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