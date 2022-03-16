package com.example.proyectoindividual1;

import java.sql.Blob;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Libro {
    private String nombre;
    private String autor;
    private int paginas;
    private int actual;
    private String genero;
    private String fechaInicio;
    private String fechaFin;
    private String fechaPrevista;
    public Libro(String pNombre, String pAutor, int pPaginas, int pAct, String pGenero, String pfechaInit, String pfechaPrevista, String pfechaFin){
        this.actual = 0;
        this.nombre = pNombre;
        this.autor = pAutor;
        this.paginas = pPaginas;
        this.actual = pAct;
        this.genero = pGenero;
        this.fechaInicio = pfechaInit;
        this.fechaPrevista = pfechaPrevista;
        this.fechaFin = pfechaFin;
    }

    public int getActual() {
        return actual;
    }

    public int getPaginas() {
        return paginas;
    }
    public String getAutor(){
        return autor;
    }
    public String getNombre() {
        return nombre;
    }
    public String getGenero(){
        return genero;
    }
    public void actualizarPaginas(int pag){
        this.actual = pag;
    }
    public String getFechaInicio(){
        return fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public String getFechaPrevista(){
        return fechaPrevista;
    }
    public void setFechaFin() {
        Date date = (Date) Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String fech = dateFormat.format(date);
        this.fechaFin = fech;
    }
}
