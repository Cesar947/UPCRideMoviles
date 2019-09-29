package com.example.upcride.activities;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.upcride.R;
import com.example.upcride.model.Solicitud;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SolicitudesFragment extends Fragment {

    private RecyclerView recyclerViewSolicitud;
    private AdaptadorSolicitudes adaptadorSolicitudes;

    public SolicitudesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_solicitudes, container, false);

        recyclerViewSolicitud = (RecyclerView) vista.findViewById(R.id.recycle_solis);
        recyclerViewSolicitud.setLayoutManager(new LinearLayoutManager(getContext()));

        adaptadorSolicitudes = new AdaptadorSolicitudes(carteraSolicitudes());
        recyclerViewSolicitud.setAdapter(adaptadorSolicitudes);

        return vista;
    }

    public List<SolicitudModelo> carteraSolicitudes(){
        List<SolicitudModelo> solicitudes = new ArrayList<>();
        solicitudes.add(new SolicitudModelo("Brian", "09:10", "Solicitó un viaje", R.drawable.ricardo));
        solicitudes.add(new SolicitudModelo("Bonifacio", "22:10", "Realizó una reseña", R.drawable.queso));
        solicitudes.add(new SolicitudModelo("Emilio", "21:10", "Solicitó un viaje", R.drawable.calamardo));
        solicitudes.add(new SolicitudModelo("Juanelv", "09:10", "Solicitó un viaje", R.drawable.ricardo));
        return solicitudes;
    }

}