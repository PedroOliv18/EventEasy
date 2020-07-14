package com.example.eventeasy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;


    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table usuario(id integer primary key autoincrement, nome varchar(50)," +
                "email varchar(50),cpf varchar(14), senha varchar(50), telefone varchar(20), dataNasc varchar(10), categoria varchar(20) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public void consulta(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void inserirDados(String titulo, String preco, byte[] imagem){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO SERVICO VALUES (NULL, ?, ?, ?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, titulo);
        statement.bindString(2, preco);
        statement.bindBlob(3, imagem);

        statement.executeInsert();
    }

    public void inserirDadosEsp(String titulo, String descricao, String preco, String endereco, byte[] imagem){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO ESPACO VALUES (NULL, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, titulo);
        statement.bindString(2, descricao);
        statement.bindString(3, preco);
        statement.bindString(4, endereco);
        statement.bindBlob(5, imagem);

        statement.executeInsert();
    }

    public Cursor getDados(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }



}
