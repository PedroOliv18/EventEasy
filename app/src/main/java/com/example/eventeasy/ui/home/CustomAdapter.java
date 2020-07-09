package com.example.eventeasy.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventeasy.Conexao;
import com.example.eventeasy.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList servico_id, servico_Titulo, servico_Descricao, servico_Preco, servico_Tipo, servico_Endereco;

    CustomAdapter(Activity activity, Context context, ArrayList servico_id, ArrayList servico_Titulo, ArrayList servico_Descricao, ArrayList servico_Preco,
                  ArrayList servico_Tipo, ArrayList servico_Endereco) {
        this.activity = activity;
        this.context = context;
        this.servico_id = servico_id;
        this.servico_Titulo = servico_Titulo;
        this.servico_Descricao = servico_Descricao;
        this.servico_Preco = servico_Preco;
        this.servico_Tipo = servico_Tipo;
        this.servico_Endereco = servico_Endereco;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_servico, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.servico_nome_txt.setText(String.valueOf(servico_Titulo.get(position)));
        holder.servico_preco_txt.setText(String.valueOf(servico_Preco.get(position)));
        holder.servico_tipo_txt.setText(String.valueOf(servico_Tipo.get(position)));
        holder.servicoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, DadosServicoActivity.class);
//                intent.putExtra("id", String.valueOf(servico_id.get(position)));
//                intent.putExtra("titulo", String.valueOf(servico_Titulo.get(position)));
//                intent.putExtra("descricao", String.valueOf(servico_Descricao.get(position)));
//                intent.putExtra("preco", String.valueOf(servico_Preco.get(position)));
//                intent.putExtra("tipo", String.valueOf(servico_Tipo.get(position)));
//                intent.putExtra("endereco", String.valueOf(servico_Endereco.get(position)));
//                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return servico_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView servico_nome_txt, servico_tipo_txt, servico_preco_txt;
        LinearLayout servicoLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            servico_nome_txt = itemView.findViewById(R.id.servico_titulo_txt);
            servico_tipo_txt = itemView.findViewById(R.id.servico_tipo_txt);
            servico_preco_txt = itemView.findViewById(R.id.servico_preco_txt);
            servicoLayout = itemView.findViewById(R.id.servicoLayout);
        }

    }
}