package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Auto
import com.example.upcridekotlin.model.Solicitud
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SolicitudApiService {

    @GET("solicitudes")
    fun getAllSolicitudes(): Call<List<Solicitud>>

    fun insertarSolicitud(@Body auto: Solicitud?): Call<Solicitud>

}

