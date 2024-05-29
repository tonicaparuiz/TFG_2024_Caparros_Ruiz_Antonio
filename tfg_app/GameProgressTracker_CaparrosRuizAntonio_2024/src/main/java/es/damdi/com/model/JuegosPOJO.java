package es.damdi.com.model;

/**
 * Clase para el paso a JSON de los juegos
 *
 * @author Antonio Caparros Ruiz
 */

/**
 * The type Juegos pojo.
 */
public class JuegosPOJO {
    private String titulo;
    private String descripcion;
    private String resumenJugado;
    private int horasJugadas;

    /**
     * Instantiates a new Juegos pojo.
     */
    public JuegosPOJO(){}

    /**
     * Instantiates a new Juegos pojo.
     *
     * @param titulo        the titulo
     * @param descripcion   the descripcion
     * @param resumenJugado the resumen jugado
     * @param horasJugadas  the horas jugadas
     */
    public JuegosPOJO(String titulo, String descripcion, String resumenJugado, int horasJugadas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.resumenJugado = resumenJugado;
        this.horasJugadas = horasJugadas;
    }

    /**
     * Gets titulo.
     *
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets titulo.
     *
     * @param titulo the titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Gets descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets descripcion.
     *
     * @param descripcion the descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets resumen jugado.
     *
     * @return the resumen jugado
     */
    public String getResumenJugado() {
        return resumenJugado;
    }

    /**
     * Sets resumen jugado.
     *
     * @param resumenJugado the resumen jugado
     */
    public void setResumenJugado(String resumenJugado) {
        this.resumenJugado = resumenJugado;
    }

    /**
     * Gets horas jugadas.
     *
     * @return the horas jugadas
     */
    public int getHorasJugadas() {
        return horasJugadas;
    }

    /**
     * Sets horas jugadas.
     *
     * @param horasJugadas the horas jugadas
     */
    public void setHorasJugadas(int horasJugadas) {
        this.horasJugadas = horasJugadas;
    }
}
