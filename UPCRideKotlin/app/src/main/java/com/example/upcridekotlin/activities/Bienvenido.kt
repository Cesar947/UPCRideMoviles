package com.example.upcridekotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.upcridekotlin.R

class Bienvenido : AppCompatActivity() {

    val TAG_LOGS = "Bryan Miramira"
    var btnRegistrarme : Button? = null
    var btnIniciar : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)


        btnRegistrarme = findViewById(R.id.btnRegistrarme)
        btnIniciar = findViewById(R.id.btnIniciarSesion)

        btnRegistrarme!!.setOnClickListener {
            val intent = Intent(this, registro_conductor::class.java)
            startActivity(intent)
        }

       btnIniciar!!.setOnClickListener {
           val intent = Intent(this, mActivity::class.java)
           Log.i(TAG_LOGS,"GAAAAAAAAAA")
           startActivity(intent)
        }
    }
}
