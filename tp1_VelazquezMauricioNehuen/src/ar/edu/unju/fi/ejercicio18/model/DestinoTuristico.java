package ar.edu.unju.fi.ejercicio18.model;

/**
 * Clase que representa a un Destino Turistico
 */
public class DestinoTuristico {
    private String codigo;
    private String nombre;
    private Double precio;
    private Pais pais;
    private Byte cantidadDias;

    public DestinoTuristico() {}

    /**
     * Constructor de la clase Destino Turistico
     * @param codigo Codigo del destinoTuristico
     * @param nombre Nombre del destinoTuristico
     * @param precio Precio del destinoTuristico
     * @param pais Pais del destinoTuristico
     * @param cantidadDias Cantidad de dias en el destinoTuristico
     */
    public DestinoTuristico(String codigo, String nombre, Double precio, Pais pais, Byte cantidadDias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.pais = pais;
        this.cantidadDias = cantidadDias;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Byte getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(Byte cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    @Override
    public String toString() {
        return "DestinoTuristico{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", pais=" + pais +
                ", cantidadDias=" + cantidadDias +
                '}';
    }
}
