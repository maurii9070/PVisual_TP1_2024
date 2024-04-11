package ar.edu.unju.fi.ejercicio9.model;

/**
 * Clase que representa a un Producto
 */
public class Producto {
    private String nombre;
    private String codigo;
    private Float precio;
    private Integer descuento;

    /**
     * Constructor por defecto
     */
    public Producto() {}

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", descuento=" + descuento +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    /**
     * Metodo que calcula el descuento del producto
     * @return Float que representa al precio con descuento
     */
    public Float calcularDescuento(){
        return precio = precio - (precio * descuento/100);
    }
}
