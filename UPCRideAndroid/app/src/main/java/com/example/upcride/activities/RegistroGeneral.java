package com.example.upcride.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.upcride.R;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistroGeneral extends AppCompatActivity {


    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_general);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://upcride.jl.serv.net.mx/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void RegistrarUsuario(){

    }

}
