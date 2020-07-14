package com.example.eventeasy.ui.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eventeasy.R;

import java.util.ArrayList;

public class ServicoAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Servico> servicosLista;

    public ServicoAdapter(Context context, int layout, ArrayList<Servico> servicosLista) {
        this.context = context;
        this.layout = layout;
        this.servicosLista = servicosLista;
    }

    @Override
    public int getCount() {
        return servicosLista.size();
    }

    @Override
    public Object getItem(int position) {
        return servicosLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtTitulo, txtPreco, txtTipo;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtTitulo = (TextView) row.findViewById(R.id.servico_titulo_txt);
            holder.txtPreco = (TextView) row.findViewById(R.id.servico_preco_txt);
            holder.txtTipo = (TextView) row.findViewById(R.id.servico_tipo_txt);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Servico servico = servicosLista.get(position);

        holder.txtTitulo.setText(servico.getTitulo());
        holder.txtPreco.setText(servico.getPreco());
        holder.txtTipo.setText("Serviço");

        byte[] sImage = servico.getImagem();
        Bitmap bitmap = BitmapFactory.decodeByteArray(sImage, 0, sImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
