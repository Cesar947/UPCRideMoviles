package com.example.upcride.interfaces;

import com.example.upcride.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsuarioPlaceHolderApi {

    @GET("usuarios")
    Call<List<Usuario>> ListarUsuariosRegistrados();
}
