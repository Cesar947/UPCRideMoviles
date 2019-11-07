package com.example.upcridekotlin.activities


import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.SolicitudApiService
import com.example.upcridekotlin.interfaces.ViajeApiService
import com.example.upcridekotlin.model.Solicitud
import com.example.upcridekotlin.model.SolicitudModelo
import kotlinx.android.synthetic.main.item_viaje_historial.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class SolicitudesFragment : Fragment() {

    private var recyclerViewSolicitud: RecyclerView? = null
    private var adaptadorSolicitudes: AdaptadorSolicitudes? = null
    private var solicitudService: SolicitudApiService? = null
    private var conductorId: Int? = 0



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
        solicitudes.add(
            SolicitudModelo(
                "Burga",
                "09:10",
                "Baja en 3 calles",
                R.drawable.user
            )
        )
        solicitudes.add(
            SolicitudModelo(
                "Semanche",
                "22:10",
                "Porfa tengo un bautizo",
                R.drawable.user
            )
        )
        solicitudes.add(
            SolicitudModelo(
                "Emilio",
                "21:10",
                "Muchachos me canse",
                R.drawable.user
            )
        )
        solicitudes.add(
            SolicitudModelo(
                "Elba",
                "09:10",
                "Tu, yo  y un codelab, piensalo",
                R.drawable.user
            )
        )
        return solicitudes
    }

}// Required empty public constructor
