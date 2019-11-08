package com.example.upcridekotlin.activities.loginyregistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.upcridekotlin.R

class Bienvenido : AppCompatActivity() {


    var btnRegistrarme : Button? = null
    var btnIniciar : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)


        btnRegistrarme = findViewById(R.id.btnRegistrarme)
        btnIniciar = findViewById(R.id.btnIniciarSesion)

        btnRegistrarme?.setOnClickListener {
            val intent = Intent(this, elegirRegistro::class.java)
            startActivity(intent)
        }

       btnIniciar?.setOnClickListener {
           val intent = Intent(this, LoginActivity::class.java)

           startActivity(intent)
        }


    }
}