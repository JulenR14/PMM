package com.example.repasoexamen_1pmdm.movimientos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ViewModelMovimientos extends AndroidViewModel {

    ModelMovimientos modelMovimientos;

    MutableLiveData<List<Movimiento>> listMovimientosMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Movimiento> movimientoSeleccionado = new MutableLiveData<>();

    void seleccionar(Movimiento movimiento){
        movimientoSeleccionado.setValue(movimiento);
    }

    MutableLiveData<Movimiento> seleccionado(){
        return movimientoSeleccionado;
    }

    public ViewModelMovimientos(@NonNull Application application) {
        super(application);

        modelMovimientos = new ModelMovimientos();

        listMovimientosMutableLiveData.setValue(modelMovimientos.getListaMovimientos());
    }

    MutableLiveData<List<Movimiento>> obtener(){
        return listMovimientosMutableLiveData;
    }

}
