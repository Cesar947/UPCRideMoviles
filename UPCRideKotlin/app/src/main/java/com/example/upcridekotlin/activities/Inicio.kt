package com.example.upcridekotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.upcridekotlin.R

class Inicio : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


        var btnIrPublicar = findViewById<View>(R.id.btnIrPublicar) as Button

        btnIrPublicar.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PublicarViajeActivity::class.java)
            startActivity(intent)
        })

    }
}
