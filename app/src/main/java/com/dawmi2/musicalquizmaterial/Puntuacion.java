package com.dawmi2.musicalquizmaterial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Puntuacion extends AppCompatActivity {

    private TextView text_puntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);

        text_puntuacion = findViewById(R.id.tv_puntuacion);

        Bundle infoExtra = getIntent().getExtras();
        int puntuacion = infoExtra.getInt("PUNTUACION");
        //text_puntuacion.setText(String.valueOf(puntuacion));
        text_puntuacion.setText(Integer.toString(puntuacion));
    }
}
