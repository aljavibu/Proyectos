package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonSuma;
    private Button buttonResta;
    private Button buttonMultiplicacion;
    private Button buttonDivision;
    private TextView resultado;
    private EditText numero1;
    private EditText numero2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar
        buttonSuma=findViewById(R.id.buttonSuma);
        buttonResta=findViewById(R.id.buttonResta);
        buttonMultiplicacion=findViewById(R.id.buttonMultiplicacion);
        buttonDivision=findViewById(R.id.buttonDivision);
        resultado=findViewById(R.id.Resultado);
        numero1=findViewById(R.id.numero1);
        numero2=findViewById(R.id.numero2);



        //Creamos listeners

        //SUMA
        buttonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Validamos Edittext
                if(numero1.getText().toString().isEmpty()){
                    numero1.setError("Introduce un valor");
                }else if(numero2.getText().toString().isEmpty()){
                    numero2.setError("Introduce un valor");
                }else{
                    resultado.setText(suma(Integer.parseInt(numero1.getText().toString()), Integer.parseInt(numero2.getText().toString()))+"");
                }




            }
        });

        //RESTA
        buttonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validamos Edittext
                if(numero1.getText().toString().isEmpty()){
                    numero1.setError("Introduce un valor");
                }else if(numero2.getText().toString().isEmpty()){
                    numero2.setError("Introduce un valor");
                }else{
                    resultado.setText(resta(Integer.parseInt(numero1.getText().toString()), Integer.parseInt(numero2.getText().toString()))+"");

                }


            }
        });

        //MULTIPLICACION
        buttonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validamos Edittext
                if(numero1.getText().toString().isEmpty()){
                    numero1.setError("Introduce un valor");
                }else if(numero2.getText().toString().isEmpty()){
                    numero2.setError("Introduce un valor");
                }else{
                    resultado.setText(multiplicacion(Integer.parseInt(numero1.getText().toString()), Integer.parseInt(numero2.getText().toString()))+"");

                }
            }
        });

        //DIVISION
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validamos Edittext
                if(numero1.getText().toString().isEmpty()){
                    numero1.setError("Introduce un valor");
                }else if(numero2.getText().toString().isEmpty()){
                    numero2.setError("Introduce un valor");
                }else{
                    resultado.setText(division(Integer.parseInt(numero1.getText().toString()), Integer.parseInt(numero2.getText().toString()))+"");

                }

            }
        });
    }


    //METODOS
    public double suma(double a,double b){
        return a+b;
    }

    public double resta(double a,double b){
        return a-b;
    }
    public double multiplicacion(double a,double b){
        return a*b;
    }
    public double division(double a,double b){
        double resultado;
        if(b==0){
            resultado=0;
        }else{
            resultado=a/b;
        }

        return resultado;
    }
}