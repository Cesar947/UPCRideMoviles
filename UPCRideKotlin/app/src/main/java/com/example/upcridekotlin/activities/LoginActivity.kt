package com.example.upcridekotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.upcridekotlin.R
import com.example.upcridekotlin.interfaces.UsuarioApiService
import com.example.upcridekotlin.model.Usuario
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.android.material.textfield.TextInputEditText
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.android.material.textfield.TextInputLayout


class LoginActivity : AppCompatActivity() {


    var etCorreo: TextInputLayout? = null

    var etContraseña: TextInputLayout? = null

    val TAG_LOGS = "Bryan Miramira"
    lateinit var userService: UsuarioApiService

    var btnIngresar : Button? = null
    var id = 0
    var existe :Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userService = retrofit.create(UsuarioApiService::class.java)

        etCorreo = findViewById(R.id.etCorreoLogin)
        etContraseña = findViewById((R.id.etContraseñaLogin))
        btnIngresar = findViewById(R.id.btnIngresarLogin)


        btnIngresar?.setOnClickListener{

            val intent = Intent(this, mActivity::class.java)

            var token = etCorreo?.editText?.text.toString() + etContraseña?.editText?.text.toString();

            userService.getAllUsers().enqueue(object : Callback<List<Usuario>> {
                override fun onResponse(call: Call<List<Usuario>>?, response: Response<List<Usuario>>?) {

                    var usuarios = response?.body()

                    Log.i(TAG_LOGS, Gson().toJson(token))

                    for(item in usuarios!!)
                    {
                        if(token == item.correoUPC + item.contraseña)
                        {
                            id = item.id

                            var miBundle  = Bundle();
                            miBundle.putInt("id", id)
                            intent.putExtras(miBundle)

                            startActivity(intent)
                            //Toast.makeText(this@LoginActivity,"Entraste",Toast.LENGTH_LONG).show();
                            Log.i(TAG_LOGS, Gson().toJson(item))

                        }
                        else
                        {
                            Log.i(TAG_LOGS, Gson().toJson(usuarios))
                            Toast.makeText(this@LoginActivity,"Ingrese un correo y contraseña existente",Toast.LENGTH_LONG).show();
                        }
                    }





                }

                override fun onFailure(call: Call<List<Usuario>>?, t: Throwable?) {
                    t?.printStackTrace()
                }
            })





        }



    }


    /*fun validar()
    {
        var token = etCorreo?.text.toString() + etContraseña?.text.toString();

        userService.getAllUsers().enqueue(object : Callback<List<Usuario>> {
            override fun onResponse(call: Call<List<Usuario>>?, response: Response<List<Usuario>>?) {
                var usuarios = response?.body()
                Log.i(TAG_LOGS, Gson().toJson(usuarios))
                Log.i(TAG_LOGS, Gson().toJson(token))


                for(i in 0..usuarios!!.size)
                {
                    if(token == usuarios[i].correoUPC + usuarios[i].contraseña)
                    {
                        id = usuarios[i].id
                        existe = true;
                    }
                }


            }

            override fun onFailure(call: Call<List<Usuario>>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })

    }*/






}