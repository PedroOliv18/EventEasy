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
            row.setTag(holder);
        }
        else {
            holder = (EspacosAdapter.ViewHolder) row.getTag();
        }

//        holder.espacoLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, DadosMapaActivity.class);
//                intent.putExtra("id", String.valueOf(tarefa_id.get(position)));
//                intent.putExtra("nomedatarefa", String.valueOf(espaco_titulo_txt.get(position)));
//                intent.putExtra("latitude", String.valueOf(tarefa_latitude.get(position)));
//                intent.putExtra("longitude", String.valueOf(tarefa_longitude.get(position)));
//                intent.putExtra("situacao", String.valueOf(tarefa_situacao.get(position)));
//                Toast.makeText(, "", Toast.LENGTH_SHORT).show();
//                context.startActivity(intent);
//            }
//        });

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
