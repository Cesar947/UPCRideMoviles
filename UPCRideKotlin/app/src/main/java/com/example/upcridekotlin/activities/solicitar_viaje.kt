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
import com.example.upcridekotlin.interfaces.GoogleMapsApiService
import com.example.upcridekotlin.interfaces.UsuarioApiService
import com.example.upcridekotlin.interfaces.ViajeApiService
import com.example.upcridekotlin.model.Solicitud
import com.example.upcridekotlin.model.Usuario
import com.example.upcridekotlin.model.Viaje
import com.google.android.gms.common.api.Api
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.maps.android.PolyUtil
import kotlinx.android.synthetic.main.activity_publicar_viaje.*
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

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

    lateinit var tvFechaViaje : TextView
    lateinit var tvHoraPartida : TextView
    lateinit var tvHoraLlegada : TextView
    lateinit var tvDescripcionViaje : TextView

    lateinit var ApiGoogle:GoogleMapsApiService

    var solicitud : Solicitud?= null
    var fragmento : MapsFragment?=null
    var directionsRequestUrl: String = "https://maps.googleapis.com/maps/api/directions/json?origin=-12.067311,-77.130092&destination=-12.103745,-76.963401&key=AIzaSyAkSoqQ9v3nMJ9Tv60ZSwkZcgjoNkCGBsw"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitar_viaje)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitGM: Retrofit = Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/directions/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        ApiGoogle = retrofitGM.create(GoogleMapsApiService::class.java)





        viajeApiService = retrofit.create(ViajeApiService::class.java)
        usuarioApiService = retrofit.create(UsuarioApiService::class.java)

        tvConductorSol = findViewById(R.id.tvConductorTextoSol) as TextView
        tvPuntoPartidaSol = findViewById(R.id.tvPartidaTextoSol) as TextView
        tvPuntoDestinoSol = findViewById(R.id.tvDestinoTextoSol) as TextView
        etMensajeSol = findViewById(R.id.etMensaje)
        btnSolicitarSolo = findViewById(R.id.btnSolicitarViaje)

        tvFechaViaje = findViewById(R.id.solo_fecha) as TextView
        tvHoraLlegada = findViewById(R.id.solo_hora_llegada) as TextView
        tvHoraPartida = findViewById(R.id.solo_hora_partida) as TextView
        tvDescripcionViaje = findViewById(R.id.solo_descrip) as TextView



        var miBundle = this.intent.extras
        var idViaje = miBundle!!.getInt("idViaje")
        var idPasajero = miBundle!!.getInt("idPasajero")
        var rol = miBundle!!.getChar("rol")
        //Toast.makeText(this,miBundle.toString(),Toast.LENGTH_LONG).show()


        viajeApiService.getViajeById(idViaje).enqueue(object: Callback<Viaje>{
            override fun onFailure(call: Call<Viaje>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Viaje>, response: Response<Viaje>) {
                tvConductorSol.text = response.body()?.conductor?.nombres.toString() + " " + response.body()?.conductor?.apellidos.toString()
                tvPuntoPartidaSol.text = response.body()?.puntoPartida.toString()
                tvPuntoDestinoSol.text = response.body()?.puntoDestino.toString()
                tvHoraPartida.text = response.body()?.horaPartida.toString()
                tvHoraLlegada.text = response.body()?.horaLlegada.toString()
                tvDescripcionViaje.text = response.body()?.descripcion.toString()
                tvFechaViaje.text = response.body()?.fecha.toString()

            }

        })

        fragmento = MapsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.mapita, fragmento!!).commit()



        ApiGoogle!!.getDirections("-12.067311,-77.130092","-12.103745,-76.963401","AIzaSyAkSoqQ9v3nMJ9Tv60ZSwkZcgjoNkCGBsw").enqueue(object: Callback<JsonObject> {


            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

               var jso = response.body()
                Log.i("el json ahhhhhh", response.body().toString())
               fragmento!!.trazarRuta (jso!!)
            }
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    t?.printStackTrace()
                Log.i("el json ahhhhhh", "what xuxa fue")
            }

        })


        var dia: String = LocalDateTime.now().dayOfMonth.toString();
        var mes: String = LocalDateTime.now().monthValue.toString();
        var año: String = LocalDateTime.now().year.toString();

        if(LocalDateTime.now().monthValue<10)
        {
            fecha = año+"-0"+mes+"-"+dia

            if(LocalDateTime.now().dayOfMonth<10)
            {
                fecha = año+"-0"+mes+"-"+"0"+dia
            }
        }
        else
        {
            fecha = año+"-"+mes+"-"+dia

            if(LocalDateTime.now().dayOfMonth<10)
            {
                fecha = año+"-"+mes+"-"+"0"+dia
            }
        }
        //////

        //Google Maps Direction Request
        var latOrigin = "-12.333"
        var lngOrigin = "-77.5366"
        var latDestiny = "-12.0765"
        var lngDestiny = "-77.0992"

        //////////////////////////

        //btnSolicitarSolo: Solicita un viaje
        btnSolicitarSolo.setOnClickListener {

            Solicitar(idViaje,idPasajero)
            val intent = Intent(this, mActivity::class.java)
            val bundle = Bundle()
            bundle.putInt("id",idPasajero)
            bundle.putChar("rol",rol)
            intent.putExtras(bundle)
            startActivity(intent)

        }

    }




    fun Solicitar(idViaje : Int,idPasajero: Int)
    {

        solicitud = Solicitud(null,
            null,
            etMensajeSol.text.toString(),
            "Pendiente",
            "av",
            fragmento?.getLat()!!,
            fragmento!!.getLng()!!,
            fecha )



        usuarioApiService!!.getUsuarioById(idPasajero).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {

                val pasajero = response?.body()

                solicitud!!.pasajero = pasajero

                Log.i("yo pe", Gson().toJson(solicitud))


                viajeApiService!!.solicitarViaje(idViaje,solicitud ).enqueue(object : Callback<Solicitud> {
                    override fun onResponse(call: Call<Solicitud>?, response: Response<Solicitud>?) {

                        val solicitud = response?.body()


                        Log.i("la soli", Gson().toJson(solicitud))


                    }
                    override fun onFailure(call: Call<Solicitud>?, t: Throwable?) {
                        t?.printStackTrace()

                    }
                })




            }
            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()

            }
        })


    }




}










