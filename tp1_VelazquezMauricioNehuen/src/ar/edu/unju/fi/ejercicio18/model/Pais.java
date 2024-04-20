package ar.edu.unju.fi.ejercicio18.model;

/**
 * Clase que representa a un Pais
 */
public class Pais {
    private String codigo;
    private String nombre;

    /**
     * Constructor por defecto
     */
    public Pais() {}

    /**
     * Constructor de la clase Pais
     * @param codigo Codigo del pais
     * @param nombre Nombre del pais
     */
    public Pais(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
