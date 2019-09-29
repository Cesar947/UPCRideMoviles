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
public class ViajesFragment extends Fragment {

    private RecyclerView recyclerViewViaje;
    private ViajesAdapterHistory adaptadorViaje;

    public ViajesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_viajes, container, false);

        recyclerViewViaje = (RecyclerView) vista.findViewById(R.id.trips_recycler);
        recyclerViewViaje.setLayoutManager(new LinearLayoutManager(getContext()));

        adaptadorViaje = new ViajesAdapterHistory(listaViajes());
        recyclerViewViaje.setAdapter(adaptadorViaje);


        return vista;
    }

    public List<ViajeModelo> listaViajes(){
        List<ViajeModelo> viajes = new ArrayList<>();
        viajes.add(new ViajeModelo("Brian", "09:10", "Nuevo viaje de mi casa a la u", "Av.Izaguirre", "UPC San Miguel", "20", "10", R.drawable.ricardo));
        viajes.add(new ViajeModelo("Sebastian", "22:10", "Mensaje de prueba", "Carabayllo", "UPC San Monterrioc", "20", "10", R.drawable.queso));
        viajes.add(new ViajeModelo("Emilio", "21:10", "Muchachos estare realizando un viaje por toda Universitaria", "Puente Piedra", "UPC San Isidro", "20", "10", R.drawable.calamardo));
        viajes.add(new ViajeModelo("Brian", "09:10", "Nuevo viaje para probar", "Comas", "UPC San Miguel", "20", "10", R.drawable.ricardo));
        return viajes;
    }

}
