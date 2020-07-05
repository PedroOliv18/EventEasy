package com.example.eventeasy.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.eventeasy.MainActivity;
import com.example.eventeasy.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CarouselView carrossel;

    private int[] sImagens = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //referências
        final CarouselView carrossel = view.findViewById(R.id.carrossel);
        Button btEspaco = view.findViewById(R.id.btServico);
        Button btServico = view.findViewById(R.id.btEspaco);

        carrossel.setPageCount(sImagens.length);
        carrossel.setImageListener(imageListener);



        btEspaco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Toast.makeText(getContext(), "Espaço", Toast.LENGTH_SHORT).show();
            }

        });

        btServico.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getContext(), "Serviço", Toast.LENGTH_SHORT).show();
//                Intent it = new Intent(getActivity(), CriarServico.class);
//                startActivity(it);
            }

        });
        return view;

    }

    ImageListener imageListener =
            new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sImagens[position]);
        }
    };



}