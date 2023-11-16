package com.example.ejercicionavegacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ejercicionavegacion.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.tabFragment, R.id.drawer2Fragment)
                .setOpenableLayout(binding.drawerLayout)
                .build();
        navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView)).getNavController();
        //Estableciendo la navegación en el Bottom Navigation View
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);
        //Estableciendo la navegación en el Navigation View
        NavigationUI.setupWithNavController(binding.navView, navController);
        //Estableciendo la navegación en el toolbar
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);
    }
}