/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.Date;

/**
 *
 * @author Jorge Lezcano, Moisés Avalos, Juan Acuña y Joel Garcete
 */
public class Registro {
    String nombreVacuna;
    int estado; //aplicada o no aplicada
    String fecha;
    int dosis;
    int edad;
    String lote;
    String responsable;
    String hijoId;
    int vacunaId;

    public Registro(String nombreVacuna, int estado, String fecha, int dosis, int edad, 
            String lote, String responsable, String hijoId) {
        this.nombreVacuna = nombreVacuna;
        this.estado = estado;
        this.fecha = fecha;
        
    }
    
    public Registro() {
        nombreVacuna = "";
        estado = 0;
        fecha = "";
        dosis = 0;
        edad = 0;
        lote = "";
        responsable = "";
        hijoId = "";
        vacunaId = 0;
    }

    public int getVacunaId() {
        return vacunaId;
    }

    public void setVacunaId(int vacunaId) {
        this.vacunaId = vacunaId;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getHijoId() {
        return hijoId;
    }

    public void setHijoId(String hijoId) {
        this.hijoId = hijoId;
    }
    
}
