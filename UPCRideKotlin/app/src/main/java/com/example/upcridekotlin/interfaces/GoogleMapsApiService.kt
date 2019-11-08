package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GoogleMapsApiService {

    //@GET("json?origin={originLat},{originLng}&destination={destinationLat},{destinationLng}&key={apiKey}")
    //fun getDirections(@ParameterName("originLat", "originLng","destinationLat","destinationLng", "apiKey") originLat: Double, originLng: Double, destinationLatLng:Double, ): Call<Usuario>
}