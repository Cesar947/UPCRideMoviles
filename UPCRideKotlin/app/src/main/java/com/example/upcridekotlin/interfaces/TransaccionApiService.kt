package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Auto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TransaccionApiService {

    @GET("autos")
    fun getAllTransacciones(): Call<List<Auto>>

    @POST("autos")
    fun insertarTransaccion(@Body auto: Auto?): Call<Auto>
}

