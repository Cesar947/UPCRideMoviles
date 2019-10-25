package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Solicitud
import com.example.upcridekotlin.model.Usuario
import retrofit2.Call
import com.example.upcridekotlin.model.Viaje
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ViajeApiService {

    @POST("viajes/publicar/{conductorId}")
    fun publicarViaje(@Path("conductorId") conductorId: Int, @Body viaje: Viaje?): Call<Viaje>


    /* @RequestMapping(path="/solicitar/{viajeId}", method = RequestMethod.POST)
    public Solicitud solictarViaje( @PathVariable Integer viajeId,  @RequestBody Solicitud s) throws Exception {
*/
    @GET("viajes")
    fun getAllViajes(): Call<List<Viaje>>

    @GET("viajes/{id}")
    fun getViajeById(@Path("id") id: Int): Call<Viaje>


    @POST("viajes/solicitar/{viajeId}")
    fun solicitarViaje(@Path("viajeId") viajeId: Int, pasajeroId: Int): Call<Solicitud>


}