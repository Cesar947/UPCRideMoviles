package com.example.upcride.activities

import androidx.appcompat.app.AppCompatActivity


import android.location.Location
import android.os.Bundle

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

import com.example.upcride.R
import com.example.upcride.interfaces.UsuarioPlaceHolderApi
import com.example.upcride.model.Usuario


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegistroGeneral : AppCompatActivity() {


    private var retrofit: Retrofit? = null
    private var usuarioPlaceHolderApi: UsuarioPlaceHolderApi? = null
    private var etEmail: EditText? = null
    private var etContraseña: EditText?=null
    private var etNombres: EditText?=null
    private var etApellidos: EditText?=null
    private var etTelefono: EditText?=null
    private var etDistrito: EditText?=null
    private var etDNI: EditText?=null
    private var spSede: Spinner?=null
    private var sede = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_general)
        val locator: Location


        retrofit = Retrofit.Builder()
                .baseUrl("http://upcride.jl.serv.net.mx/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        usuarioPlaceHolderApi = retrofit!!.create(UsuarioPlaceHolderApi::class.java)
        etEmail = findViewById<View>(R.id.etEmail) as EditText
        etContraseña = findViewById<View>(R.id.etContraseña) as EditText
        etNombres = findViewById<View>(R.id.etNombres) as EditText
        etApellidos = findViewById<View>(R.id.etApellidos) as EditText
        etTelefono = findViewById<View>(R.id.etTelefono) as EditText
        etDistrito = findViewById<View>(R.id.etDistrito) as EditText
        etDNI = findViewById<View>(R.id.etDNI) as EditText
        spSede = findViewById<View>(R.id.spSede) as Spinner

        val adapter = ArrayAdapter.createFromResource(this,
                R.array.sedes, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spSede.adapter = adapter

        spSede.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                sede = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


    }

    private fun RegistrarPasajero(view: View) {

        if (etEmail?.text.toString().isEmpty() ||
                etContraseña?.text.toString().isEmpty() ||
                etNombres?.text.toString().isEmpty() ||
                etApellidos?.text.toString().isEmpty() ||
                etTelefono?.text.toString().isEmpty() ||
                etDistrito?.text.toString().isEmpty() ||
                etDNI?.text.toString().isEmpty()) {
            Toast.makeText(applicationContext, "Debe llenar todos los campos", Toast.LENGTH_LONG).show()
        } else {
            val pasajero = Usuario(
                    etEmail?.text.toString().substring(0, 9),
                    etEmail?.text.toString(),
                    etContraseña?.text.toString(),
                    etNombres?.text.toString(),
                    etApellidos?.text.toString(),
                    -11.1345235, -77.1213432,
                    etTelefono?.text.toString(),
                    etDistrito?.text.toString(),
                    'P',
                    sede,
                    Integer.parseInt(etDNI?.text.toString())
            )

            val call = usuarioPlaceHolderApi!!.registrarPasajero(pasajero)

            call.enqueue(object : Callback<Usuario> {
                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    if (!response.isSuccessful) {
                        Toast.makeText(applicationContext, "No funciono :c", Toast.LENGTH_LONG).show()
                    }

                    Toast.makeText(applicationContext, "Funciono", Toast.LENGTH_LONG).show()
                    /*  Usuario pasajeroResponse = response.body();
                String content = "";
                content += "correoUPC: " + pasajeroResponse.getCorreoUPC() + "\n";
                content += "codigo: " + pasajeroResponse.getCodigo() + "\n";
                content += "contraseña: " + pasajeroResponse.getContraseña() + "\n";
                content += "nombres: " + pasajeroResponse.getNombres() + "\n";
                content += "apellidos: " + pasajeroResponse.getApellidos() + "\n";
                content += "distrito: " + pasajeroResponse.getDistrito() + "\n";
                content += "telefono: " + pasajeroResponse.getTelefono() + "\n";
                content += "sede: " + pasajeroResponse.getSede() + "\n";
                content += "rol" + pasajeroResponse.getRol() + "\n";*/


                }

                override fun onFailure(call: Call<Usuario>, t: Throwable) {

                }
            })
        }
    }

}
