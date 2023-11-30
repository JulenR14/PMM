package com.company.recyclerview;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ElementosRepositorio {

    List<Elemento> elementos = new ArrayList<>();

    public static Api api = new Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/pokemon-species/")
        .build()
        .create(Api.class);

    public interface Api {
        @GET("search/")
        Call<Elemento> buscar(@Query("q") String query);
    }

    interface Callback {
        void cuandoFinalice(List<Elemento> elementos);
    }


    List<Elemento> obtener() {
        return elementos;
    }

    void insertar(Elemento elemento, Callback callback){
        elementos.add(elemento);
        callback.cuandoFinalice(elementos);
    }

    void eliminar(Elemento elemento, Callback callback) {
        elementos.remove(elemento);
        callback.cuandoFinalice(elementos);
    }

    void actualizar(Elemento elemento, float valoracion, Callback callback) {
        elemento.valoracion = valoracion;
        callback.cuandoFinalice(elementos);
    }
}
