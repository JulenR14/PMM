package com.example.model_view_viewmodel;

public class SimuladorHipoteca {

    public static class Solicitud{
        public double capital;
        public int plazo;
        public int edad;
        private String nombre;
        private String apellido;

        public Solicitud(double capital, int plazo, int edad, String nombre, String apellido) {
            this.capital = capital;
            this.plazo = plazo;
            this.edad = edad;
            this.nombre = nombre;
            this.apellido = apellido;
        }
    }

    interface Callback {
        void cuandoEsteCalculadaLaCuota(double cuota, String nombre, String apellido, int edad);
        void cuandoHayaErrorDeCapitalInferiorAlMinimo(double capitalMinimo);
        void cuandoHayaErrorDePlazoInferiorAlMinimo(int plazoMinimo);
        void cuandoHayaErrorDeEdadInferiorAlMinimo(int edad);
        void cuandoEmpieceElCalculo();
        void cuandoFinaliceElCalculo();
    }

    public void calcular(Solicitud solicitud, Callback callback) {

        callback.cuandoEmpieceElCalculo();

        double interes = 0;
        double capitalMinimo = 0;
        int edadMinima = 0;
        int plazoMinimo = 0;

        try{
            Thread.sleep(10000);
            interes = 0.01605;
            capitalMinimo = 1000;
            edadMinima = 18;
            plazoMinimo = 2;
        }catch (InterruptedException e){}

        boolean error = false;
        if (solicitud.capital < capitalMinimo) {
            callback.cuandoHayaErrorDeCapitalInferiorAlMinimo(capitalMinimo);
            error = true;
        }

        if (solicitud.plazo < plazoMinimo) {
            callback.cuandoHayaErrorDePlazoInferiorAlMinimo(plazoMinimo);
            error = true;
        }

        if (solicitud.edad < edadMinima){
            callback.cuandoHayaErrorDeEdadInferiorAlMinimo(edadMinima);
            error = true;
        }

        if(!error) {
            callback.cuandoEsteCalculadaLaCuota(solicitud.capital * interes / 12 / (1 - Math.pow(1 + (interes / 12), -solicitud.plazo * 12)), solicitud.nombre, solicitud.apellido, solicitud.edad);
        }

        callback.cuandoFinaliceElCalculo();
    }
}
