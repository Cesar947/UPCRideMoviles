package com.example.upcride.interfaces;

import com.example.upcride.model.Viaje;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ViajePlaceHolderApi {

    @GET("viajes")
    Call<List<Viaje>> ListarViajesPublicados();

}
