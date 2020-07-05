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

import com.example.eventeasy.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList tarefa_id, txtTitulo, txtPreco, txtTipo, imageView;

    CustomAdapter(Activity activity, Context context, ArrayList tarefa_id, ArrayList txtTitulo, ArrayList txtPreco,
                  ArrayList txtTipo, ArrayList imageView) {
        this.activity = activity;
        this.context = context;
        this.tarefa_id = tarefa_id;
        this.txtTitulo = txtTitulo;
        this.txtPreco = txtPreco;
        this.txtTipo = txtTipo;
        this.imageView = imageView;
    }

    public CustomAdapter(Context context, ServicosFragment servicosFragment, ArrayList<String> tarefa_id, ArrayList<String> txtTitulo, ArrayList<String> txtPreco, ArrayList<String> txtTipo, ArrayList<String> imageView) {
        this.activity = activity;
        this.context = context;
        this.tarefa_id = tarefa_id;
        this.txtTitulo = txtTitulo;
        this.txtPreco = txtPreco;
        this.txtTipo = txtTipo;
        this.imageView = imageView;
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
//        holder.tarefa_nome_txt.setText(String.valueOf(tarefa_nome.get(position)));
//        holder.tarefa_la_txt.setText(String.valueOf(tarefa_latitude.get(position)));
//        holder.tarefa_lon_txt.setText(String.valueOf(tarefa_longitude.get(position)));
//        holder.tarefa_sit_txt.setText(String.valueOf(tarefa_situacao.get(position)));
//        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, DadosMapaActivity.class);
//                intent.putExtra("id", String.valueOf(tarefa_id.get(position)));
//                intent.putExtra("nomedatarefa", String.valueOf(tarefa_nome.get(position)));
//                intent.putExtra("latitude", String.valueOf(tarefa_latitude.get(position)));
//                intent.putExtra("longitude", String.valueOf(tarefa_longitude.get(position)));
//                intent.putExtra("situacao", String.valueOf(tarefa_situacao.get(position)));
//                context.startActivity(intent);
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return tarefa_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitulo, txtPreco, txtTipo;
        ImageView imageView;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTipo = itemView.findViewById(R.id.txtTitulo);
            txtPreco = itemView.findViewById(R.id.txtPreco);
            txtTipo = itemView.findViewById(R.id.txtTipo);
            imageView = itemView.findViewById(R.id.imageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }
}