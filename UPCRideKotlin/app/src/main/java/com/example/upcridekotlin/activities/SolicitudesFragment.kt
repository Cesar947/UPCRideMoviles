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
class SolicitudesFragment : Fragment() {

    private var recyclerViewSolicitud: RecyclerView? = null
    private var adaptadorSolicitudes: AdaptadorSolicitudes? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_solicitudes, container, false)

        recyclerViewSolicitud = vista.findViewById(R.id.recycle_solis)
        recyclerViewSolicitud!!.layoutManager = LinearLayoutManager(context)

        adaptadorSolicitudes = AdaptadorSolicitudes(carteraSolicitudes())
        recyclerViewSolicitud!!.adapter = adaptadorSolicitudes

        return vista
    }

    fun carteraSolicitudes(): List<SolicitudModelo> {
        val solicitudes = ArrayList<SolicitudModelo>()
        solicitudes.add(SolicitudModelo("Burga", "09:10", "Yo no quiero jalar", R.drawable.ricardo))
        solicitudes.add(
            SolicitudModelo(
                "Semanche",
                "22:10",
                "Cuanto por tu caca",
                R.drawable.queso
            )
        )
        solicitudes.add(
            SolicitudModelo(
                "Emilio",
                "21:10",
                "Muchachos me canse",
                R.drawable.calamardo
            )
        )
        solicitudes.add(SolicitudModelo("Elba", "09:10", "Tu yo piensale", R.drawable.ricardo))
        return solicitudes
    }

}// Required empty public constructor
