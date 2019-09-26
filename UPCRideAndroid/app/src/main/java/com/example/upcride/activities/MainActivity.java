package com.example.upcride.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;


import com.example.upcride.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerViewViaje;
    private RecyclerViewAdaptador adaptadorViaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerViewViaje = (RecyclerView) findViewById(R.id.recycler_viajes);
        recyclerViewViaje.setLayoutManager(new LinearLayoutManager(this));

        setSupportActionBar(toolbar);
        adaptadorViaje = new RecyclerViewAdaptador(carteraViajes());
        recyclerViewViaje.setAdapter(adaptadorViaje);
    }


    public List<ViajeModelo> carteraViajes(){
        List<ViajeModelo> viajes = new ArrayList<>();
        viajes.add(new ViajeModelo("Brian", "09:10", "Nuevo viaje Gaaaaa", "Mi Casa", "La Mierda", "20", "10", R.drawable.ricardo));
        viajes.add(new ViajeModelo("Sebastian", "22:10", "Ahhh mi pcihulaaa", "Mi Casa", "La Bika", "20", "10", R.drawable.queso));
        viajes.add(new ViajeModelo("Emilio", "21:10", "Muchachos me canse", "Mi Casa", "Desempleo", "20", "10", R.drawable.calamardo));
        viajes.add(new ViajeModelo("Brian", "09:10", "Nuevo viaje Gaaaaa", "Mi Casa", "La Mierda", "20", "10", R.drawable.ricardo));
        return viajes;
    }


    public boolean onCreateOptionsMenu(Menu menu){
        return true;
    }
}
