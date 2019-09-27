package com.example.upcridekotlin.interfaces


import com.example.upcridekotlin.model.Usuario

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsuarioApiService {


    @GET("usuarios/")
    fun getAllUsers(): Call<List<Usuario>>

    @GET("usuarios/{id}")
    fun getUsuarioById(@Path("id") id: Int): Call<Usuario>


    @POST("usuarios/pasajero")
    fun insertarPasajero(@Body usuario: Usuario?): Call<Usuario>

    @POST("usuarios/conductor")
    fun insertarConductor(@Body usuario: Usuario?): Call<Usuario>



}