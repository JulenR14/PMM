package com.example.combatepokemon;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.lang.reflect.Executable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PokemonViewModel extends AndroidViewModel {

    MutableLiveData<Pokemon> pokemon1 = new MutableLiveData<>();
    MutableLiveData<Pokemon> pokemon2 = new MutableLiveData<>();
    MutableLiveData<String> errorNombre = new MutableLiveData<>();
    MutableLiveData<Integer> errorHp = new MutableLiveData<>();
    MutableLiveData<Integer> errorAtaque = new MutableLiveData<>();
    MutableLiveData<Integer> errorDefensa = new MutableLiveData<>();
    MutableLiveData<Integer> errorAtaqueEspecial = new MutableLiveData<>();
    MutableLiveData<Integer> errorDefensaEspecial = new MutableLiveData<>();

    MutableLiveData<Boolean> creandoPokemon = new MutableLiveData<>();

    PokemonModel pokemonModel;

    Executor executor;

    public PokemonViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        pokemonModel = new PokemonModel();
    }

    public void agregarPokemon(String nombre, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial){

        final Pokemon pokemon = new Pokemon(nombre, hp, ataque, defensa, ataqueEspecial, defensaEspecial);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                pokemonModel.agregarPokemon(pokemon, new PokemonModel.Callback() {

                    @Override
                    public void cuandoEmpiezaCrearPokemon() {
                        creandoPokemon.postValue(true);
                    }

                    @Override
                    public void cuandoElPokemonEstaCreado(Pokemon pokemon) {
                        errorNombre.postValue(null);
                        errorHp.postValue(null);
                        errorAtaque.postValue(null);
                        errorDefensa.postValue(null);
                        errorAtaqueEspecial.postValue(null);
                        errorDefensaEspecial.postValue(null);

                        if (pokemon1.equals(null)){
                            pokemon1.postValue(pokemon);
                        }else if (pokemon2 == null){
                            pokemon2.postValue(pokemon);
                        }
                    }

                    @Override
                    public void cuandoHayErrorEnElNombre(String error) {
                        errorNombre.postValue(error);
                    }

                    @Override
                    public void cuandoHayErrorEnLaVida(int hpMinima, int hpMaxima) {
                        errorHp.postValue(hpMinima);
                    }

                    @Override
                    public void cuandoHayErrorEnElAtaque(int ataqueMinimo, int ataqueMaximo) {
                        errorAtaque.postValue(ataqueMinimo);
                    }

                    @Override
                    public void cuandoHayErrorEnLaDefensa(int defensaMinima, int defensaMaxima) {
                        errorDefensa.postValue(defensaMinima);
                    }

                    @Override
                    public void cuandoHayErrorEnElAtaqueEspecial(int ataqueEspecialMinimo, int ataqueEspecialMaximo) {
                        errorAtaqueEspecial.postValue(ataqueEspecialMinimo);
                    }

                    @Override
                    public void cuandoHayErrorEnLaDefensaEspecial(int defensaEspecialMinima, int defensaEspecialMaxima) {
                        errorDefensaEspecial.postValue(defensaEspecialMinima);
                    }

                    @Override
                    public void cuandoTerminaCrearPokemon() {
                        creandoPokemon.postValue(false);
                    }
                });
            }
        });

    }
}
