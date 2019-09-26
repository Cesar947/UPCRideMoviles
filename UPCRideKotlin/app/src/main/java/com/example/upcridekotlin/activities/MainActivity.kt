package com.example.upcridekotlin.activities

import android.os.Bundle

import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.UsuarioService
import com.example.upcridekotlin.model.Usuario
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val TAG_LOGS = "kikopalomares"

    lateinit var service: UsuarioService

    private lateinit var  text : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://upcride.jl.serv.net.mx/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<UsuarioService>(UsuarioService::class.java)

        text = findViewById(R.id.textView) as TextView

        getAllUsers()







    }

    fun getAllUsers(){

        var user: String="";
        service.getAllUsers().enqueue(object: Callback<List<Usuario>>{
            override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
                val usuarios = response.body()

                for (p2 in usuarios.orEmpty()) { user += p2.codigo }
                text.setText(user)

                Log.i(TAG_LOGS, Gson().toJson(usuarios))
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

        service.insertarPasajero(pasajero).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                pasajero = response?.body()
                Log.i(TAG_LOGS, Gson().toJson(pasajero))
            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    fun getUsuarioById(){

        var usuario: Usuario?
        service.getUsuarioById(1).enqueue(object: Callback<Usuario>{
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                usuario = response?.body()
                Log.i(TAG_LOGS, Gson().toJson(usuario))
            }
            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }


}
