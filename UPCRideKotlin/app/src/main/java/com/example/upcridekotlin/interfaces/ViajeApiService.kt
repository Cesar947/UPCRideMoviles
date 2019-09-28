package com.example.upcridekotlin.interfaces

import com.example.upcridekotlin.model.Solicitud
import retrofit2.Call
import com.example.upcridekotlin.model.Viaje
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface ViajeApiService {

    @POST("/publicar/")
    fun publicarViaje(@Body viaje: Viaje?): Call<Viaje>


    /* @RequestMapping(path="/solicitar/{viajeId}", method = RequestMethod.POST)
    public Solicitud solictarViaje( @PathVariable Integer viajeId,  @RequestBody Solicitud s) throws Exception {
*/

    @POST("/solicitar/{viajeId}")
    fun solicitarViaje(@Path("viajeId") viajeId: Int ): Call<Solicitud>


}