package es.damdi.com.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Clase modelo para juegos.
 *
 * @author Antonio Caparros Ruiz
 */
public class Juegos {

    private final StringProperty titulo;
    private final StringProperty descripcion;
    private final StringProperty resumenJugado;
    private final IntegerProperty horasJugadas;

    /**
     * Constructor default
     */
    public Juegos() {
        this(null, null,null,0);
    }

    /**
     * Constructos con datos
     *
     * @param titulo
     * @param descripcion
     * @param resumenJUgado
     * @param horasJugadas
     */
    public Juegos(String titulo, String descripcion, String resumenJUgado, int horasJugadas) {
        this.titulo = new SimpleStringProperty(titulo);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.resumenJugado = new SimpleStringProperty(resumenJUgado);
        this.horasJugadas = new SimpleIntegerProperty(horasJugadas);
    }

    public String getTitulo() {
        return titulo.get();
    }

    public StringProperty tituloProperty() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public String getResumenJugado() {
        return resumenJugado.get();
    }

    public StringProperty resumenJugadoProperty() {
        return resumenJugado;
    }

    public void setResumenJugado(String resumenJugado) {
        this.resumenJugado.set(resumenJugado);
    }

    public int getHorasJugadas() {
        return horasJugadas.get();
    }

    public IntegerProperty horasJugadasProperty() {
        return horasJugadas;
    }

    public void setHorasJugadas(int horasJugadas) {
        this.horasJugadas.set(horasJugadas);
    }
}