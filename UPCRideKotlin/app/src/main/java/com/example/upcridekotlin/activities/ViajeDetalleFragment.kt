package com.example.upcridekotlin.activities


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.ViajeApiService
import com.example.upcridekotlin.model.Usuario
import com.example.upcridekotlin.model.Viaje
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass.
 */
class ViajeDetalleFragment : Fragment() {

    var idViaje = 0

    var tvNombre : TextView? = null
    var tvFecha : TextView? = null
    var tvDescripcion : TextView? = null
    var tvPuntoPartida : TextView? = null
    var tvPuntoDestino : TextView? = null
    var tvTelefono : TextView? = null
    var tvHoraPartida :TextView? = null
    var tvHoraLlegada :TextView? = null
    var tvLimitePasajeros : TextView? = null
    var tvSolicitudes : TextView? = null
    var tvReseñas : TextView? = null
    var PrecioBase : TextView? = null



    private var viajeService: ViajeApiService? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_viaje_detalle, container, false)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        viajeService = retrofit.create(ViajeApiService::class.java)

        tvNombre = vista.findViewById(R.id.solo_usuario)
        tvDescripcion = vista.findViewById(R.id.solo_descrip)
        tvFecha = vista.findViewById(R.id.solo_fecha)
        tvPuntoPartida = vista.findViewById(R.id.solo_punto_partida)
        tvPuntoDestino = vista.findViewById(R.id.solo_punto_destino)
        tvTelefono = vista.findViewById(R.id.solo_descrip)
        tvHoraLlegada = vista.findViewById(R.id.solo_descrip)
        tvHoraPartida = vista.findViewById(R.id.solo_descrip)
        tvSolicitudes = vista.findViewById(R.id.solo_n_solis)
        tvReseñas = vista.findViewById(R.id.solo_n_resenias)


        idViaje = arguments!!.getInt("idViaje",0)


        Toast.makeText(activity,id.toString(),Toast.LENGTH_LONG).show()

        mostrarViaje()


        return vista;
    }


    fun mostrarViaje()
    {

        viajeService!!.getViajeById(idViaje).enqueue(object : Callback<Viaje> {
            override fun onResponse(call: Call<Viaje>?, response: Response<Viaje>?) {
                val viaje = response?.body()
                Log.i("AAAAAAA", Gson().toJson(viaje))

                tvNombre!!.setText(viaje!!.conductor!!.nombres+ " " + viaje!!.conductor!!.apellidos)
                tvDescripcion!!.setText(viaje!!.descripcion)
                tvFecha!!.setText(viaje!!.fecha)
                tvPuntoDestino!!.setText(viaje!!.puntoDestino)
                tvPuntoPartida!!.setText(viaje!!.puntoPartida)
                tvReseñas!!.setText("20")
                tvSolicitudes!!.setText("20")


            }

            override fun onFailure(call: Call<Viaje>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })

    }







}
