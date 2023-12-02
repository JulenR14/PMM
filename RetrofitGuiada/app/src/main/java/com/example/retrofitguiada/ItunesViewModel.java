package com.example.retrofitguiada;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItunesViewModel extends AndroidViewModel {

    MutableLiveData<Itunes.Respuesta> respuestaMutableLiveData = new MutableLiveData<>();
    public ItunesViewModel(@NonNull Application application) {
        super(application);
    }

    public void buscar(String texto){
        Itunes.api.buscar(texto).enqueue(new Callback<Itunes.Respuesta>() {
            @Override
            public void onResponse(Call<Itunes.Respuesta> call, Response<Itunes.Respuesta> response) {
                respuestaMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Itunes.Respuesta> call, Throwable t) {}
        });
    }
}
