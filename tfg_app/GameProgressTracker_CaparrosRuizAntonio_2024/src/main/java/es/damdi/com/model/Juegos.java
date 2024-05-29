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
     * @param titulo        the titulo
     * @param descripcion   the descripcion
     * @param resumenJUgado the resumen j ugado
     * @param horasJugadas  the horas jugadas
     */
    public Juegos(String titulo, String descripcion, String resumenJUgado, int horasJugadas) {
        this.titulo = new SimpleStringProperty(titulo);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.resumenJugado = new SimpleStringProperty(resumenJUgado);
        this.horasJugadas = new SimpleIntegerProperty(horasJugadas);
    }

    /**
     * Gets titulo.
     *
     * @return the titulo
     */
    public String getTitulo() {
        return titulo.get();
    }

    /**
     * Titulo property string property.
     *
     * @return the string property
     */
    public StringProperty tituloProperty() {
        return titulo;
    }

    /**
     * Sets titulo.
     *
     * @param titulo the titulo
     */
    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }

    /**
     * Gets descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion.get();
    }

    /**
     * Descripcion property string property.
     *
     * @return the string property
     */
    public StringProperty descripcionProperty() {
        return descripcion;
    }

    /**
     * Sets descripcion.
     *
     * @param descripcion the descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    /**
     * Gets resumen jugado.
     *
     * @return the resumen jugado
     */
    public String getResumenJugado() {
        return resumenJugado.get();
    }

    /**
     * Resumen jugado property string property.
     *
     * @return the string property
     */
    public StringProperty resumenJugadoProperty() {
        return resumenJugado;
    }

    /**
     * Sets resumen jugado.
     *
     * @param resumenJugado the resumen jugado
     */
    public void setResumenJugado(String resumenJugado) {
        this.resumenJugado.set(resumenJugado);
    }

    /**
     * Gets horas jugadas.
     *
     * @return the horas jugadas
     */
    public int getHorasJugadas() {
        return horasJugadas.get();
    }

    /**
     * Horas jugadas property integer property.
     *
     * @return the integer property
     */
    public IntegerProperty horasJugadasProperty() {
        return horasJugadas;
    }

    /**
     * Sets horas jugadas.
     *
     * @param horasJugadas the horas jugadas
     */
    public void setHorasJugadas(int horasJugadas) {
        this.horasJugadas.set(horasJugadas);
    }
}