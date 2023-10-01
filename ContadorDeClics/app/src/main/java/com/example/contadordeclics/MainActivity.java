package com.example.contadordeclics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.contadordeclics.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    int contador;
    //TextView contadorDeClics;
    //Button augmentarElContador;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        //contadorDeClics = binding.contadorDeClics;
        //augmentarElContador = binding.augmentarElContador;

        binding.augmentarElContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                binding.contadorDeClics.setText("Has clicado " + contador + " veces.");
            }
        });
    }
}