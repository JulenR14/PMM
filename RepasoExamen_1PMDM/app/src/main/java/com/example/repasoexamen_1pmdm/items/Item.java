package com.example.repasoexamen_1pmdm.items;

public class Item {
    private String nombre;
    private String categoria;
    private int precio;
    private String efectos;

    public Item(String nombre, String categoria, int precio, String efectos) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.efectos = efectos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEfectos() {
        return efectos;
    }

    public void setEfectos(String efectos) {
        this.efectos = efectos;
    }
}
