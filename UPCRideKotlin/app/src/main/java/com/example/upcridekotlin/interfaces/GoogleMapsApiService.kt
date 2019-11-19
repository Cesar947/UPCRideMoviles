package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Usuario
import com.example.upcridekotlin.model.Viaje
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface GoogleMapsApiService {


   @GET("json")
   fun getDirections(@Query("origin") originLatLng: String, @Query("destination") destinationLatLng: String, @Query("key")key:String): Call<JsonObject>

    @GET("json")
    fun getDirections2(@Query("origin") originLatLng: String, @Query("destination") destinationLatLng: String, @Query("key")key:String): Call<String>
}