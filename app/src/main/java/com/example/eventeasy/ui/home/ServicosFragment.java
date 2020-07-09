package com.example.eventeasy.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eventeasy.Conexao;
import com.example.eventeasy.R;

import java.util.ArrayList;

public class ServicosFragment extends Fragment {

    private ServicosViewModel mViewModel;

    public static ServicosFragment newInstance() {
        return new ServicosFragment();
    }

//    RecyclerView recyclerView;
//    ArrayAdapter arrayAdapter;
//
//    Conexao conexao;
//    ArrayList<String> servico_id, servico_Titulo, servico_Descricao, servico_Preco, servico_Tipo, servico_Endereco;
//
//    CustomAdapter customAdapter;
//
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.servicos_fragment, container, false);

//        recyclerView = view.findViewById (R.id.recyclerView);
//
//        Conexao conexao =  new Conexao (ServicosFragment.this);
//        servico_id = new ArrayList<>();
//        servico_Titulo =  new  ArrayList <> ();
//        servico_Descricao =  new  ArrayList <> ();
//        servico_Preco =  new  ArrayList <> ();
//        servico_Tipo =  new  ArrayList <> ();
//        servico_Tipo =  new  ArrayList <> ();
//        servico_Endereco =  new  ArrayList <> ();
//
//        storeDataInArrays ();
//
//        customAdapter = new CustomAdapter(ServicosFragment.this,this, servico_id, servico_Titulo, servico_Descricao, servico_Preco, servico_Tipo, servico_Endereco);
//        recyclerView.setAdapter(customAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(ServicosFragment));
//
//

        return view;
        
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ServicosViewModel.class);
        // TODO: Use the ViewModel
    }

}