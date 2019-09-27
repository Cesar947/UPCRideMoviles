package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Auto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SolicitudApiService {

    @GET("autos")
    fun getAllSolicitudes(): Call<List<Auto>>

    @POST("autos")
    fun insetarSolicitud(@Body auto: Auto?): Call<Auto>
}