package com.example.upcridekotlin.activities.solicitudesactivity


import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.upcridekotlin.R
import com.example.upcridekotlin.activities.homefragmentactivity.RecyclerViewAdaptador
import com.example.upcridekotlin.activities.viajeshistorialactivity.ViajesAdapterHistory
import com.example.upcridekotlin.interfaces.SolicitudApiService
import com.example.upcridekotlin.interfaces.ViajeApiService
import com.example.upcridekotlin.model.Solicitud
import com.example.upcridekotlin.model.SolicitudModelo
import com.example.upcridekotlin.model.Viaje
import com.example.upcridekotlin.model.ViajeModelo
import com.google.gson.Gson
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

    var idUsuario = 0
    var rol = 'P'
    lateinit var ViajeService : ViajeApiService


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_solicitudes, container, false)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        ViajeService = retrofit.create(ViajeApiService::class.java)

        idUsuario = arguments!!.getInt("id",0)
        rol = arguments!!.getChar("rol",'P')

        recyclerViewSolicitud = vista.findViewById(R.id.recycle_solis)
        recyclerViewSolicitud!!.layoutManager = LinearLayoutManager(context)

        obtenerSolicitudes()




        return vista
    }


    fun obtenerSolicitudes()
    {
        val solicitudes = ArrayList<SolicitudModelo>()


        ViajeService.getViajesPorConductor(idUsuario).enqueue(object: Callback<List<Viaje>> {
            override fun onResponse(call: Call<List<Viaje>>, response: Response<List<Viaje>>) {
                val viajesaux = response.body()

                Log.i("viajesaux", Gson().toJson(viajesaux))

                /*for( item in viajesaux!!)
                {*/
                    //Log.i("item", Gson().toJson(item))

                    ViajeService.getSolicitudesPendientes(4).enqueue(object: Callback<List<Solicitud>> {
                        override fun onResponse(call: Call<List<Solicitud>>, response: Response<List<Solicitud>>) {
                            val solicitudesaux = response.body()

                            Log.i("solicitudes", Gson().toJson(solicitudesaux))

                            for(item in solicitudesaux!!)
                            {
                                solicitudes.add(
                                    SolicitudModelo(
                                        item.pasajero!!.nombres!!,
                                        item.fecha!!,
                                        item.mensaje!!,
                                        R.drawable.user))
                                Log.i("items", Gson().toJson(solicitudes))
                            }
                            adaptadorSolicitudes = AdaptadorSolicitudes(solicitudes)
                            recyclerViewSolicitud!!.adapter = adaptadorSolicitudes
                        }
                        override fun onFailure(call: Call<List<Solicitud>>?, t: Throwable?) {
                            t?.printStackTrace()
                        }
                    })

                //}

            }
            override fun onFailure(call: Call<List<Viaje>>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })





    }



}// Required empty public constructor
