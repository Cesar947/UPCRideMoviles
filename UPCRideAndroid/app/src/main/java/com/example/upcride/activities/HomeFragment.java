package com.example.upcride.activities;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.upcride.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerViewViaje;
    private RecyclerViewAdaptador adaptadorViaje;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewViaje = (RecyclerView) vista.findViewById(R.id.viajes_recycler);
        recyclerViewViaje.setLayoutManager(new LinearLayoutManager(getContext()));

        adaptadorViaje = new RecyclerViewAdaptador(carteraViajes());
        recyclerViewViaje.setAdapter(adaptadorViaje);


        return vista;


    }

    public List<ViajeModelo> carteraViajes(){
        List<ViajeModelo> viajes = new ArrayList<>();
        viajes.add(new ViajeModelo("Brian", "09:10", "Nuevo viaje Gaaaaa", "Mi Casa", "La Mierda", "20", "10", R.drawable.ricardo));
        viajes.add(new ViajeModelo("Sebastian", "22:10", "Ahhh mi pcihulaaa", "Mi Casa", "La Bika", "20", "10", R.drawable.queso));
        viajes.add(new ViajeModelo("Emilio", "21:10", "Muchachos me canse", "Mi Casa", "Desempleo", "20", "10", R.drawable.calamardo));
        viajes.add(new ViajeModelo("Brian", "09:10", "Nuevo viaje Gaaaaa", "Mi Casa", "La Mierda", "20", "10", R.drawable.ricardo));
        return viajes;
    }
}
