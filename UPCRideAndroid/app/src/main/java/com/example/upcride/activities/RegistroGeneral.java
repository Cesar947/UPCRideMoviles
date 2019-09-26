package com.example.upcride.activities;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;

import android.widget.Toast;

import com.example.upcride.R;
import com.example.upcride.interfaces.UsuarioPlaceHolderApi;
import com.example.upcride.model.Usuario;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistroGeneral extends AppCompatActivity {


    private Retrofit retrofit;
    private UsuarioPlaceHolderApi usuarioPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_general);



        retrofit = new Retrofit.Builder()
                .baseUrl("http://upcride.jl.serv.net.mx/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        usuarioPlaceHolderApi = retrofit.create(UsuarioPlaceHolderApi.class);
    }

    private void RegistrarUsuario(){
        Usuario pasajero = new Usuario();
        Call<Usuario> call = usuarioPlaceHolderApi.registrarPasajero(pasajero);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }

                Usuario pasajeroResponse = response.body();

                String content = "";
                content += "correoUPC: " + pasajeroResponse.getCorreoUPC() + "\n";
                content += "codigo: " + pasajeroResponse.getCodigo().substring(0, 9) + "\n";
                content += "contraseña: " + pasajeroResponse.getContraseña() + "\n";
                content += "nombres: " + pasajeroResponse.getNombres() + "\n";
                content += "apellidos: " + pasajeroResponse.getApellidos() + "\n";
                content += "distrito: " + pasajeroResponse.getDistrito() + "\n";
                content += "telefono: " + pasajeroResponse.getTelefono() + "\n";
                content += "sede: " + pasajeroResponse.getSede() + "\n";

// COMPLETAR CON GOOGLE MAPS EL REGISTRO DE LATITUD Y LONGITUD O EN OTRO ACTIVITY

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }

}
