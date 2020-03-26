package com.dawmi2.musicalquizmaterial;

public class Pregunta {
    int imagen;
    int opcionA;
    int opcionB;
    int opcionC;
    int respuesta;

    public Pregunta(int imagen, int opcionA, int opcionB, int opcionC, int respuesta) {
        this.imagen = imagen;
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.respuesta = respuesta;
    }

    public int getImagen() {
        return imagen;
    }

    public int getOpcionA() {
        return opcionA;
    }

    public int getOpcionB() {
        return opcionB;
    }

    public int getOpcionC() {
        return opcionC;
    }

    public int getRespuesta() {
        return respuesta;
    }
}
