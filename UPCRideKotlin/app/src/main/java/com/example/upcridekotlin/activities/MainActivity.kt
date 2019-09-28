package com.example.upcridekotlin.activities

import android.content.Intent
import android.os.Bundle

import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.AutoApiService
import com.example.upcridekotlin.interfaces.UsuarioApiService
import com.example.upcridekotlin.model.Auto
import com.example.upcridekotlin.model.Usuario
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val TAG_LOGS = "kikopalomares"

    lateinit var userService: UsuarioApiService

    lateinit var autoService: AutoApiService

    private lateinit var  text : TextView

    private lateinit var registrarPas :Button

    private lateinit var registrarCond :Button

    private lateinit var publicarViaje :Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://upcride.jl.serv.net.mx/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userService = retrofit.create<UsuarioApiService>(UsuarioApiService::class.java)
        autoService = retrofit.create<AutoApiService>(AutoApiService::class.java)



        registrarPas = findViewById(R.id.btnRegPas) as Button

        registrarCond = findViewById(R.id.btnRegCond) as Button

        publicarViaje = findViewById(R.id.btnPublicarViaje) as Button





        registrarCond.setOnClickListener{
            val intent = Intent(this, registro_conductor::class.java)
            startActivity(intent)
        }

        registrarPas.setOnClickListener{
            val intent = Intent(this, registro_pasajero::class.java)
            startActivity(intent)
        }

        publicarViaje.setOnClickListener{
            val intent = Intent(this, publicar_viaje::class.java)
            startActivity(intent)
        }

    }

}
