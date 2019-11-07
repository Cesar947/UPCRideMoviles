package com.example.upcridekotlin.activities.loginyregistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.upcridekotlin.R

class elegirRegistro : AppCompatActivity() {

    var btnRegistrarme : Button? = null
    var btinRegistroPas : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elegir_registro)

        btnRegistrarme = findViewById(R.id.btnRegistrarme2)
        btinRegistroPas = findViewById(R.id.btnRegistrarPasajero2)


        btnRegistrarme?.setOnClickListener {
            val intent = Intent(this, registro_conductor::class.java)
            startActivity(intent)
        }

        btinRegistroPas?.setOnClickListener{
            val intent = Intent(this, registro_pasajero::class.java)
            startActivity(intent)
        }
    }
}
