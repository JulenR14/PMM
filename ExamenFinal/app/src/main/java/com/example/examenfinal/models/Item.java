package com.example.examenfinal.models;

import com.example.examenfinal.DeserializarCategoria;
import com.example.examenfinal.DeserializarEfectos;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class Item {

    private String name;
    @SerializedName("category")
    @JsonAdapter(DeserializarCategoria.class)
    private String category;
    private String cost;
    @SerializedName("effect_entries")
    @JsonAdapter(DeserializarEfectos.class)
    private String effect;

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getCost() {
        return cost;
    }

    public String getEffect() {
        return effect;
    }

}
