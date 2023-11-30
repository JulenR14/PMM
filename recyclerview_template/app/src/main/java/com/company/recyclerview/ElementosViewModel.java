package com.company.recyclerview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementosViewModel extends AndroidViewModel {

    ElementosRepositorio elementosRepositorio;

    MutableLiveData<List<Elemento>> listElementosMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Elemento> elemenoSeleccionado = new MutableLiveData<>();

    void seleccionar(Elemento elemento){
        elemenoSeleccionado.setValue(elemento);
    }

    MutableLiveData<Elemento> seleccionado(){
        return elemenoSeleccionado;
    }

    public ElementosViewModel(@NonNull Application application) {
        super(application);

        elementosRepositorio = new ElementosRepositorio();

        listElementosMutableLiveData.setValue(elementosRepositorio.obtener());
    }

    MutableLiveData<List<Elemento>> obtener(){
        return listElementosMutableLiveData;
    }

    void insertar(Elemento elemento){
        elementosRepositorio.insertar(elemento, new ElementosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Elemento> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }

    void eliminar(Elemento elemento){
        elementosRepositorio.eliminar(elemento, new ElementosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Elemento> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }

    void actualizar(Elemento elemento, float valoracion){
//        ElementosRepositorio.api.buscar().enqueue(new retrofit2.Callback<Elemento>() {
//            @Override
//            public void onResponse(retrofit2.Call<Elemento> call, retrofit2.Response<Elemento> response) {
//                if(response.isSuccessful()){
//                    listElementosMutableLiveData.setValue(elementosRepositorio.obtener());
//                }
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<Elemento> call, Throwable t) {
//
//            }
//        });
        elementosRepositorio.actualizar(elemento, valoracion, new ElementosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Elemento> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }
}
