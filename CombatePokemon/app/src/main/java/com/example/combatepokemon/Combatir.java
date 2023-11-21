package com.example.combatepokemon;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.concurrent.Executor;

public class Combatir{

    public static Combatir instance;

    public Pokemon pokemon1;
    public Pokemon pokemon2;

    public String agregarPokemon(Pokemon pokemon){
        String mensaje = "El pokemon no se ha podido crear.";
        try {
            Thread.sleep(5000);
            if(instance.pokemon1 == null){
                instance.pokemon1 = pokemon;
                mensaje = "El pokemon " + pokemon.getNombre() + " 1 se ha creado correctamente.";
            }else if (instance.pokemon2 == null){
                mensaje = "El pokemon " + pokemon.getNombre() + " 2 se ha creado correctamente.";
                instance.pokemon2 = pokemon;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());;
        }
        return mensaje;
    }


}
