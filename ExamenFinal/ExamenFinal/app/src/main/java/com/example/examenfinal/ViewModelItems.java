package com.example.examenfinal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.examenfinal.models.Item;
import com.example.examenfinal.models.ItemListItem;
import com.example.examenfinal.models.MoveListItem;

import java.util.List;

public class ViewModelItems extends AndroidViewModel {

    ItemListItem modelItems;

    MutableLiveData<List<MoveListItem>> listItemsMutableLiveData = new MutableLiveData<>();

    MutableLiveData<Item> itemSeleccionado = new MutableLiveData<>();

    public void seleccionar(Item item){
        itemSeleccionado.setValue(item);
    }

    public MutableLiveData<Item> seleccionado(){
        return itemSeleccionado;
    }

    public ViewModelItems(@NonNull Application application) {
        super(application);

        modelItems = new ItemListItem();

      //  listItemsMutableLiveData.setValue(modelItems.getListaItems());
    }

    /*public MutableLiveData<List<Item>> obtener(){
        return listItemsMutableLiveData;
    }*/
}
