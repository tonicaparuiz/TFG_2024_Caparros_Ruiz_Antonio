package es.damdi.com.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class JuegosPOJO {
    private String titulo;
    private String descripcion;
    private String resumenJugado;
    private int horasJugadas;

    public JuegosPOJO(){}

    public JuegosPOJO(String titulo, String descripcion, String resumenJugado, int horasJugadas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.resumenJugado = resumenJugado;
        this.horasJugadas = horasJugadas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResumenJugado() {
        return resumenJugado;
    }

    public void setResumenJugado(String resumenJugado) {
        this.resumenJugado = resumenJugado;
    }

    public int getHorasJugadas() {
        return horasJugadas;
    }

    public void setHorasJugadas(int horasJugadas) {
        this.horasJugadas = horasJugadas;
    }
}
