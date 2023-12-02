package com.company.recyclerview;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ElementosRepositorio {

    List<Elemento> elementos = new ArrayList<>();

    public ElementosRepositorio(){
        elementos.add(new Elemento("bulbasaur", "El ratio de captura es de 45, su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la semilla. Su ratio de captura es de 45. Su color es el verde. Su género es masculino o femenino. Su hábitat son los bosques. Su peso es de 6,9 kg. Su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la semilla. Su ratio de captura es de 45. Su color es el verde. Su género es masculino o femenino. Su hábitat son los bosques. Su peso es de 6,9 kg. Su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la semilla."));
        elementos.add(new Elemento("ivysaur", "El ratio de captura es de 45, su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la semilla. Su ratio de captura es de 45. Su color es el verde. Su género es masculino o femenino. Su hábitat son los bosques. Su peso es de 6,9 kg. Su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la semilla. Su ratio de captura es de 45. Su color es el verde. Su género es masculino o femenino. Su hábitat son los bosques. Su peso es de 6,9 kg. Su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la"));
        elementos.add(new Elemento("venusaur", "El ratio de captura es de 45, su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la semilla. Su ratio de captura es de 45. Su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la semilla. Su ratio de captura es de 45. Su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la"));
        elementos.add(new Elemento("charmander", "El ratio de captura es de 45, su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la"));
        elementos.add(new Elemento("charmeleon", "El ratio de captura es de 45, su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la"));
        elementos.add(new Elemento("charizard", "El ratio de captura es de 45, su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la"));
        elementos.add(new Elemento("squirtle", "El ratio de captura es de 45, su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la"));
        elementos.add(new Elemento("wartortle", "El ratio de captura es de 45, su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la"));
        elementos.add(new Elemento("blastoise", "El ratio de captura es de 45, su color es el verde y su género es masculino o femenino. Su hábitat son los bosques y su especie es la semilla. Su peso es de 6,9 kg y su altura es de 0,7 m. Su habilidad es espesura y clorofila. Su tipo es planta y veneno. Su especie es la"));
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
