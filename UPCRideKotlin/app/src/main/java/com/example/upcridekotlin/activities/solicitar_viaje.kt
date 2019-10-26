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
    lateinit var viajeApiService: ViajeApiService

    var solicitud : Solicitud?= null

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

        viajeApiService = retrofit.create(ViajeApiService::class.java)


        var miBundle = this.intent.extras
        var id = miBundle!!.getInt("idViaje")

        Toast.makeText(this,miBundle.toString(),Toast.LENGTH_LONG).show()

       // viajeApiService.solicitarViaje(id,)



        //var miBundle = this.intent.extras
        // var id = miBundle!!.getInt("id")

        var fragmento = MapsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.contenedor, fragmento).commit()








        //Obtener fechas para adjuntarlas a la solicitud (fecha actual)
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



    }
}









