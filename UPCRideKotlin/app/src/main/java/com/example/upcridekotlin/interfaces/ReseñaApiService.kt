package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Auto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ReseñaApiService {

    @GET("autos")
    fun getAllReseñas(): Call<List<Auto>>




    @POST("autos")
    fun insertarReseña(@Body auto: Auto?): Call<Auto>
}