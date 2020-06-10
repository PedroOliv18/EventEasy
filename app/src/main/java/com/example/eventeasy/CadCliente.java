package com.example.eventeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadCliente extends AppCompatActivity {

    private EditText nome, senha, email, telefone, datanasc;
    private Button btentrar;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_cliente);

        nome = findViewById(R.id.cadCliNome);
        senha = findViewById(R.id.cadCliSenha);
        email = findViewById(R.id.cadCliEmail);
        telefone = findViewById(R.id.cadCliTelefone);
        datanasc = findViewById(R.id.cadCliDataNasc);
        btentrar = findViewById(R.id.cadCliBtEntrar);

        dao = new UsuarioDAO(this);
    }

    public void botao(View view){

    btentrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Usuario u = new Usuario();
            u.setNome(nome.getText().toString());
            u.setEmail(email.getText().toString());
            u.setSenha(senha.getText().toString());
            u.setTelefone(telefone.getText().toString());
            u.setDataNasc(datanasc.getText().toString());
            u.setCategoria("cliente");

            long id = dao.inserir(u);
            Toast.makeText(CadCliente.this, "Id: "+id, Toast.LENGTH_SHORT).show();

            Intent it = new Intent(CadCliente.this, TpCad.class);
            startActivity(it);
            finish();
        }
    });

}}
