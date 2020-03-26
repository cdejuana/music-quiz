package com.dawmi2.musicalquizmaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button bt_puntuacion;
    private ImageView iv_portada;
    private ImageButton bt_adelante;
    private Button bt_respuestaA;
    private Button bt_respuestaB;
    private Button bt_respuestaC;
    private int puntuacion;
    private ArrayList<Pregunta> listaPreguntas = new ArrayList<>();
    private int indexLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_puntuacion = findViewById(R.id.bt_puntuacion);
        iv_portada = findViewById(R.id.iv_portadaDisco);
        bt_adelante = findViewById(R.id.ib_siguiente);
        bt_respuestaA = findViewById(R.id.bt_respuestaA);
        bt_respuestaB = findViewById(R.id.bt_respuestaB);
        bt_respuestaC = findViewById(R.id.bt_respuestaC);
        indexLista = 0;
        puntuacion = 10;

        listaPreguntas.add(new Pregunta(R.drawable.kraftwerk_machine, R.string.respuesta1A, R.string.respuesta1B, R.string.respuesta1C, 1));
        listaPreguntas.add(new Pregunta(R.drawable.delorean_muzik, R.string.respuesta2A, R.string.respuesta2B, R.string.respuesta2C, 2));
        listaPreguntas.add(new Pregunta(R.drawable.hercules, R.string.respuesta3A, R.string.respuesta3B, R.string.respuesta3C, 3));
        listaPreguntas.add(new Pregunta(R.drawable.orbital_2, R.string.respuesta4A, R.string.respuesta4B, R.string.respuesta4C, 4));

        bt_respuestaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexLista == 0 && listaPreguntas.get(indexLista).getRespuesta() == 1){
                    Toast.makeText(MainActivity.this, "¡CORRECTO!", Toast.LENGTH_SHORT).show();
                    puntuacion += 10;
                } else {
                    Toast.makeText(MainActivity.this, "¡INCORRECTO!", Toast.LENGTH_SHORT).show();
                    puntuacion -= 5;
                }
            }
        });

        bt_respuestaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexLista == 2 && listaPreguntas.get(indexLista).getRespuesta() == 3){
                    Toast.makeText(MainActivity.this, "¡CORRECTO!", Toast.LENGTH_SHORT).show();
                    puntuacion += 10;
                } else {
                    Toast.makeText(MainActivity.this, "¡INCORRECTO!", Toast.LENGTH_SHORT).show();
                    puntuacion -= 5;
                }
            }
        });

        bt_respuestaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexLista == 1 && listaPreguntas.get(indexLista).getRespuesta() == 2){
                    Toast.makeText(MainActivity.this, "¡CORRECTO!", Toast.LENGTH_SHORT).show();
                    puntuacion += 10;
                } else if (indexLista == 3 && listaPreguntas.get(indexLista).getRespuesta() == 4){
                    Toast.makeText(MainActivity.this, "¡CORRECTO!", Toast.LENGTH_SHORT).show();
                    puntuacion += 10;
                } else {
                    Toast.makeText(MainActivity.this, "¡INCORRECTO!", Toast.LENGTH_SHORT).show();
                    puntuacion -= 5;
                }
            }
        });

        bt_adelante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexLista < listaPreguntas.size()-1){
                    indexLista++;
                    cambiarPregunta();
                } else {
                    Toast.makeText(MainActivity.this, "Has llegado a la última pregunta", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_puntuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPuntuacion = new Intent(MainActivity.this, Puntuacion.class);
                intentPuntuacion.putExtra("PUNTUACION", puntuacion);
                startActivity(intentPuntuacion);
            }
        });

        iv_portada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.rtve.es/alacarta/audios/atmosfera/"));
                if (intentWeb.resolveActivity(getPackageManager()) != null){
                    startActivity(intentWeb);
                }
            }
        });

    }

    private void cambiarPregunta() {
        iv_portada.setImageResource(listaPreguntas.get(indexLista).getImagen());
        bt_respuestaA.setText(listaPreguntas.get(indexLista).getOpcionA());
        bt_respuestaB.setText(listaPreguntas.get(indexLista).getOpcionB());
        bt_respuestaC.setText(listaPreguntas.get(indexLista).getOpcionC());
    }
}
