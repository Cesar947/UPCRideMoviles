package com.example.upcridekotlin.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

import android.os.Bundle

import android.widget.FrameLayout
import android.widget.TextView


import com.example.upcridekotlin.R
import com.example.upcridekotlin.activities.HomeFragment
import com.example.upcridekotlin.activities.PerfilFragment
import com.example.upcridekotlin.activities.SolicitudesFragment
import com.example.upcridekotlin.activities.ViajesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class mActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    private var txttoolbar: TextView? = null

    private var mainNav: BottomNavigationView? = null

    private var mainFrame: FrameLayout? = null

    private var homeFragment: HomeFragment? = null
    private var viajesFragment: ViajesFragment? = null
    private var solicitudesFragment: SolicitudesFragment? = null
    private var perfilFragment: PerfilFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        homeFragment = HomeFragment()
        viajesFragment = ViajesFragment()
        solicitudesFragment = SolicitudesFragment()
        perfilFragment = PerfilFragment()

        supportFragmentManager.beginTransaction().replace(R.id.main_frame, HomeFragment()).commit()

        setSupportActionBar(toolbar)

        mainNav!!.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.inicio -> {
                    selectedFragment = HomeFragment()
                    txttoolbar!!.text = "Inicio"
                }
                R.id.perfil -> {
                    selectedFragment = PerfilFragment()
                    txttoolbar!!.text = "Perfil"
                }
                R.id.solis -> {
                    txttoolbar!!.text = "Solicitudes"
                    selectedFragment = SolicitudesFragment()
                }
                R.id.viajes -> {
                    txttoolbar!!.text = "Viajes"
                    selectedFragment = ViajesFragment()
                }
            }

            supportFragmentManager.beginTransaction().replace(R.id.main_frame, selectedFragment!!)
                .commit()

            true
        }


    }


}
