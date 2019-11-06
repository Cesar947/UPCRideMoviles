package com.example.upcridekotlin.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
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
import java.util.*

class solicitar_viaje : AppCompatActivity(), MapsFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    var fecha: String = ""
    lateinit var tvConductorSol: TextView
    lateinit var tvPuntoPartidaSol: TextView
    lateinit var tvPuntoDestinoSol: TextView
    lateinit var etMensajeSol: EditText
    lateinit var viajeApiService: ViajeApiService
    lateinit var usuarioApiService: UsuarioApiService
    lateinit var btnSolicitarSolo : Button

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
        etMensajeSol = findViewById(R.id.etMensaje)
        btnSolicitarSolo = findViewById(R.id.btnSolicitarViaje)

        viajeApiService = retrofit.create(ViajeApiService::class.java)
        usuarioApiService = retrofit.create(UsuarioApiService::class.java)



        var miBundle = this.intent.extras
        var idViaje = miBundle!!.getInt("idViaje")
        var idPasajero = miBundle!!.getInt("idPasajero")
        var rol = miBundle!!.getChar("rol")
        Toast.makeText(this,miBundle.toString(),Toast.LENGTH_LONG).show()


        var fragmento = MapsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.contenedor, fragmento).commit()



        //Obtener fechas para adjuntarlas a la solicitud (fecha actual)
        var dia: String = LocalDateTime.now().dayOfMonth.toString();
        var mes: String = LocalDateTime.now().monthValue.toString();
        var año: String = LocalDateTime.now().year.toString();



        if (LocalDateTime.now().monthValue < 10) {
            fecha = año + "-0" + mes + "-" + dia
        } else {
            fecha = año + "-" + mes + "-" + dia
        }


        btnSolicitarSolo.setOnClickListener {
            val intent = Intent(this, mActivity::class.java)
            Solicitar(idViaje,idPasajero)
            val bundle = Bundle()
            bundle.putInt("id",idPasajero)
            bundle.putChar("rol",rol)
            intent.putExtras(bundle)
            startActivity(intent)

        }

    }




    fun Solicitar(idViaje : Int,idPasajero: Int)
    {

        solicitud = Solicitud(null,null,etMensajeSol.text.toString(),"Pendiente","av",
            12.00,12.00,fecha )

        usuarioApiService!!.getUsuarioById(idPasajero).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                val pasajero = response?.body()

                solicitud!!.pasajero = pasajero

                Log.i("yo pe", Gson().toJson(solicitud))


                viajeApiService.solicitarViaje(idViaje,solicitud).enqueue(object : Callback<Solicitud> {
                    override fun onResponse(call: Call<Solicitud>?, response: Response<Solicitud>?) {
                        var solicitud2 = response?.body()

                        Log.i("yo pe", Gson().toJson(solicitud2))


                    }
                    override fun onFailure(call: Call<Solicitud>?, t: Throwable?) {
                        t?.printStackTrace()

                    } })


            }
            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()

            }
        })


    }


}