package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Auto
import com.example.upcridekotlin.model.Reseña
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ReseñaApiService {

    @GET("reseña")
    fun getAllReseñas(): Call<List<Reseña>>




    @POST("reseña")
    fun insertarReseña(@Body auto: Auto?): Call<Reseña>
}