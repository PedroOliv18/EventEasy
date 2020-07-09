package com.example.eventeasy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    //tabela serviço
    public static final String TABELA = "tarefa";
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
//    public static final String IMAGEM = "imagem";
    public static final String DESCRICAO = "descricao";
    public static final String PRECO = "preco";
    public static final String TIPO = "tipo";
    public static final String ENDERECO = "endereco";

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table usuario(id integer primary key autoincrement, nome varchar(50)," +
                "email varchar(50),cpf varchar(14), senha varchar(50), telefone varchar(20), dataNasc varchar(10), categoria varchar(20) )");


        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + DESCRICAO + " text,"
                + PRECO + " text,"
                + TIPO + " text"
                + ENDERECO + "text"
                +")";
        db.execSQL(sql);
//        + IMAGEM + " text,"
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }

    //listagem dos cards que irão aparecer
    Cursor readList(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABELA;

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
