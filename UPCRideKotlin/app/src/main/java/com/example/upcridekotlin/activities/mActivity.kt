package com.example.upcridekotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.widget.*


import com.example.upcridekotlin.R

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class mActivity : AppCompatActivity() {

    private var filtrando: Int? = 0

    private var toolbar: Toolbar? = null
    private var txttoolbar: TextView? = null

    private var mainNav: BottomNavigationView? = null

    private var mainFrame: FrameLayout? = null
    private var homeFragment: HomeFragment? = null
    private var viajesFragment: ViajesFragment? = null
    private var solicitudesFragment: SolicitudesFragment? = null
    private var perfilFragment: PerfilFragment? = null
    private var filtrarFragment: FiltrarFragment?= null

    private var filtrarBtn: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        filtrando = 0

        txttoolbar = findViewById(R.id.toolbartxt)
        homeFragment = HomeFragment()
        filtrarFragment = FiltrarFragment()
        viajesFragment = ViajesFragment()
        solicitudesFragment = SolicitudesFragment()
        perfilFragment = PerfilFragment()
        mainNav = findViewById(R.id.main_nav)
        filtrarBtn = findViewById(R.id.filtrarBtn)

        var miBundle = this.intent.extras
        var id = miBundle!!.getInt("id")
        var rol = miBundle!!.getChar("rol")
        homeFragment!!.arguments = miBundle
        perfilFragment!!.arguments = miBundle


        //Toast.makeText(this,id.toString(), Toast.LENGTH_LONG).show();
        //Log.i("AAAAAAAA", id.toString())

        supportFragmentManager.beginTransaction().replace(R.id.main_frame, homeFragment!!).commit()

        setSupportActionBar(toolbar)

        mainNav?.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment = homeFragment!!

            when (item.itemId) {
                R.id.inicio -> {
                    selectedFragment = homeFragment!!
                    txttoolbar?.text = "Inicio"
                }
                R.id.perfil -> {
                    selectedFragment = perfilFragment!!
                    txttoolbar?.text = "Perfil"
                }
                R.id.solis -> {
                    txttoolbar?.text = "Solicitudes"
                    selectedFragment = solicitudesFragment!!
                }
                R.id.viajes -> {
                    txttoolbar?.text = "Viajes"
                    selectedFragment = viajesFragment!!
                }
            }

            supportFragmentManager.beginTransaction().replace(R.id.main_frame, selectedFragment)
                .commit()

            true
        }

        filtrarBtn!!.setOnClickListener {

            if(filtrando == 0) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.filtrar_frame, filtrarFragment!!)
                    .commit()
                filtrando = 1
            }
            else{
                filtrando = 0
            }
        }


    }


}
