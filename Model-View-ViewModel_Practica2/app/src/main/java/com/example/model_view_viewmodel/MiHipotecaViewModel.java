package com.example.model_view_viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MiHipotecaViewModel extends AndroidViewModel {

    MutableLiveData<Double> cuota = new MutableLiveData<>();
    MutableLiveData<String> datosUsuario = new MutableLiveData<>();
    MutableLiveData<Double> errorCapital = new MutableLiveData<>();
    MutableLiveData<Integer> errorPlazos = new MutableLiveData<>();
    MutableLiveData<Integer> errorEdad = new MutableLiveData<>();
    MutableLiveData<Boolean> calculando = new MutableLiveData<>();

    SimuladorHipoteca simulador;

    Executor executor;


    public MiHipotecaViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorHipoteca();
    }

    public void calcular(double capital, int plazo, int edad, String nombre, String apellido) {

        final SimuladorHipoteca.Solicitud solicitud = new SimuladorHipoteca.Solicitud(capital, plazo, edad, nombre, apellido);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                simulador.calcular(solicitud, new SimuladorHipoteca.Callback() {
                    @Override
                    public void cuandoEsteCalculadaLaCuota(double cuotaResultante, String nombre, String apellido, int edad) {
                        errorCapital.postValue(null);
                        errorPlazos.postValue(null);
                        datosUsuario.postValue("Nombre : "+ nombre + "\n" +
                                                "Apellido : " + apellido + "\n" +
                                                "Edad : " + edad + "\n" +
                                                "Cantidad : \n");
                        cuota.postValue(cuotaResultante);
                    }
                    @Override
                    public void cuandoHayaErrorDeCapitalInferiorAlMinimo(double capitalMinimo) {
                        errorCapital.postValue(capitalMinimo);
                    }

                    @Override
                    public void cuandoHayaErrorDePlazoInferiorAlMinimo(int plazoMinimo) {
                        errorPlazos.postValue(plazoMinimo);
                    }

                    @Override
                    public void cuandoHayaErrorDeEdadInferiorAlMinimo(int edad) {
                        errorEdad.postValue(edad);
                    }

                    @Override
                    public void cuandoEmpieceElCalculo() {
                        calculando.postValue(true);
                    }

                    @Override
                    public void cuandoFinaliceElCalculo() {
                        calculando.postValue(false);
                    }
                });
            }
        });
    }

}
