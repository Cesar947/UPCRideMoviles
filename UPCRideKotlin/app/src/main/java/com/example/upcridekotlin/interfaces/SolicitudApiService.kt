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



    @POST("solicitudes")
    fun insertarSolicitud(@Body auto: Auto?): Call<Solicitud>


    @GET("solicitudes/conductor/{conductorId}")
    fun obtenerSolicitudesPorConductor(@Path("conductorId") conductorId: Int ): Call<List<Solicitud>>
}

