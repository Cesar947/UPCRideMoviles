package com.example.upcride.interfaces;

import com.example.upcride.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UsuarioPlaceHolderApi {

    @GET("usuarios")
    Call<List<Usuario>> ListarUsuariosRegistrados();

    @POST("pasajero")
    Call<Usuario> registrarPasajero(@Body Usuario pasajero);
}
