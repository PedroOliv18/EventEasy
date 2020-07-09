package com.example.eventeasy.ui.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eventeasy.Conexao;

public class ServicoDAO {

    private SQLiteDatabase db;
    private Conexao conexao;

    public ServicoDAO (Context context){
        conexao = new Conexao(context);
    }

    public Cursor carregarDados(){
        Cursor cursor;
        String[] campos =  {conexao.ID,conexao.TITULO,conexao.DESCRICAO,conexao.PRECO,conexao.TIPO, conexao.ENDERECO};
        db = conexao.getReadableDatabase();
        cursor = db.query(conexao.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null)
            cursor.moveToFirst();
        db.close();
        return cursor;
    }

    public long inserirDados(String titulo, String descricao, String preco, String tipo, String endereco){
        ContentValues valores;
        long resultado;

        db = conexao.getWritableDatabase();
        valores = new ContentValues();
        valores.put(Conexao.TITULO, titulo);
//        valores.put(Conexao.IMAGEM, imagem);
        valores.put(Conexao.DESCRICAO, descricao);
        valores.put(Conexao.PRECO, preco);
        valores.put(Conexao.TIPO, tipo);
        valores.put(Conexao.ENDERECO, endereco);

        resultado = db.insert(Conexao.TABELA, null, valores);
        db.close();
        return  resultado;

    }

}
