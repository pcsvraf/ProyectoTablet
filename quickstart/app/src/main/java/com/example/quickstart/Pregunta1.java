package com.example.quickstart;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Pregunta1 extends AppCompatActivity {

    GuardarDatos datos;
    String seleccionado;
    TextView textView, textView2;
    TextView txt;

    TextView imagen1,imagen2,imagen3,imagen4,imagen5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);
        txt = (TextView)findViewById(R.id.textView);
        imagen1 = (TextView) findViewById(R.id.imagen1);
        imagen2 = (TextView) findViewById(R.id.imagen2);
        imagen3 = (TextView) findViewById(R.id.imagen3);
        imagen4 = (TextView) findViewById(R.id.imagen4);
        imagen5 = (TextView) findViewById(R.id.imagen5);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006064")));
        txt.setText(Html.fromHtml(getResources().getString(R.string.pregunta1)));

        //instanciación global
        datos = GuardarDatos.instancia;
        final ArrayList<String> opcion1 = datos.getOpciones();

        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen1.getText().toString();
                datos.getOpciones().add(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),Pregunta2.class);
                startActivity(myintent);
            }
        });

        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen2.getText().toString();
                datos.getOpciones().add(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),Pregunta2.class);
                startActivity(myintent);
            }
        });

        imagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen3.getText().toString();
                datos.getOpciones().add(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),Pregunta2.class);
                startActivity(myintent);
            }
        });

        imagen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen4.getText().toString();
                datos.getOpciones().add(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),Pregunta2.class);
                startActivity(myintent);
            }
        });

        imagen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen5.getText().toString();
                datos.getOpciones().add(seleccionado);
                Intent myintent = new Intent(getApplicationContext(),Pregunta2.class);
                startActivity(myintent);
            }
        });



        /*radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radioButton1){
                    seleccionado = radio1.getText().toString();
                }
                else if(i==R.id.radioButton2){
                    seleccionado = radio2.getText().toString();
                }
                else if(i==R.id.radioButton3){
                    seleccionado = radio3.getText().toString();
                }
                else if(i==R.id.RadioButton4){
                    seleccionado = radio4.getText().toString();
                }
                else if(i==R.id.RadioButton5){
                    seleccionado = radio5.getText().toString();
                }
            }
        });
*/



    }



}
