package com.example.retrofitguiada;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Itunes {

    class Respuesta{
        List<Contenido> resultados;
    }

    class Contenido{
        String name;
    }

    public static Api api = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api.class);

    public interface Api {
        @GET("pokemon/")
        Call<Respuesta> buscar(@Query("limit") int limit, @Query("offset") int offset);
    }

}
