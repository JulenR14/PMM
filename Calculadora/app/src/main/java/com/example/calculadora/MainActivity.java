package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String muestraOperacion = "";
    private ArrayList<String> operacion = new ArrayList<String>();
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private TextView textoOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);

        textoOperacion = findViewById(R.id.textView);

        ejecutarBoton(btn0);
        ejecutarBoton(btn1);
        ejecutarBoton(btn2);
        ejecutarBoton(btn3);
        ejecutarBoton(btn4);
        ejecutarBoton(btn5);
        ejecutarBoton(btn6);
        ejecutarBoton(btn7);
        ejecutarBoton(btn8);
        ejecutarBoton(btn9);
    }

    public void ejecutarBoton(Button b){
        System.out.println("Fallo 2");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anidarOperacion(b.getText().toString());
            }
        });
    }

    public void anidarOperacion(String valor){
        System.out.println("FALLO 3");
        if(!valor.equals("+")){
            if(!this.operacion.isEmpty()){
                if(!(this.operacion.get(this.operacion.size()-1) == "+")){
                    this.operacion.add(valor);
                    muestraOperacion += valor;
                }
            }
        }

        textoOperacion.setText(muestraOperacion);

    }

}