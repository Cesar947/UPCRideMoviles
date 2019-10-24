package com.example.upcridekotlin.activities


import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.UsuarioApiService
import com.example.upcridekotlin.interfaces.ViajeApiService
import com.example.upcridekotlin.model.Usuario
import com.google.gson.Gson
import kotlinx.android.synthetic.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass.
 */
class PerfilFragment : Fragment() {

    var lblNombrePerfil : TextView? = null
    var lblUbicación : TextView? = null


    private var usuarioService: UsuarioApiService? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_perfil, container, false)



        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        usuarioService = retrofit.create(UsuarioApiService::class.java)

        lblNombrePerfil = vista.findViewById(R.id.nombrePerfilTxt)
        lblUbicación = vista.findViewById(R.id.ubicacionPerfilTxt)

        var id = arguments!!.getInt("id",0)

        usuarioService!!.getUsuarioById(id).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                val pasajero = response?.body()
                Log.i("AAAAAAA", Gson().toJson(pasajero))

                lblNombrePerfil!!.setText(pasajero!!.nombres+ " " + pasajero.apellidos)
                lblUbicación!!.setText("Latitud: "+pasajero.ubicacionLatitud +"\nLongitud:" + pasajero.ubicacionLongitud)


            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })


        return vista
    }

}// Required empty public constructor
