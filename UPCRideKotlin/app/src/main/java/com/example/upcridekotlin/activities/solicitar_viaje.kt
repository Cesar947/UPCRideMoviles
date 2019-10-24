package com.example.upcridekotlin.activities

import android.app.Fragment
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.upcridekotlin.R

class solicitar_viaje : AppCompatActivity(), MapsFragment.OnFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitar_viaje)


       supportFragmentManager.beginTransaction().replace(R.id.contenedor, MapsFragment()).commit()

    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
