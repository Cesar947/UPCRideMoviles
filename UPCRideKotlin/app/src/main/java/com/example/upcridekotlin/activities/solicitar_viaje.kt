package com.example.upcridekotlin.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView

import com.example.upcridekotlin.R
import com.example.upcridekotlin.model.Usuario
import com.example.upcridekotlin.model.Viaje
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_publicar_viaje.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime

class solicitar_viaje : AppCompatActivity(), MapsFragment.OnFragmentInteractionListener {

    lateinit var tvConductorSol: TextView
    lateinit var tvPuntoPartidaSol: TextView
    lateinit var tvPuntoDestinoSol: TextView
    lateinit var etMensajeSol: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitar_viaje)


        tvConductorSol = findViewById(R.id.tvConductorTextoSol) as TextView
        tvPuntoPartidaSol = findViewById(R.id.tvPartidaTextoSol) as TextView
        tvPuntoDestinoSol = findViewById(R.id.tvDestinoTextoSol) as TextView
        etMensajeSol = findViewById(R.id.etMensaje) as EditText

        var miBundle = this.intent.extras
        var id = miBundle!!.getInt("id")

       supportFragmentManager.beginTransaction().replace(R.id.contenedor, MapsFragment()).commit()

    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /*fun PublicarViaje() {

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


        var viaje: Viaje? = Viaje( null ,etMensaje.text.toString(),etPuntoPartida.text.toString(),etPuntoDestino.text.toString(), 12.0,24.0,25.0,50.0, etHoraPartida.text.toString() ,
            etHoraLlegada.text.toString(),1, fecha,"Lunes","Feliz",
            1,4,3,etPrecioBase.text.toString().toDouble())

        Log.i(TAG_LOGS, Gson().toJson(viaje))

        viajeService.publicarViaje(id,viaje).enqueue(object : Callback<Viaje> {
            override fun onResponse(call: Call<Viaje>?, response: Response<Viaje>?) {
                viaje = response?.body()

                Log.i(TAG_LOGS, Gson().toJson(viaje))
                Log.i(TAG_LOGS, Gson().toJson(conductor!!.id))
                Log.i(TAG_LOGS, Gson().toJson("funciona"))

            }
            override fun onFailure(call: Call<Viaje>?, t: Throwable?) {
                t?.printStackTrace()
                Log.i(TAG_LOGS, Gson().toJson("no funciona"))
            } })

    }*/
}
