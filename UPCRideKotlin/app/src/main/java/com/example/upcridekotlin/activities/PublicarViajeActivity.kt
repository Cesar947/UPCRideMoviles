package com.example.upcridekotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.EditText
import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.UsuarioApiService
import com.example.upcridekotlin.interfaces.ViajeApiService
import com.example.upcridekotlin.model.Usuario
import com.example.upcridekotlin.model.Viaje
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.Date
import java.sql.Time


class PublicarViajeActivity : AppCompatActivity() {


    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap
    private var retrofit: Retrofit? = null
    private var viajeApiService: ViajeApiService? = null
    private var apiService: UsuarioApiService? = null
    private var conductor: Usuario? = null
    private var etMensaje : EditText? = null
    private var etPuntoPartida: EditText? = null
    private var etPuntoDestino: EditText? = null
    private var etHoraPartida: EditText? = null
    private var etHoraLlegada: EditText? = null
    private var etPrecioBase : EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publicar_viaje)

        retrofit = Retrofit.Builder()
            .baseUrl("http://upcride.jl.serv.net.mx/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        viajeApiService = retrofit!!.create(ViajeApiService::class.java)
        apiService = retrofit!!.create(UsuarioApiService::class.java)
        etMensaje = findViewById(R.id.etMensaje) as EditText
        etPuntoPartida = findViewById(R.id.etPuntoPartida) as EditText
        etPuntoDestino = findViewById(R.id.etPuntoDestino) as EditText
        etHoraPartida = findViewById(R.id.etHoraPartida) as EditText
        etHoraLlegada = findViewById(R.id.etHoraLlegada) as EditText
        etPrecioBase = findViewById(R.id.etPrecioBase) as EditText

        mapFragment = supportFragmentManager.findFragmentById(R.id.publicacionMap) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
              googleMap = it

            val location1 = LatLng(-12.0145055, -77.0874391)
            googleMap.isMyLocationEnabled = true
            googleMap.addMarker(MarkerOptions().position(location1).title("My Location"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 10f))
        })
    }
   fun getUsuarioById(id: Int){

        var usuario: Usuario?
        apiService?.getUsuarioById(id)?.enqueue(object: Callback<Usuario>{
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                usuario = response?.body()
                conductor = usuario
            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })

    }

    fun publicarViaje() {


        var viaje: Viaje? = Viaje(conductor, etMensaje?.text.toString(), etPuntoPartida?.text.toString(),
            etPuntoDestino?.text.toString(), -12.1243231, -77.1234567,-12.1243231, -78.1234567, Time(170000),
           Time(190000), 1, Date(2019/9/30), "lunes", "publicado", 1, 0, 4, 6.5)

        var idx = conductor!!.id
        viajeApiService?.publicarViaje(idx, viaje)?.enqueue(object : Callback<Viaje> {
            override fun onFailure(call: Call<Viaje>, t: Throwable) {

            }

            override fun onResponse(call: Call<Viaje>, response: Response<Viaje>) {
                viaje = response.body()

            }

        })
    }



}
