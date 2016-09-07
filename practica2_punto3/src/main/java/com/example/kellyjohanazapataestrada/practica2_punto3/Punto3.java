package com.example.kellyjohanazapataestrada.practica2_punto3;

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

import static android.view.View.INVISIBLE;

public class Punto3 extends AppCompatActivity
{
    private EditText Lado,Radio,Altura,Base;
    private TextView Res;
    private RadioButton btnCuandro,btnCir,btnTri,btnRec;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto3);

        Lado=(EditText)findViewById(R.id.txtLado);
        Radio=(EditText)findViewById(R.id.txtRadio);
        Altura=(EditText)findViewById(R.id.txtAltura);
        Base=(EditText)findViewById(R.id.txtBase);
        Res=(TextView)findViewById(R.id.txtRes);
        btnCuandro=(RadioButton)findViewById(R.id.btnCuadro);
        btnCir=(RadioButton)findViewById(R.id.btnCir);
        btnTri=(RadioButton)findViewById(R.id.btnTri);
        btnRec=(RadioButton)findViewById(R.id.btnRec);
        Lado.setVisibility(INVISIBLE);
        Radio.setVisibility(INVISIBLE);
        Base.setVisibility(INVISIBLE);
        Altura.setVisibility(INVISIBLE);
    }

    public void operButton(View v)
    {
      if (btnCuandro.isChecked()==true)
      {
            Lado.setVisibility(View.VISIBLE);
            Lado.setHint("Lado");
            Radio.setVisibility(View.INVISIBLE);
            Altura.setVisibility(View.INVISIBLE);
            Base.setVisibility(View.INVISIBLE);
      }
      else if (btnTri.isChecked()==true)
      {
            Base.setVisibility(View.VISIBLE);
            Altura.setVisibility(View.VISIBLE);
            Radio.setVisibility(View.INVISIBLE);
            Lado.setVisibility(View.INVISIBLE);
            Base.setHint("Base");
            Altura.setHint("Altura");
       }
      else if (btnRec.isChecked()==true)
      {
          Base.setVisibility(View.VISIBLE);
          Altura.setVisibility(View.VISIBLE);
          Radio.setVisibility(View.INVISIBLE);
          Lado.setVisibility(View.INVISIBLE);
          Base.setHint("Base");
          Altura.setHint("Altura");
      }
      else if (btnCir.isChecked()==true)
      {
            Radio.setVisibility(View.VISIBLE);
            Radio.setHint("Radio");
            Base.setVisibility(View.INVISIBLE);
            Altura.setVisibility(View.INVISIBLE);
            Lado.setVisibility(View.INVISIBLE);
      }
    }

    public void Operar(View v)
    {
        String valor1=Lado.getText().toString();
        String valor2=Radio.getText().toString();
        String valor3=Base.getText().toString();
        String valor4=Altura.getText().toString();

        if((btnCuandro.isChecked() == true && valor1.isEmpty())||
                (btnTri.isChecked() == true && (valor3.isEmpty()|| valor4.isEmpty()))||
                (btnRec.isChecked() == true && (valor3.isEmpty()|| valor4.isEmpty()))||
                (btnCir.isChecked() == true && valor2.isEmpty()))
        {
            Toast.makeText(getApplicationContext(),"Falta informacion",Toast.LENGTH_LONG).show();
            Res.setText("Falta Info");
        }
        else
        {
            if (btnCuandro.isChecked()==true)
            {
                double N1=Double.parseDouble(valor1);
                double Cuadro=N1*N1;
                String areaCuadro=String.valueOf(Cuadro);
                Res.setText(areaCuadro);

            }
            else if (btnTri.isChecked()==true)
            {
                double N3=Double.parseDouble(valor3);
                double N4=Double.parseDouble(valor4);
                double Tri=(N3*N4)/2;
                String areaTri=String.valueOf(Tri);
                Res.setText(areaTri);
            }
            else if (btnRec.isChecked()==true)
            {
                double N3=Double.parseDouble(valor3);
                double N4=Double.parseDouble(valor4);
                double ReTri=(N3*N4);
                String areaReTri=String.valueOf(ReTri);
                Res.setText(areaReTri);
            }
            else if (btnCir.isChecked()==true)
            {
                double N2=Double.parseDouble(valor2);
                double Cir = N2*N2*Math.PI;
                String resultado = Double.toString(Cir);
                Res.setText(resultado);
            }
        }
    }
}
