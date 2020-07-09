package com.example.eventeasy.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eventeasy.Conexao;
import com.example.eventeasy.R;

import java.util.ArrayList;
import java.util.List;

public class CriarServico extends AppCompatActivity {

    private Button btCriar;
    ServicoDAO servicoDAO;
    private List<Long> lstRegistros = new ArrayList<Long>();

    EditText tituloServico, descricaoServico, precoServico, tipoServico, enderecoServico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_servico);
        setTitle("");
        //Seta voltar no appBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tituloServico = (EditText) findViewById(R.id.tituloServico);
        descricaoServico = (EditText) findViewById(R.id.descricaoServico);
        precoServico = (EditText) findViewById(R.id.precoServico);
        tipoServico = (EditText) findViewById(R.id.tipoServico);
        enderecoServico = (EditText) findViewById(R.id.enderecoServico);

        btCriar = findViewById(R.id.adicionarServico);

        servicoDAO = new ServicoDAO(getBaseContext());
        long intIdRegistro;
        String strTitulo = "";
        String strDescricao = "";
        String strPreco = "";
        String strTipo = "";
        String strEndereco = "";

//        Cursor cursorRegistros = servicoDAO.carregarDados();
//        if ((cursorRegistros != null)&&(cursorRegistros.getCount()>0)){
//            cursorRegistros.moveToFirst();
//
//            do{
//                intIdRegistro = cursorRegistros.getLong(cursorRegistros.getColumnIndexOrThrow(Conexao.ID));
//                strTitulo = cursorRegistros.getString(cursorRegistros.getColumnIndexOrThrow(Conexao.TITULO));
//                strDescricao = cursorRegistros.getString(cursorRegistros.getColumnIndexOrThrow(Conexao.DESCRICAO));
//                strPreco = cursorRegistros.getString(cursorRegistros.getColumnIndexOrThrow(Conexao.PRECO));
//                strTipo = cursorRegistros.getString(cursorRegistros.getColumnIndexOrThrow(Conexao.TIPO));
//                strEndereco = cursorRegistros.getString(cursorRegistros.getColumnIndexOrThrow(Conexao.ENDERECO));
//
//                lstRegistros.add(intIdRegistro);
//            } while(cursorRegistros.moveToNext());
//        }

        btCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarServico();
            }
        });

    }

    //cadastrando no banco
    public void criarServico() {

        long intRetornoRegistro;

        String strTitulo = tituloServico.getText().toString();
        String strDescricao = descricaoServico.getText().toString();
        String strPreco = precoServico.getText().toString();
        String strTipo = tipoServico.getText().toString();
        String strEndereco = enderecoServico.getText().toString();

        intRetornoRegistro = servicoDAO.inserirDados(strTitulo,strDescricao,strPreco,strTipo,strEndereco);


        if ((intRetornoRegistro != -1) || (strTitulo.equals("")) || (strDescricao.equals("")) || (strPreco.equals("")) || (strTipo.equals("")) || (strEndereco.equals(""))) {
            Toast.makeText(CriarServico.this, "Preencha todos os dados", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(CriarServico.this, "Anúncio criado", Toast.LENGTH_SHORT).show();
            lstRegistros.add(intRetornoRegistro);
        }

    }
}