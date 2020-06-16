package com.example.eventeasy.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.eventeasy.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CarouselView carrossel;
    private Button btEspaco;
    private Button btServico;

    int[] sImagens = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //referências
        final CarouselView carrossel = root.findViewById(R.id.carrossel);
//        final Button btEspaco = root.findViewById(R.id.btCliente);
//        final Button btServico = root.findViewById(R.id.btServico);

        carrossel.setPageCount(sImagens.length);
        carrossel.setImageListener(imageListener);
        return root;


    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sImagens[position]);
        }
    };
}