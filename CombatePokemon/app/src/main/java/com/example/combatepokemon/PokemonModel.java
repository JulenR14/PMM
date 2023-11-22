package com.example.combatepokemon;

public class PokemonModel {

    interface Callback {
        void cuandoElPokemonEstaCreado(Pokemon pokemon);
        void cuandoHayErrorEnElNombre(String error);
        void cuandoHayErrorEnLaVida(int hpMinima, int hpMaxima);
        void cuandoHayErrorEnElAtaque(int ataqueMinimo, int ataqueMaximo);
        void cuandoHayErrorEnLaDefensa(int defensaMinima, int defensaMaxima);
        void cuandoHayErrorEnElAtaqueEspecial(int ataqueEspecialMinimo, int ataqueEspecialMaximo);
        void cuandoHayErrorEnLaDefensaEspecial(int defensaEspecialMinima, int defensaEspecialMaximo);
        void cuandoEmpiezaCrearPokemon();
        void cuandoTerminaCrearPokemon();
    }

    public void agregarPokemon(Pokemon pokemon, Callback callback){

        callback.cuandoEmpiezaCrearPokemon();

        int hpMinima = 0;
        int ataqueMinimo = 0;
        int defensaMinima = 0;
        int ataqueEspecialMinimo = 0;
        int defensaEspecialMinima = 0;

        int hpMaxima = 999;
        int ataqueMaximo = 999;
        int defensaMaxima = 999;
        int ataqueEspecialMaximo = 999;
        int defensaEspecialMaximo = 999;

        boolean error = false;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //realizamos las comprobaciones de los parametros

        if(!pokemon.getNombre().matches("[a-zA-Z0-9]*")){
            callback.cuandoHayErrorEnElNombre("El nombre solo puede contener letras y numeros.");
            error = true;
        }
        if (pokemon.getHp() < hpMinima || pokemon.getHp() > hpMaxima){
            callback.cuandoHayErrorEnLaVida(hpMinima, hpMaxima);
            error = true;
        }
        if (pokemon.getAtaque() < ataqueMinimo || pokemon.getAtaque() > ataqueMaximo){
            callback.cuandoHayErrorEnElAtaque(ataqueMinimo, ataqueMaximo);
            error = true;
        }
        if (pokemon.getDefensa() < defensaMinima || pokemon.getDefensa() > defensaMaxima){
            callback.cuandoHayErrorEnLaDefensa(defensaMinima, defensaMaxima);
            error = true;
        }
        if (pokemon.getAtaqueEspecial() < ataqueEspecialMinimo || pokemon.getAtaqueEspecial() > ataqueEspecialMaximo){
            callback.cuandoHayErrorEnElAtaqueEspecial(ataqueEspecialMinimo, ataqueEspecialMaximo);
            error = true;
        }
        if (pokemon.getDefensaEspecial() < defensaEspecialMinima || pokemon.getDefensaEspecial() > defensaEspecialMaximo){
            callback.cuandoHayErrorEnLaDefensaEspecial(defensaEspecialMinima, defensaEspecialMaximo);
            error = true;
        }

        if (!error){
            callback.cuandoElPokemonEstaCreado(pokemon);
        }

        callback.cuandoTerminaCrearPokemon();
    }
}
