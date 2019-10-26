package com.example.upcridekotlin.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.UsuarioApiService
import com.example.upcridekotlin.interfaces.ViajeApiService
import com.example.upcridekotlin.model.Solicitud
import com.example.upcridekotlin.model.Usuario
import com.example.upcridekotlin.model.Viaje
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_publicar_viaje.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime

class solicitar_viaje : AppCompatActivity(), MapsFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var tvConductorSol: TextView
    lateinit var tvPuntoPartidaSol: TextView
    lateinit var tvPuntoDestinoSol: TextView
    lateinit var etMensajeSol: EditText
    lateinit var viajeService: ViajeApiService
    lateinit var usuarioService: UsuarioApiService
    var pasajero: Usuario? = null
    var solicitud: Solicitud? = null

    var viajeId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitar_viaje)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        tvConductorSol = findViewById(R.id.tvConductorTextoSol) as TextView
        tvPuntoPartidaSol = findViewById(R.id.tvPartidaTextoSol) as TextView
        tvPuntoDestinoSol = findViewById(R.id.tvDestinoTextoSol) as TextView
        etMensajeSol = findViewById(R.id.etMensaje) as EditText

        viajeService = retrofit.create<ViajeApiService>(ViajeApiService::class.java)


        //var miBundle = this.intent.extras
        // var id = miBundle!!.getInt("id")

        var fragmento: MapsFragment = MapsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.contenedor, fragmento).commit()

        var miBundle = this.intent.extras
        var id = miBundle!!.getInt("id")
        viajeId = id

        // obtenerUsuarioPorId(1)


        usuarioService = retrofit.create(UsuarioApiService::class.java)

        var dia: String = LocalDateTime.now().dayOfMonth.toString();
        var mes: String = LocalDateTime.now().monthValue.toString();
        var año: String = LocalDateTime.now().year.toString();

        var fecha: String

        if (LocalDateTime.now().monthValue < 10) {
            fecha = año + "-0" + mes + "-" + dia
        } else {
            fecha = año + "-" + mes + "-" + dia
        }
        val TAG_LOGS = "Juanelv"

        lateinit var viaje: Viaje

        viajeService.getViajeById(id).enqueue(object : Callback<Viaje> {
            override fun onFailure(call: Call<Viaje>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Viaje>?, response: Response<Viaje>?) {
                viaje = response?.body()!!

                Log.i(TAG_LOGS, Gson().toJson("funciona el viaje "))
                tvConductorSol.text = viaje.conductor?.nombres.toString()
                tvPuntoPartidaSol.text = viaje.puntoPartida.toString()
                tvPuntoDestinoSol.text = viaje.puntoDestino.toString()


                /*var solicitud: Solicitud? = Solicitud( pasajero ,
        null,
        etMensajeSol.text.toString(),
        "Pendiente",
       "Izaguirre",
        -12.057462,
        -71.223312,
        fecha: Date?)
>>>>>>> 78fb2ea2b877dc1e1c645e2b35d831cc21b276a3


            }
            override fun onFailure(call: Call<Viaje>, t: Throwable) {
                Log.i(TAG_LOGS, Gson().toJson("no funciona el viaje "))
            } })

        viajeService.solicitarViaje(id,solicitud).enqueue(object : Callback<Solicitud> {
            override fun onResponse(call: Call<Solicitud>?, response: Response<Solicitud>?) {
                solicitud = response?.body()



                Log.i(TAG_LOGS, Gson().toJson(solicitud?.viaje?.conductor?.nombres))
                //Log.i(TAG_LOGS, Gson().toJson(conductor!!.id))
                Log.i(TAG_LOGS, Gson().toJson("funciona"))


            }
            override fun onFailure(call: Call<Solicitud>, t: Throwable) {
                t?.printStackTrace()
                Log.i(TAG_LOGS, Gson().toJson("no funciona"))
            } })*/


            }



/*
    fun obtenerUsuarioPorId(id: Int): Usuario?{


        usuarioService!!.getUsuarioById(id).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                pasajero = response!!.body()

            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })



    }



   fun solicitarViaje() {


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




        var viaje: Viaje? = Viaje( null ,etMensaje.text.toString(),etPuntoPartida.text.toString(),etPuntoDestino.text.toString(), 12.0,24.0,25.0,50.0, etHoraPartida.text.toString() ,
            etHoraLlegada.text.toString(),1, fecha,"Lunes","Feliz",
            1,4,3,etPrecioBase.text.toString().toDouble())

      /* var solicitud: Solicitud? = Solicitud(
        pasajero: Usuario?,
        viaje: Viaje?,
        mensaje: String?,
        confirmacionConductor: String?,
        puntoEncuentro: String?,
        encuentroLatitud: Double,
        encuentroLongitud: Double,
        fecha: Date?)

        viajeService.publicarViaje(id,viaje).enqueue(object : Callback<Viaje> {
            override fun onResponse(call: Call<Viaje>?, response: Response<Viaje>?) {
                viaje = response?.body()

            }
            override fun onFailure(call: Call<Viaje>?, t: Throwable?) {
                t?.printStackTrace()

            } })*/

    }*/
        })


        solicitud = Solicitud(
            pasajero,
            Viaje( null ,"hola","ah","ah", 12.0,24.0,25.0,50.0, "ah" ,
                "ah",1, "ah","Lunes","Feliz",
                1,4,3,5.0),
            etMensajeSol.text.toString(),
            "Pendiente",
            "Izaguirre",
            fragmento.getLat(),
            fragmento.getLng(),
            null
        )


    }


}







