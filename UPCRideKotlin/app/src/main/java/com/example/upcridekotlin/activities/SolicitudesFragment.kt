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
    //Para guia
/*@GET("solicitudes")
    fun getAllSolicitudes(): Call<List<Auto>>*/
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


        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        solicitudService = retrofit.create(SolicitudApiService::class.java)

        conductorId = arguments!!.getInt("id", 0)
        Toast.makeText(activity,"El conductor es el número" + conductorId.toString(), Toast.LENGTH_LONG).show()

        solicitudService!!.obtenerSolicitudesPorConductor(conductorId!!).enqueue(object: Callback<List<Solicitud>>{
            override fun onResponse(call: Call<List<Solicitud>>, response: Response<List<Solicitud>>
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<List<Solicitud>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }



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
