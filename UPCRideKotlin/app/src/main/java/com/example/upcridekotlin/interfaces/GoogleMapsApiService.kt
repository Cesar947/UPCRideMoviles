package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Usuario
import com.example.upcridekotlin.model.Viaje
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface GoogleMapsApiService {


   @GET("json?origin={originLat},{originLng}&destination={destinationLat},{destinationLng}&key=AIzaSyAkSoqQ9v3nMJ9Tv60ZSwkZcgjoNkCGBsw")
    fun getDirections(@Path("originLat") originLat: Double, @Path("originLng") originLng: Double,
                      @Path("destinationLat") destinationLat:Double, @Path("destinationLng")destinationLng:Double): Call<Any>


    @GET("json")
    fun getDirections2(@Query("origin") originLatLng: String, @Query("destination") destinationLatLng: String, @Query("key")key:String): Call<Any>
}