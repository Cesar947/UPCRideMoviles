package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Solicitud
import retrofit2.Call
import com.example.upcridekotlin.model.Viaje
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ViajeApiService {

    @POST("viajes/publicar/{conductorId}")
    fun publicarViaje(@Path("conductorId") conductorId: Int, @Body viaje: Viaje?): Call<Viaje>

    @GET("viajes")
    fun visualizarViajes() : Call<List<Viaje>>

    @POST("viajes/solicitar/{viajeId}")
    fun solicitarViaje(@Path("viajeId") viajeId: Int ): Call<Solicitud>


}