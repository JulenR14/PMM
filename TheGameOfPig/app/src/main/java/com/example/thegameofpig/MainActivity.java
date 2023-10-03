package com.example.thegameofpig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int puntosJugador1 = 0, puntosJugador2 = 0;
    int currentJugador1 = 0, currentJugador2 = 0;
    boolean cambioPersona = true;
    TextView current1, current2, textoPuntuacion1, textoPuntuacion2;
    Button rollDice, hold, resetGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollDice = findViewById(R.id.rollDice);
        hold = findViewById(R.id.hold);
        resetGame = findViewById(R.id.resetGame);

        tirarDado(rollDice);

        dejarApostar(hold);

        resetearJuego(resetGame);
    }

    public void tirarDado(Button roll){

        current1 = findViewById(R.id.current1);
        current2 = findViewById(R.id.current2);
        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numeroAleatorio = numeroAleatorio();

                if (cambioPersona){
                    if (numeroAleatorio != 1){
                        currentJugador1 += numeroAleatorio;
                        current1.setText("CURRENT\n" + currentJugador1);
                    }else{
                        currentJugador1 = 0;
                        current1.setText("CURRENT\n" + currentJugador1);
                        cambioPersona = false;
                    }
                }else {
                    if (numeroAleatorio != 1){
                        currentJugador2 += numeroAleatorio;
                        current2.setText("CURRENT\n" + currentJugador2);
                    }else{
                        currentJugador2 = 0;
                        current2.setText("CURRENT\n" + currentJugador2);
                        cambioPersona = true;
                    }
                }


            }
        });

    }

    public void dejarApostar(Button hold){

        current1 = findViewById(R.id.current1);
        current2 = findViewById(R.id.current2);
        textoPuntuacion1 = findViewById(R.id.textoPuntuacion1);
        textoPuntuacion2 = findViewById(R.id.textoPuntuacion2);

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cambioPersona) {
                    puntosJugador1 += currentJugador1;
                    currentJugador1 = 0;
                    textoPuntuacion1.setText(String.valueOf(puntosJugador1));
                    current1.setText("CURRENT\n" + currentJugador1);
                    cambioPersona = false;
                }else{
                    puntosJugador2 += currentJugador2;
                    currentJugador2 = 0;
                    textoPuntuacion2.setText(String.valueOf(puntosJugador2));
                    current2.setText("CURRENT\n" + currentJugador2);
                    cambioPersona = true;
                }

            }
        });

    }

    public void resetearJuego(Button newGame){

        current1 = findViewById(R.id.current1);
        current2 = findViewById(R.id.current2);
        textoPuntuacion1 = findViewById(R.id.textoPuntuacion1);
        textoPuntuacion2 = findViewById(R.id.textoPuntuacion2);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current1.setText("CURRENT\n0");
                current2.setText("CURRENT\n0");
                textoPuntuacion1.setText("0");
                textoPuntuacion2.setText("0");
                puntosJugador1 = 0;
                puntosJugador2 = 0;
                currentJugador1 = 0;
                currentJugador2 = 0;

            }
        });
    }

    public static int numeroAleatorio(){
        return (int)(Math.random() * 7);
    }
}