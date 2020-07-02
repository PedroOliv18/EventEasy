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

public class CadPrestador extends AppCompatActivity {

    private EditText nome, cpf, email, telefone, dataNasc, senha;
    private Button btEntrar;
    private UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_prestador);

        nome = findViewById(R.id.cadPresnome);

        cpf = findViewById(R.id.cadPresCpf);
        email = findViewById(R.id.cadPresEmail);
        telefone = findViewById(R.id.cadPresTelefone);
        dataNasc = findViewById(R.id.cadPresDatanasc);
        senha = findViewById(R.id.cadPresSenha);
        btEntrar = findViewById(R.id.cadPresBtEntrar);

        dao = new UsuarioDAO(this);

        //Criando máscaras para os campos

        //Máscara para o campo telefone
        SimpleMaskFormatter snfTelefone = new SimpleMaskFormatter("(NN) N NNNN-NNNN");
        MaskTextWatcher mtwTelefone = new MaskTextWatcher(telefone,snfTelefone);
        telefone.addTextChangedListener(mtwTelefone);

        //máscara para a data de nascimento
        SimpleMaskFormatter snfDataNasc = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtwDataNasc = new MaskTextWatcher(dataNasc,snfDataNasc);
        dataNasc.addTextChangedListener(mtwDataNasc);

        //Fim das máscara



    }
    public void botaoPres (View view){
     btEntrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Usuario u = new Usuario();
            u.setNome(nome.getText().toString());
            u.setEmail(email.getText().toString());
            u.setCpf(cpf.getText().toString());
            u.setSenha(senha.getText().toString());
            u.setTelefone(telefone.getText().toString());
            u.setDataNasc(dataNasc.getText().toString());
            u.setCategoria("prestador");

            long id = dao.inserir(u);
            Toast.makeText(CadPrestador.this, "Id: "+id, Toast.LENGTH_SHORT).show();

            Intent it = new Intent(CadPrestador.this, TpCad.class);
            startActivity(it);
            finish();
        }
    });
}}
