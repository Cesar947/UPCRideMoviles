package com.example.upcride.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.upcride.R;

public class MainActivity extends AppCompatActivity {

    Button btnIrRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrRegistro = (Button) findViewById(R.id.btnIrRegistro);

        btnIrRegistro.setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(), RegistroGeneral.class);
            startActivity(intent);
        });


    }
}
