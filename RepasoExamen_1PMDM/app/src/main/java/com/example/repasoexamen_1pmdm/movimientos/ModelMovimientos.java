package com.example.repasoexamen_1pmdm.movimientos;

import java.util.ArrayList;
import java.util.List;

public class ModelMovimientos {

    List<Movimiento> listaMovimientos = new ArrayList<>();

    public ModelMovimientos() {
        listaMovimientos.add(new Movimiento("Pound", 90, new ArrayList<String>(){{add("Gyarados");add("Lapras");add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("Karate", 90, new ArrayList<String>(){{add("Gyarados");add("Lapras"); add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("Double-slap", 40, new ArrayList<String>(){{add("Gyarados");add("Lapras"); add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("Comet-punch", 20, new ArrayList<String>(){{add("Gyarados");add("Lapras"); add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("mega-punch", 60, new ArrayList<String>(){{add("Charizard"); add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("pay-day", 60, new ArrayList<String>(){{add("Charizard"); add("Snorlax"); add("Gyarados"); add("Lapras");}}));
        listaMovimientos.add(new Movimiento("fire-punch", 100, new ArrayList<String>(){{add("Gyarados");add("Lapras");add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("ice-punch", 100, new ArrayList<String>(){{add("Gyarados");add("Lapras");add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("scratch", 100, new ArrayList<String>(){{add("Gyarados");add("Lapras");add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("vice-grip", 100, new ArrayList<String>(){{add("Gyarados");add("Lapras");add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("guillotine", 100, new ArrayList<String>(){{add("Gyarados");add("Lapras");add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("razor-wind", 100, new ArrayList<String>(){{add("Gyarados");add("Lapras");add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("cut", 100, new ArrayList<String>(){{add("Gyarados");add("Lapras");add("Charizard");add("Snorlax");}}));
        listaMovimientos.add(new Movimiento("gust", 100, new ArrayList<String>(){{add("Gyarados");add("Lapras");add("Charizard");add("Snorlax");}}));
    }

    public List<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }



}
