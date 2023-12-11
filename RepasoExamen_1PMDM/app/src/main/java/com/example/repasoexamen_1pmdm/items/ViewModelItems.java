package com.example.repasoexamen_1pmdm.items;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class ViewModelItems extends AndroidViewModel{

    ModelItems modelItems;

    MutableLiveData<List<Item>> listItemsMutableLiveData = new MutableLiveData<>();

    MutableLiveData<Item> itemSeleccionado = new MutableLiveData<>();

    public void seleccionar(Item item){
        itemSeleccionado.setValue(item);
    }

    public MutableLiveData<Item> seleccionado(){
        return itemSeleccionado;
    }

    public ViewModelItems(@NonNull Application application) {
        super(application);

        modelItems = new ModelItems();

        listItemsMutableLiveData.setValue(modelItems.getListaItems());
    }

    public MutableLiveData<List<Item>> obtener(){
        return listItemsMutableLiveData;
    }
}
