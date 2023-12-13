package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.pokeapi.models.Pokemon;
import com.example.pokeapi.poqueapi.PokeApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        TextView listaPokemons = findViewById(R.id.listaPokemons);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PokeApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokeApiService service = retrofit.create(PokeApiService.class);

        Call<List<Pokemon>> pokemonCall = service.getPokemonList(20, 5);

        pokemonCall.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                List<Pokemon> pokemons = response.body();
                StringBuilder lista = new StringBuilder();
                if (pokemons != null) {
                    for (Pokemon p : pokemons) {
                        lista.append(p.getName()).append("\n");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                Log.d("POKEDEX", "onFailure: " + t.getMessage());
            }
        });
    }
}