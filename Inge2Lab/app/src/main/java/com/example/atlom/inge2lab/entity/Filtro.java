package com.example.atlom.inge2lab.entity;

/**
 * Created by atlom on 31/10/17.
 */

public class Filtro {
    private int posicion;
    private String nombre;

    @Override
    public String toString() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
