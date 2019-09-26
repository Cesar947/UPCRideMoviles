package com.example.upcride.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.location.Location;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.upcride.R;
import com.example.upcride.interfaces.UsuarioPlaceHolderApi;
import com.example.upcride.model.Usuario;


import java.lang.reflect.Array;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistroGeneral extends AppCompatActivity {


    private Retrofit retrofit;
    private UsuarioPlaceHolderApi usuarioPlaceHolderApi;
    EditText etEmail;
    EditText etContraseña;
    EditText etNombres;
    EditText etApellidos;
    EditText etTelefono;
    EditText etDistrito;
    EditText etDNI;
    Spinner  spSede;
    public String sede = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_general);
        Location locator;


        retrofit = new Retrofit.Builder()
                .baseUrl("http://upcride.jl.serv.net.mx/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        usuarioPlaceHolderApi = retrofit.create(UsuarioPlaceHolderApi.class);
        etEmail  = (EditText) findViewById(R.id.etEmail);
        etContraseña = (EditText) findViewById(R.id.etContraseña);
        etNombres = (EditText) findViewById(R.id.etNombres);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etDistrito = (EditText) findViewById(R.id.etDistrito);
        etDNI = (EditText) findViewById(R.id.etDNI);
        spSede = (Spinner) findViewById(R.id.spSede);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sedes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSede.setAdapter(adapter);

        spSede.setOnItemClickListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    private void RegistrarPasajero(){

        if(etEmail.getText().toString().isEmpty() ||
           etContraseña.getText().toString().isEmpty() ||
           etNombres.getText().toString().isEmpty() ||
           etApellidos.getText().toString().isEmpty() ||
           etTelefono.getText().toString().isEmpty() ||
           etDistrito.getText().toString().isEmpty() ||
           etDNI.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Debe llenar todos los campos", Toast.LENGTH_LONG).show();
        }
        else {
        Usuario pasajero = new Usuario(
             etEmail.getText().toString().substring(0, 9),
             etEmail.getText().toString(),
                etContraseña.getText().toString(),
                etNombres.getText().toString(),
                etApellidos.getText().toString(),
                -11.1345235, -77.1213432,
                etTelefono.getText().toString(),
                etDistrito.getText().toString(),
                "P",
                etDNI.getText().toString(),
                /* String codigo, String correoUPC, String contraseña, String nombres, String apellidos, double ubicacionLatitud,
                   double ubicacionLongitud, String telefono, String distrito, char rol, String sede, int dni*/

        );

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
                content += "codigo: " + pasajeroResponse.getCodigo() + "\n";
                content += "contraseña: " + pasajeroResponse.getContraseña() + "\n";
                content += "nombres: " + pasajeroResponse.getNombres() + "\n";
                content += "apellidos: " + pasajeroResponse.getApellidos() + "\n";
                content += "distrito: " + pasajeroResponse.getDistrito() + "\n";
                content += "telefono: " + pasajeroResponse.getTelefono() + "\n";
                content += "sede: " + pasajeroResponse.getSede() + "\n";
                content += "rol" + pasajeroResponse.getRol() + "\n";


// COMPLETAR CON GOOGLE MAPS EL REGISTRO DE LATITUD Y LONGITUD O EN OTRO ACTIVITY

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
        }
        }

}
