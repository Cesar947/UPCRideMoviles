package com.example.upcridekotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.UsuarioApiService
import com.example.upcridekotlin.model.Usuario
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_registro_pasajero.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class registro_pasajero : AppCompatActivity() {

    val TAG_LOGS = "Bryan Miramira"


    lateinit var userService: UsuarioApiService



    private lateinit var btnRegistrarme: Button


    private lateinit var etTelefono: EditText
    private lateinit var etDistrito: EditText
    private lateinit var etDNI: EditText
    private lateinit var etNombre: EditText
    private lateinit var etApellido: EditText
    private lateinit var etContraseña: EditText
    private lateinit var etEmail: EditText
    private lateinit var etCodigo: EditText

    private lateinit var sede:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pasajero)


        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val adapter = ArrayAdapter.createFromResource(this,

            R.array.sedes, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spSede.adapter = adapter






        userService = retrofit.create(UsuarioApiService::class.java)

        btnRegistrarme = findViewById(R.id.btnIrRegistro)


        spSede.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            )
            {
                sede = parent.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }



        btnRegistrarme.setOnClickListener {
            AgregarPasajero()
            val intent = Intent(this,Bienvenido::class.java)
            startActivity(intent)

        }


    }


    fun AgregarPasajero() {


        etTelefono = findViewById(R.id.etTelefono)
        etDistrito = findViewById(R.id.etDistrito)
        etDNI = findViewById(R.id.etDNI)
        etNombre = findViewById(R.id.etNombres)
        etApellido = findViewById(R.id.etApellidos)
        etContraseña = findViewById(R.id.etContraseñaLogin)
        etEmail = findViewById(R.id.etEmail)
        etCodigo = findViewById(R.id.etCodigo)




        var pasajero: Usuario? = Usuario(
            etCodigo.text.toString(),
            etEmail.text.toString(),
            etContraseña.text.toString(),
            etDNI.text.toString(),
            etNombre.text.toString(),
            etApellido.text.toString(),
            0.0,
            0.0,
            etTelefono.text.toString(),
            etDistrito.text.toString(), 
            'P', sede)

        Log.i(TAG_LOGS, Gson().toJson(pasajero))

        userService.insertarPasajero(pasajero).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                pasajero = response?.body()
                Log.i(TAG_LOGS, Gson().toJson(pasajero))

                Toast.makeText(this@registro_pasajero,"Registro Exitoso",Toast.LENGTH_LONG).show()


            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }



}
