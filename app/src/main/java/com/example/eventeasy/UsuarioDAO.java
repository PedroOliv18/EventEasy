package com.example.eventeasy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    //Método para verificar login (usuário e senha)
    public boolean acessar(String email, String senha){
        //A classe Cursor serve para armazenar o retorno de um comando SELECT
        Cursor c = banco.rawQuery("SELECT * FROM usuario WHERE email = ?",
                new String[]{email});


        //Testar se o retorno do SELECT tem alguma coisa ou não
        if(c.moveToFirst()){ //Se conseguir ir até a primeira linha, então há pelo menos uma linha
            do{
                //Recuperar o valor da coluna 2 (índice 2 -> coluna da senha)
                String senhaTabela = c.getString(4);


//              //Comparando as senhas se são iguais
                if(senhaTabela.equals(senha)){
                    banco.close();
                    c.close();
                    return true;
                }
            }while (c.moveToNext()); //Enquanto houverem linhas
        }
        return false;
    }

}
