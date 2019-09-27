package com.example.upcridekotlin.activities

import android.content.Intent
import android.os.Bundle

import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.UsuarioApiService
import com.example.upcridekotlin.model.Usuario
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {



    lateinit var apiService: UsuarioApiService

    private lateinit var  text : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://upcride.jl.serv.net.mx/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create<UsuarioApiService>(UsuarioApiService::class.java)



        getAllUsers()


        var btnIrInicio = findViewById<View>(R.id.btnIrInicio) as Button

        btnIrInicio.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        })





    }

    fun getAllUsers(){

        var user: String="";
        apiService.getAllUsers().enqueue(object: Callback<List<Usuario>>{
            override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
                val usuarios = response.body()

                for (p2 in usuarios.orEmpty()) { user += p2.codigo }
                text.setText(user)

            }
            override fun onFailure(call: Call<List<Usuario>>?, t: Throwable?) {
                t?.printStackTrace()
                Toast.makeText(applicationContext,"fallo",Toast.LENGTH_LONG)
            }
        })



    }


    fun AgregarPasajero() {
        var pasajero: Usuario? = Usuario("a", "a", "x", "a", "b", 123.0, 123.0,
            "s", "a", "a", 'c', "asd", "SM")

        apiService.insertarPasajero(pasajero).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                pasajero = response?.body()

            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    fun getUsuarioById(){

        var usuario: Usuario?
        apiService.getUsuarioById(1).enqueue(object: Callback<Usuario>{
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                usuario = response?.body()

            }
            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }


}
