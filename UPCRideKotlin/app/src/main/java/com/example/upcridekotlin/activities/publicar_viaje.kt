package com.example.upcridekotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.UsuarioApiService
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
import java.time.LocalDate
import java.time.LocalDateTime


class publicar_viaje : AppCompatActivity() {

    val TAG_LOGS = "Bryan Miramira"


    lateinit var viajeService: ViajeApiService
    lateinit var userService: UsuarioApiService

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
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userService = retrofit.create<UsuarioApiService>(UsuarioApiService::class.java)
        viajeService = retrofit.create<ViajeApiService>(ViajeApiService::class.java)


        etHoraPartida = findViewById<EditText>(R.id.etHoraPartida)
        etHoraLlegada = findViewById<EditText>(R.id.etHoraLlegada)
        etPrecioBase = findViewById<EditText>(R.id.etPrecioBase)
        etPuntoDestino = findViewById<EditText>(R.id.etPuntoDestino)
        etPuntoPartida = findViewById<EditText>(R.id.etPuntoPartida)
        etMensaje = findViewById<EditText>(R.id.etMensaje)

        etHoraPartida.setText("12:00:00")
        etHoraLlegada.setText("12:00:00")


        btnPublicar = findViewById(R.id.btnPublicar)



        btnPublicar = findViewById(R.id.btnPublicar)

        btnPublicar.setOnClickListener {

            PublicarViaje()
        }


    }


    fun PublicarViaje() {





        var conductor : Usuario? = null


        var dia: String = LocalDateTime.now().dayOfMonth.toString();
        var mes: String = LocalDateTime.now().monthValue.toString();
        var año: String = LocalDateTime.now().year.toString();
        var fecha :String
        if(LocalDateTime.now().monthValue<10)
        {
            fecha = año+"-0"+mes+"-"+dia
        }
        else
        {
            fecha = año+"-"+mes+"-"+dia
        }

        Log.i(TAG_LOGS, Gson().toJson(mes))


        userService.getUsuarioById(2).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                conductor = response?.body()
                Log.i(TAG_LOGS, Gson().toJson(conductor))


                var viaje: Viaje? = Viaje( null ,etMensaje.text.toString(),etPuntoPartida.text.toString(),etPuntoDestino.text.toString(),
                    12.0,24.0,25.0,50.0, etHoraPartida.text.toString() ,
                    etHoraLlegada.text.toString(),1, fecha,"Lunes","Feliz",
                    1,4,3,etPrecioBase.text.toString().toDouble())

                Log.i(TAG_LOGS, Gson().toJson(viaje))

                viajeService.publicarViaje(3,viaje).enqueue(object : Callback<Viaje> {
                    override fun onResponse(call: Call<Viaje>?, response: Response<Viaje>?) {
                        viaje = response?.body()
                        Log.i(TAG_LOGS, Gson().toJson(viaje))
                        Log.i(TAG_LOGS, Gson().toJson(conductor!!.id))

                        Log.i(TAG_LOGS, Gson().toJson("funciona"))

                    }
                    override fun onFailure(call: Call<Viaje>?, t: Throwable?) {
                        t?.printStackTrace()
                        Log.i(TAG_LOGS, Gson().toJson("no funciona"))
                    }
                })



            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })











    }



}
