package com.example.repasoexamen_1pmdm.movimientos;

import java.util.List;

public class Movimiento {
    private String nombre;
    private int accuracy;
    private List<String> pokemons;

    public Movimiento(String nombre, int accuracy, List<String> pokemons) {
        this.nombre = nombre;
        this.accuracy = accuracy;
        this.pokemons = pokemons;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public List<String> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<String> pokemons) {
        this.pokemons = pokemons;
    }
}
