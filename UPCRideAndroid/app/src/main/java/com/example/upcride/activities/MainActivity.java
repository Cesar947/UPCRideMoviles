package com.example.upcride.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;


import com.example.upcride.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private Toolbar toolbar;

    private BottomNavigationView mainNav;

    private FrameLayout mainFrame;

    private HomeFragment homeFragment;
    private ViajesFragment viajesFragment;
    private SolicitudesFragment solicitudesFragment;
    private PerfilFragment perfilFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        mainFrame = (FrameLayout) findViewById(R.id.main_frame);
        homeFragment = new HomeFragment();
        viajesFragment = new ViajesFragment();
        solicitudesFragment = new SolicitudesFragment();
        perfilFragment = new PerfilFragment();


        setSupportActionBar(toolbar);

        mainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.inicio:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.perfil:
                        selectedFragment = new PerfilFragment();
                        break;
                    case R.id.solis:
                        selectedFragment = new SolicitudesFragment();
                        break;
                    case R.id.viajes:
                        selectedFragment = new ViajesFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, selectedFragment).commit();

                return true;
            }
        });


    }


}
