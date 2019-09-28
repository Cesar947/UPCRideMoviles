package com.example.upcridekotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
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
import java.sql.Date
import java.sql.Time


class publicar_viaje : AppCompatActivity() {

    val TAG_LOGS = "Bryan Miramira"


    lateinit var viajeService: ViajeApiService

    private lateinit var btnPublicar: Button

    private lateinit var etHoraPartida: EditText
    private lateinit var etHoraLlegada: EditText
    private lateinit var etPrecioBase: EditText
    private lateinit var etPuntoDestino: EditText
    private lateinit var etPuntoPartida: EditText
    private lateinit var etMensaje: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publicar_viaje)


        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://upcride.jl.serv.net.mx/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        viajeService = retrofit.create<ViajeApiService>(ViajeApiService::class.java)


        btnPublicar = findViewById(R.id.btnPublicar)

        


        btnPublicar.setOnClickListener {

            PublicarViaje()
        }


    }


    fun PublicarViaje() {


        etHoraPartida = findViewById<EditText>(R.id.etHoraPartida)
        etHoraLlegada = findViewById<EditText>(R.id.etHoraLlegada)
        etPrecioBase = findViewById<EditText>(R.id.etPrecioBase)
        etPuntoDestino = findViewById<EditText>(R.id.etPuntoDestino)
        etPuntoPartida = findViewById<EditText>(R.id.etPuntoPartida)
        etMensaje = findViewById<EditText>(R.id.etMensaje)



        var conductor: Usuario = Usuario("u2017", "a", "x", "a", "b","a" ,123.0, 123.0,
            "s", "a", "a", 'c', "asd", "SM")

        var viaje: Viaje? = Viaje( conductor,"descrpcion","lima","limades",
            12.0,24.0,25.0,50.0,Time(19,0,0),Time(19,0,0),1,
            Date(2019,9,28),"Lunes","Feliz",1,4,3,5.00)

        Log.i(TAG_LOGS, Gson().toJson(viaje))

        viajeService.publicarViaje(viaje).enqueue(object : Callback<Viaje> {
            override fun onResponse(call: Call<Viaje>?, response: Response<Viaje>?) {
                viaje = response?.body()
                Log.i(TAG_LOGS, Gson().toJson(viaje))


            }

            override fun onFailure(call: Call<Viaje>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }



}
