package com.example.upcridekotlin.activities

import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.upcridekotlin.R

import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class ViajesFragment : Fragment() {

    private var recyclerViewViaje: RecyclerView? = null
    private var adaptadorViaje: ViajesAdapterHistory? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_viajes, container, false)

        recyclerViewViaje = vista.findViewById(R.id.trips_recycler)
        recyclerViewViaje!!.layoutManager = LinearLayoutManager(context)

        adaptadorViaje = ViajesAdapterHistory(listaViajes())
        recyclerViewViaje!!.adapter = adaptadorViaje


        return vista
    }

    fun listaViajes(): List<ViajeModelo> {
        val viajes = ArrayList<ViajeModelo>()
        viajes.add(
            ViajeModelo(
                "Brian",
                "09:10",
                "Nuevo viaje Gaaaaa",
                "Mi Casa",
                "La Mierda",
                "20",
                "10",
                R.drawable.ricardo
            )
        )
        viajes.add(
            ViajeModelo(
                "Sebastian",
                "22:10",
                "Ahhh mi pcihulaaa",
                "Mi Casa",
                "La Bika",
                "20",
                "10",
                R.drawable.queso
            )
        )
        viajes.add(
            ViajeModelo(
                "Emilio",
                "21:10",
                "Muchachos me canse",
                "Mi Casa",
                "Desempleo",
                "20",
                "10",
                R.drawable.calamardo
            )
        )
        viajes.add(
            ViajeModelo(
                "Brian",
                "09:10",
                "Nuevo viaje Gaaaaa",
                "Mi Casa",
                "La Mierda",
                "20",
                "10",
                R.drawable.ricardo
            )
        )
        return viajes
    }

}// Required empty public constructor
