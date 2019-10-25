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
import kotlinx.android.synthetic.main.activity_registro_conductor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class registro_conductor : AppCompatActivity() {

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
    private lateinit var etLicCond: EditText
    private lateinit var etFacebook: EditText

    private lateinit var sede:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_conductor)


        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val adapter = ArrayAdapter.createFromResource(this,
        R.array.sedes, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spSede.adapter = adapter






        userService = retrofit.create<UsuarioApiService>(UsuarioApiService::class.java)

        btnRegistrarme = findViewById<Button>(R.id.btnIrRegistro)


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



            AgregarConductor()

            val intent = Intent(this, Bienvenido::class.java)
            startActivity(intent)

        }


    }


    fun AgregarConductor() {


        etTelefono = findViewById<EditText>(R.id.etTelefono)
        etDistrito = findViewById<EditText>(R.id.etDistrito)
        etDNI = findViewById<EditText>(R.id.etDNI)
        etNombre = findViewById<EditText>(R.id.etNombres)
        etApellido = findViewById<EditText>(R.id.etApellidos)
        etContraseña = findViewById<EditText>(R.id.etContraseñaLogin)
        etEmail = findViewById<EditText>(R.id.etEmail)
        etCodigo = findViewById<EditText>(R.id.etCodigo)
        etFacebook = findViewById<EditText>(R.id.etFacebook)
        etLicCond = findViewById<EditText>(R.id.etLicConduc)




        var conductor: Usuario? = Usuario(
            etCodigo.text.toString(),
            etEmail.text.toString(),
            etContraseña.text.toString(),
            etDNI.text.toString(),
            etNombre.text.toString(),
            etApellido.text.toString(),
            0.0,
            0.0,
            etTelefono.text.toString(),
            etFacebook.text.toString(),
            etDistrito.text.toString(),
            'C',
            etLicCond.text.toString(),
            sede

        )

        Log.i(TAG_LOGS, Gson().toJson(conductor))

        userService.insertarConductor(conductor).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>?) {
                conductor = response?.body()
                Log.i(TAG_LOGS, Gson().toJson(conductor))
                Toast.makeText(this@registro_conductor,"Registro Exitoso",Toast.LENGTH_LONG).show()


            }

            override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }



}
