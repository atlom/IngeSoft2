package com.example.atlom.inge2lab.registro;


/**
 * Clase Registro vacuna, getters y setters
 */

public class RegistroVacuna {
    private int id_vacuna;
    private String nombre;
    private int dosis;
    private int edad;
    private String fecha;
    private String lote;
    private String nombre_medico;
    private String descripcion;
    private String id_hijo;
    private int aplicada;

    public RegistroVacuna(int id_vacuna, String nombre, int dosis, int edad, String fecha, String lote,
                          String nombre_medico, String descripcion, String id_hijo, int aplicada) {
        this.id_vacuna = id_vacuna;
        this.nombre = nombre;
        this.dosis = dosis;
        this.edad = edad;
        this.fecha = fecha;
        this.lote = lote;
        this.nombre_medico = nombre_medico;
        this.descripcion = descripcion;
        this.id_hijo = id_hijo;
        this.aplicada=aplicada;
    }

    public RegistroVacuna(){
        id_vacuna = 0;
        nombre = "";
        dosis = 0;
        edad = 0;
        fecha = "";
        lote = "";
        nombre_medico = "";
        descripcion = "";
        id_hijo = "";
        aplicada = 0;
    }



    public String getId_hijo() {
        return id_hijo;
    }

    public void setId_hijo(String id_hijo) {
        this.id_hijo = id_hijo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFecha() {

        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDosis() {
        return dosis;

    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAplicada() {
        return aplicada;
    }

    public void setAplicada(int aplicada) {
        this.aplicada = aplicada;
    }

    public int getId_vacuna() {
        return id_vacuna;

    }

    public void setId_vacuna(int id_vacuna) {
        this.id_vacuna = id_vacuna;
    }

}
