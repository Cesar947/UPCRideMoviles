package com.example.upcridekotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.upcridekotlin.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PublicarViajeActivity : AppCompatActivity() {


    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publicar_viaje)


        mapFragment = supportFragmentManager.findFragmentById(R.id.publicacionMap) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
              googleMap = it

            val location1 = LatLng(-12.0145055, -77.0874391)
            googleMap.isMyLocationEnabled = true
            googleMap.addMarker(MarkerOptions().position(location1).title("My Location"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 10f))
        })
    }
}
