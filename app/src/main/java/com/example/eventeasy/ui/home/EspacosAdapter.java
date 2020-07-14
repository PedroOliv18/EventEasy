package com.example.eventeasy.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventeasy.R;

import java.util.ArrayList;

public class EspacosAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Espaco> espacosLista;
    private ArrayList tarefa_id, tarefa_nome, tarefa_latitude, tarefa_longitude, tarefa_situacao;


    public EspacosAdapter(Context context, int layout, ArrayList<Espaco> espacosLista) {
        this.context = context;
        this.layout = layout;
        this.espacosLista = espacosLista;
    }

    @Override
    public int getCount() {
        return espacosLista.size();
    }

    @Override
    public Object getItem(int position) {
        return espacosLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtTitulo, txtPreco, txtTipo, txtDescricao, txtEndereco;
        RelativeLayout espacoLayout;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtTitulo = (TextView) row.findViewById(R.id.espaco_titulo_txt);
            holder.txtPreco = (TextView) row.findViewById(R.id.espaco_preco_txt);
            holder.txtTipo = (TextView) row.findViewById(R.id.espaco_tipo_txt);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);
            holder.espacoLayout = row.findViewById(R.id.espacoLayout);
            row.setTag(holder);

        }
        else {
            holder = (EspacosAdapter.ViewHolder) row.getTag();
        }

        Espaco espaco = espacosLista.get(position);

        holder.txtTitulo.setText(espaco.getTitulo());
        holder.txtPreco.setText(espaco.getPreco());
        holder.txtTipo.setText("Espaço");

        byte[] sImage = espaco.getImagem();
        Bitmap bitmap = BitmapFactory.decodeByteArray(sImage, 0, sImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
