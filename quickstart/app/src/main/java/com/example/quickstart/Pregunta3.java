package com.example.quickstart;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pregunta3 extends AppCompatActivity {
    TextView textView;
    Button boton;
    PrincipalActivity tiempo;
    GuardarDatos datos;
    String seleccionado;
    TextView imagen1,imagen2,imagen3,imagen4,imagen5,txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta3);
        boton = (Button) findViewById(R.id.BTNsiguiente4);
        tiempo = PrincipalActivity.intancia;
        datos = GuardarDatos.instancia;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006064")));
        final ArrayList<String> opciones = datos.getOpciones3();
        imagen1 = (TextView) findViewById(R.id.imagen1);
        imagen2 = (TextView) findViewById(R.id.imagen2);
        imagen3 = (TextView) findViewById(R.id.imagen3);
        imagen4 = (TextView) findViewById(R.id.imagen4);
        imagen5 = (TextView) findViewById(R.id.imagen5);
        txt = (TextView) findViewById(R.id.textView3);
        txt.setText(Html.fromHtml(getResources().getString(R.string.pregunta3)));
        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen1.getText().toString();
                datos.getOpciones3().add(seleccionado);
                datos.getOpciones4().clear();
                Intent intet = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intet);
            }
        });

        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones4().clear();
                seleccionado = imagen2.getText().toString();
                datos.getOpciones3().add(seleccionado);
                Intent intet = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intet);
            }
        });

        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones4().clear();
                seleccionado = imagen2.getText().toString();
                datos.getOpciones3().add(seleccionado);
                Intent intet = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intet);
            }
        });

        imagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones4().clear();
                seleccionado = imagen3.getText().toString();
                datos.getOpciones3().add(seleccionado);
                Intent intet = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intet);
            }
        });

        imagen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones4().clear();
                seleccionado = imagen4.getText().toString();
                datos.getOpciones3().add(seleccionado);
                Intent intet = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intet);
            }
        });

        imagen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones4().clear();
                seleccionado = imagen5.getText().toString();
                datos.getOpciones3().add(seleccionado);
                Intent intet = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intet);
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones3().clear();
                Intent myintent = new Intent(getApplicationContext(),Pregunta2.class);
                startActivity(myintent);
            }
        });



        /*radioGroup = (RadioGroup) findViewById(R.id.radioGroup3);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radioButton11){
                    seleccionado = radio1.getText().toString();
                }
                  else if(i==R.id.radioButton12){
                    seleccionado = radio2.getText().toString();
                }
                    else if(i==R.id.radioButton13){
                      seleccionado = radio3.getText().toString();
                }
                      else if(i==R.id.radioButton14){
                        seleccionado = radio4.getText().toString();
                }
                         else if(i==R.id.radioButton15){
                          seleccionado = radio5.getText().toString();
                }
            }
        });
*/

        /*
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if(seleccionado != null){
                    Intent myintento = new Intent(Pregunta3.this, MainActivity.class);
                    startActivity(myintento);
                    opciones.add(seleccionado);
                }
                else {
                     Toast.makeText(Pregunta3.this,"Porfavor, seleccione una respuesta!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    /*CountDownTimer timerDown = new CountDownTimer(30000, 10) {
        @Override
        public void onTick(long l) {
            textView.setText("este es el tiempo: " + l);
        }

        @Override
        public void onFinish() {
            Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage( getBaseContext().getPackageName() );
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
    }.start();
    */
    }
}




