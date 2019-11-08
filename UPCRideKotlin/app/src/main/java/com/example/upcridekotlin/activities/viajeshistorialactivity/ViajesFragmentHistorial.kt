package com.example.upcridekotlin.activities.viajeshistorialactivity

import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.ViajeApiService
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
class ViajesFragmentHistorial : Fragment() {

    private var recyclerViewViaje: RecyclerView? = null
    private var adaptadorViaje: ViajesAdapterHistory? = null

    lateinit var ViajeService : ViajeApiService

    var idUsuario = 0
    var rol = 'P'

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_viajes_historial, container, false)


        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        ViajeService = retrofit.create(ViajeApiService::class.java)

         idUsuario = arguments!!.getInt("id",0)
         rol = arguments!!.getChar("rol",'P')

        recyclerViewViaje = vista.findViewById(R.id.trips_recycler)
        recyclerViewViaje!!.layoutManager = LinearLayoutManager(context)

        var viajes = listaViajes()

        listaViajes();







        return vista
    }




    fun listaViajes() {

        val viajes = ArrayList<ViajeModelo>()

        ViajeService.getViajesPorConductor(idUsuario).enqueue(object: Callback<List<Viaje>> {
            override fun onResponse(call: Call<List<Viaje>>, response: Response<List<Viaje>>) {
                val viajesaux = response.body()

                Log.i("yo pe", Gson().toJson(viajesaux))

                for( item in viajesaux!!)
                {
                    viajes.add( ViajeModelo(item.id,
                        item.conductor!!.nombres!! ,
                        item.fecha!!,
                        item.descripcion!!,
                        item.puntoPartida!!,
                        item.puntoDestino!!,
                        "10",
                        10,
                        R.drawable.user))
                }

                adaptadorViaje =
                    ViajesAdapterHistory(viajes)
                recyclerViewViaje!!.adapter = adaptadorViaje

            }
            override fun onFailure(call: Call<List<Viaje>>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })

    }

}// Required empty public constructor
