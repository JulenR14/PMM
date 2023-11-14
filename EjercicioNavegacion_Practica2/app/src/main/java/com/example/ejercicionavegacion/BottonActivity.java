package com.example.ejercicionavegacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.ejercicionavegacion.databinding.ActivityBottonBinding;

public class BottonActivity extends AppCompatActivity {

    ActivityBottonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityBottonBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavView, navController);
        NavigationUI.setupWithNavController(binding.toolbar, navController);
    }


}