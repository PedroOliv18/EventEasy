package com.example.eventeasy.ui.home;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eventeasy.R;
import com.example.eventeasy.ui.home.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;

    public MyItemRecyclerViewAdapter(List<DummyItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_servico, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.servico_nome_txt.setText(mValues.get(position).servico_Titulo);
        holder.servico_preco_txt.setText(mValues.get(position).servico_Preco);
        holder.servico_tipo_txt.setText(mValues.get(position).servico_Tipo);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final TextView servico_nome_txt, servico_tipo_txt, servico_preco_txt;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            servico_nome_txt =  (TextView) view.findViewById(R.id.servico_titulo_txt);
            servico_tipo_txt =  (TextView) view.findViewById(R.id.servico_tipo_txt);
            servico_preco_txt =  (TextView) view.findViewById(R.id.servico_preco_txt);
        }

    }
}