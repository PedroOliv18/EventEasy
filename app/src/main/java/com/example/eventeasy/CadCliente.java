package com.example.eventeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class CadCliente extends AppCompatActivity {

    private EditText nome, senha,cpf, email, telefone, datanasc;
    private Button btentrar;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_cliente);

        nome = findViewById(R.id.cadCliNome);
        email = findViewById(R.id.cadCliEmail);
        cpf = findViewById(R.id.cadCliCpf);
        senha = findViewById(R.id.cadCliSenha);
        telefone = findViewById(R.id.cadCliTelefone);
        datanasc = findViewById(R.id.cadCliDataNasc);
        btentrar = findViewById(R.id.cadCliBtEntrar);

        dao = new UsuarioDAO(this);

        //Criando máscaras para os campos

        //Máscara para o campo telefone
        SimpleMaskFormatter snfTelefone = new SimpleMaskFormatter("(NN) N NNNN-NNNN");
        MaskTextWatcher mtwTelefone = new MaskTextWatcher(telefone,snfTelefone);
        telefone.addTextChangedListener(mtwTelefone);

        //máscara para a data de nascimento
        SimpleMaskFormatter snfDataNasc = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtwDataNasc = new MaskTextWatcher(datanasc,snfDataNasc);
        datanasc.addTextChangedListener(mtwDataNasc);

        //Fim das máscara
    }

    public void botao(View view){

    btentrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Usuario u = new Usuario();
            u.setNome(nome.getText().toString());
            u.setEmail(email.getText().toString());
            u.setCpf(cpf.getText().toString());
            u.setSenha(senha.getText().toString());
            u.setTelefone(telefone.getText().toString());
            u.setDataNasc(datanasc.getText().toString());
            u.setCategoria("cliente");

            long id = dao.inserir(u);
            Toast.makeText(CadCliente.this, "Id: "+ id, Toast.LENGTH_SHORT).show();

            Intent it = new Intent(CadCliente.this, TpCad.class);
            startActivity(it);
            finish();
        }
    });

}}
