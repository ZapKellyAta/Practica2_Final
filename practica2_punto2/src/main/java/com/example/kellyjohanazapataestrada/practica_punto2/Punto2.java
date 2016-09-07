package com.example.kellyjohanazapataestrada.practica_punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Punto2 extends AppCompatActivity
{
    private EditText Num1,Num2;
    private TextView Res;
    private RadioButton btnSuma,btnResta,btnMulti,btnDiv;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto2);

        Num1=(EditText)findViewById(R.id.txtNum1);
        Num2=(EditText)findViewById(R.id.txtNum2);
        Res=(TextView)findViewById(R.id.txtRes);
        btnSuma=(RadioButton)findViewById(R.id.btnSuma);
        btnResta=(RadioButton)findViewById(R.id.btnResta);
        btnMulti=(RadioButton)findViewById(R.id.btnMulti);
        btnDiv=(RadioButton)findViewById(R.id.btnDiv);
    }

    public void Resultado(View v)
    {
        String valor1=Num1.getText().toString();
        String valor2=Num2.getText().toString();

        if(valor1.isEmpty()|| valor2.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Falta informacion",Toast.LENGTH_LONG).show();
            Res.setText("Falta Info");
        }
        else
        {
            double N1=Double.parseDouble(valor1);
            double N2=Double.parseDouble(valor2);

            if (btnSuma.isChecked()==true) {
                double suma=N1+N2;
                String resultado=String.valueOf(suma);
                Res.setText(resultado);
            } else
            if (btnResta.isChecked()==true) {
                double resta=N1-N2;
                String resultado=String.valueOf(resta);
                Res.setText(resultado);
            } else
            if (btnMulti.isChecked()==true) {
                double multi=N1*N2;
                String resultado=String.valueOf(multi);
                Res.setText(resultado);
            }else
            if (btnDiv.isChecked()==true) {
                double div = N1 / N2;
                String resultado = Double.toString(div);
                Res.setText(resultado);
            }

        }
    }
}
