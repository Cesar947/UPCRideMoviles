package com.example.upcridekotlin.activities.loginyregistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.upcridekotlin.R
import com.example.upcridekotlin.activities.mActivity

class Bienvenido : AppCompatActivity() {


    var btnRegistrarme : Button? = null
    var btnIniciar : Button? = null

    val PREFS_FILENAME = "cuenta"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)


        var prefs = getSharedPreferences(PREFS_FILENAME, 0)

        var idUser = prefs.getInt("idUser",0)
        var rol = prefs.getString("rol","P")!!.single()

        //Toast.makeText(this,prefs.toString(),Toast.LENGTH_LONG).show()

        if(idUser!= 0)
        {
            val intent = Intent(this, mActivity::class.java)

            var miBundle  = Bundle();
            miBundle.putInt("id", idUser)
            miBundle.putChar("rol",rol)
            intent.putExtras(miBundle)

            startActivity(intent)
        }


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



    fun validarInicioSesion()
    {

    }


}
