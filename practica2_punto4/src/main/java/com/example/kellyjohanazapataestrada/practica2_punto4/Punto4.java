package com.example.kellyjohanazapataestrada.practica2_punto4;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;

public class Punto4 extends AppCompatActivity {

    Calendar calendar;
    Button bAceptar1;
    Spinner spCiudades;
    EditText eNombre, eContraseña, eContraseña1, eCorreo;
    TextView Mostrar, tFecha;
    int year, month, day;
    String Ciudad,Sexo;
    RadioGroup Grupo;
    String Hobby1="";
    String Hobby2="";
    String Hobby3="";
    String Hobby4="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto4);

        //Objetos de loggin, para capturar informacion y luego mostrar
        eNombre = (EditText) findViewById(R.id.eNombre);
        eContraseña = (EditText) findViewById(R.id.eContraseña);
        eContraseña1 = (EditText) findViewById(R.id.eContraseña1);
        eCorreo = (EditText) findViewById(R.id.eCorreo);
        Mostrar = (TextView) findViewById(R.id.Mostrar);
        tFecha =(TextView) findViewById(R.id.tFecha);
        Grupo = (RadioGroup) findViewById(R.id.Grupo);

        //Objetos de Calendario, para el DatePicker
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //Funcion para mostrar la fecha en el boton
        showDate(year, month+1, day);

        //Objeto de Ciudades para Spinner
        spCiudades = (Spinner) findViewById(R.id.spCiudad);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Arreglo_ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCiudades.setAdapter(adapter);
        spCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        Ciudad="Medellin";
                        break;
                    case 1:
                        Ciudad="Bogotá";
                        break;
                    case 2:
                        Ciudad="Bucaramanga";
                        break;
                    case 3:
                        Ciudad="Cartagena";
                        break;
                    case 4:
                        Ciudad="Barranquilla";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Objeto del boton Aceptar para ver los datos ingresados
        bAceptar1 = (Button) findViewById(R.id.bAceptar);
        bAceptar1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int a=Grupo.getCheckedRadioButtonId();
                if (tFecha.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Falta fecha de cumpleaños", Toast.LENGTH_LONG).show();
                } else if (eNombre.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Falta el nombre", Toast.LENGTH_LONG).show();
                } else if (a==-1) {
                    Toast.makeText(getApplicationContext(), "Falta el género", Toast.LENGTH_LONG).show();
                } else if ((eContraseña.getText().toString()).equals(eContraseña1.getText().toString())!=true) {
                    Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                } else if (eContraseña.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Falta la contraseña", Toast.LENGTH_LONG).show();
                }else if (eContraseña1.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Falta confirmar contraseña", Toast.LENGTH_LONG).show();
                } else if (Hobby1.length() == 0 && Hobby2.length()==0 && Hobby3.length()==0 && Hobby4.length()==0) {
                    Toast.makeText(getApplicationContext(), "Falta ingresar algun Hobbie ", Toast.LENGTH_LONG).show();
                }else if (eCorreo.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Falta el correo electrónico", Toast.LENGTH_LONG).show();
                } else {
                    Mostrar.setText("Tu nombre es: "+String.valueOf(eNombre.getText())+"\n"+ "La contraseña es:"
                            +String.valueOf(eContraseña.getText())+ "\n"+"Tu correo es:"
                            +String.valueOf(eCorreo.getText())+"\n"+"Tu fecha de nacimiento es: "+String.valueOf(tFecha.getText())
                            +"\n"+"Tu lugar de nacimiento es:"+String.valueOf(Ciudad)+"\n"+"Tu género es:"+
                            String.valueOf(Sexo)+"\n"+"Tus Hobbies son:"+String.valueOf(Hobby1)+" "+String.valueOf(Hobby2)+" "+String.valueOf(Hobby3)+
                            " "+String.valueOf(Hobby4));
                    eNombre.setText("");
                    eContraseña.setText("");
                    eContraseña1.setText("");
                    eCorreo.setText("");

                }
            }
        });
    }
    //Funcion del RadioButton para género
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_femenino:
                if (checked) {
                    Sexo = "Femenino";
                }else{
                    Sexo = "";
                }
                break;
            case R.id.radio_masculino:
                if (checked) {
                    Sexo = "Masculino";
                }else{
                    Sexo="";
                }
                break;
        }
    }
    //Las siguientes son funciones para la fecha (DataPicker)
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "calendario", Toast.LENGTH_SHORT)
                .show();
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            showDate(arg1, arg2+1, arg3);
        }
    };

    //Funcion para ver la fecha en el boton y text Fecha
    private void showDate(int year, int month, int day) {
        tFecha.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    //Funcion para los Hobbies con Checkbox
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_leer:
                if (checked)
                    Hobby1 = "Leer";
                else Hobby1="";
                break;
            case R.id.checkbox_vertv:
                if (checked)
                    Hobby2 = "Ver Televisión";
                else Hobby2="";
                break;
            case R.id.checkbox_correr:
                if (checked)
                    Hobby3 = "Correr";
                else Hobby3="";
                break;
            case R.id.checkbox_bailar:
                if (checked)
                    Hobby4 = "Bailar";
                else Hobby4="";
                break;
        }
    }
}
