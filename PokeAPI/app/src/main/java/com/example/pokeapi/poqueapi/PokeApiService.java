package com.example.pokeapi.poqueapi;

import com.example.pokeapi.models.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApiService {
    String BASE_URL = "https://pokeapi.co/api/v2/";

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") String id);

    @GET("pokemon")
    Call<List<Pokemon>> getPokemonList(@Query("limit") int limit, @Query("offset") int offset);
}
