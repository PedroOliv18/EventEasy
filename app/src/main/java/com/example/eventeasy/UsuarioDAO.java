package com.example.eventeasy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public UsuarioDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("cpf", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        values.put("telefone", usuario.getTelefone());
        values.put("dataNasc", usuario.getDataNasc());
        values.put("categoria", usuario.getCategoria());

        return banco.insert("usuario", null, values);
    }

}
