package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.pokeapi.models.Pokemon;
import com.example.pokeapi.poqueapi.PokeApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonAleatorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_aleatorio);

        TextView pokemonName = findViewById(R.id.textPokemonName);
        TextView pokemonHeight = findViewById(R.id.textHeightName);
        TextView pokemonWeight = findViewById(R.id.textWeightName);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PokeApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokeApiService service = retrofit.create(PokeApiService.class);

        Call<Pokemon> pokemonCall = service.getPokemon(String.valueOf((int) (Math.random() * 807 + 1)));

        pokemonCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon = response.body();
                if (pokemon != null) {
                    pokemonName.setText(pokemon.getName());
                    pokemonHeight.setText(pokemon.getHeight());
                    pokemonWeight.setText(pokemon.getWeight());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.d("POKEDEX", "onFailure: " + t.getMessage());
            }
        });
    }
}