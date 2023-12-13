package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pokeapi.databinding.ActivityMainBinding;
import com.example.pokeapi.models.Pokemon;
import com.example.pokeapi.poqueapi.PokeApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPokemonAleatorio = findViewById(R.id.pokemonAleatorio);
        Button btnPokemonBuscado = findViewById(R.id.listaPokemons);

        btnPokemonAleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PokemonAleatorio.class));
            }
        });

        btnPokemonBuscado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PokemonList.class));
            }
        });

    }
}