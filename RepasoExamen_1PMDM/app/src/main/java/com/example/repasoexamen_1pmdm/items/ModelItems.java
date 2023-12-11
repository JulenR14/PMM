package com.example.repasoexamen_1pmdm.items;

import java.util.ArrayList;
import java.util.List;

public class ModelItems {

    List<Item> listaItems = new ArrayList<>();
    public ModelItems(){
        listaItems.add(new Item("master-ball", "standard-balls", 0, "Catches a wild Pokémon every time."));
        listaItems.add(new Item("ultra-ball", "standard-balls", 1200, "Catches a wild Pokémon with a 2× catch rate than a standard Poké Ball."));
        listaItems.add(new Item("great-ball", "standard-balls", 600, "Catches a wild Pokémon with a 1.5× catch rate than a standard Poké Ball."));
        listaItems.add(new Item("poke-ball", "standard-balls", 200, "Catches a wild Pokémon with a 1× catch rate."));
        listaItems.add(new Item("safari-ball", "standard-balls", 0, "Catches a wild Pokémon in the Safari Zone."));
        listaItems.add(new Item("net-ball", "standard-balls", 1000, "Catches a wild Pokémon that is in the Bug or Water 1 egg groups with a 3× catch rate."));
        listaItems.add(new Item("dive-ball", "standard-balls", 1000, "Catches a wild Pokémon that is in the Water 1 or Water 2 egg groups with a 3.5× catch rate."));
        listaItems.add(new Item("nest-ball", "standard-balls", 1000, "Catches a wild Pokémon with a level equal to or lower than the player's Pokémon with a 3× catch rate."));
        listaItems.add(new Item("repeat-ball", "standard-balls", 1000, "Catches a wild Pokémon that has already been caught with a 3× catch rate."));
        listaItems.add(new Item("timer-ball", "standard-balls", 1000, "Catches a wild Pokémon with a 1× catch rate that increases by 0.3× each turn, up to a maximum of 4×."));
        listaItems.add(new Item("luxury-ball", "standard-balls", 1000, "Catches a wild Pokémon with a 1× catch rate. A Pokémon caught with a Luxury Ball gains friendship faster."));
        listaItems.add(new Item("premier-ball", "standard-balls", 0, "Catches a wild Pokémon with a 1× catch rate."));
        listaItems.add(new Item("dusk-ball", "standard-balls", 1000, "Catches a wild Pokémon with a 3.5× catch rate if used at night or in a cave."));
        listaItems.add(new Item("heal-ball", "standard-balls", 300, "Catches a wild Pokémon with a 1× catch rate. The caught Pokémon is healed to full HP and status."));
    }

    public List<Item> getListaItems() {
        return listaItems;
    }
}
