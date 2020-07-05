package com.example.eventeasy.ui.home;

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

import com.example.eventeasy.R;

import java.util.ArrayList;

public class ServicosFragment extends Fragment {

    private ServicosViewModel mViewModel;
    ArrayAdapter arrayAdapter;

    ArrayList<String> tarefa_id, txtTitulo, txtPreco, txtTipo, imageView;
    CustomAdapter customAdapter;

    public static ServicosFragment newInstance() {
        return new ServicosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.servicos_fragment, container, false);

        RecyclerView recyclerView = view.findViewById (R.id.recyclerView);


        tarefa_id = new ArrayList<>();
        txtTitulo =  new  ArrayList <> ();
        txtPreco =  new  ArrayList <> ();
        txtTipo =  new  ArrayList <> ();
        imageView =  new  ArrayList <> ();

        customAdapter = new CustomAdapter(getContext(),this, tarefa_id, txtTitulo, txtPreco, txtTipo, imageView);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ServicosViewModel.class);
        // TODO: Use the ViewModel
    }

}