package com.example.upcridekotlin.activities


import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.ViajeApiService
import com.example.upcridekotlin.model.Viaje
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private var recyclerViewViaje: RecyclerView? = null
    private var adaptadorViaje: RecyclerViewAdaptador? = null
    lateinit var viajeService: ViajeApiService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerViewViaje = vista.findViewById(R.id.viajes_recycler)
        recyclerViewViaje!!.layoutManager = LinearLayoutManager(context)

        adaptadorViaje = RecyclerViewAdaptador(carteraViajes())
        recyclerViewViaje!!.adapter = adaptadorViaje


        return vista


    }

    fun ObtenerViajes(){

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://upcride.jl.serv.net.mx/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        viajeService = retrofit.create<ViajeApiService>(ViajeApiService::class.java)
        viajeService.visualizarViajes().enqueue(object : Callback<List<Viaje>>{
            override fun onFailure(call: Call<List<Viaje>>, t: Throwable) {
              //
            }

            override fun onResponse(call: Call<List<Viaje>>, response: Response<List<Viaje>>) {

            }


        })



    }

    fun carteraViajes(): List<ViajeModelo> {
        val viajes = ArrayList<ViajeModelo>()

        viajes.add(
            ViajeModelo(
                "Brian",
                "09:10",
                "Nuevo viaje",
                "Av. Sucre 111",
                "UPC Villa",
                "20",
                "10",
                R.drawable.ricardo
            )
        )
        viajes.add(
            ViajeModelo(
                "Sebastian",
                "22:10",
                "Nuevo viaje",
                "Av. La Marina 344",
                "UPC Monterrico",
                "20",
                "10",
                R.drawable.queso
            )
        )
        viajes.add(
            ViajeModelo(
                "Emilio",
                "21:10",
                "Muchachos, les tengo un viaje",
                "Av. Izaguirre 999",
                "UPC San Miguel",
                "20",
                "10",
                R.drawable.calamardo
            )
        )
        viajes.add(
            ViajeModelo(
                "Brian",
                "09:10",
                "Nuevo viaje",
                "Av. Sucre 111",
                "UPC Villa",
                "20",
                "10",
                R.drawable.ricardo
            )
        )
        return viajes
    }
}// Required empty public constructor
