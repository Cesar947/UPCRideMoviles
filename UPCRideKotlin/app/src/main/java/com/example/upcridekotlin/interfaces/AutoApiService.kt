package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Auto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AutoApiService {


    @GET("autos")
    fun getAllAutos(): Call<List<Auto>>

    @POST("autos")
    fun insertarAuto(@Body auto: Auto?): Call<Auto>


}