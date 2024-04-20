package ar.edu.unju.fi.ejercicio17.model;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase que representa a un Jugador
 */
public class Jugador {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private Integer estatura;
    private Double peso;
    private String posicion;

    /**
     * Constructor por defecto
     */
    public Jugador() {}

    /**
     * Constructor parametrizado de la clase Jugador
     * @param nombre Nombre del jugador
     * @param apellido Apellido del jugador
     * @param fechaNacimiento Fecha de Nacimiento del Jugador
     * @param nacionalidad Nacionalidad del Jugador
     * @param estatura Estatura del jugador
     * @param peso Peso del jugador
     * @param posicion Posicion del jugador
     */
    public Jugador(String nombre, String apellido, LocalDate fechaNacimiento,
                   String nacionalidad, Integer estatura, Double peso, String posicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.estatura = estatura;
        this.peso = peso;
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Fecha de Nac=" + fechaNacimiento +
                ", Edad=" + calcularEdad() +
                ", Nacionalidad='" + nacionalidad + '\'' +
                ", Estatura=" + estatura +
                ", Peso=" + peso +
                ", Posicion='" + posicion + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getEstatura() {
        return estatura;
    }

    public void setEstatura(Integer estatura) {
        this.estatura = estatura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }


    /**
     * Metodo que calcula la edad del Jugador
     * @return Entero que representa la edad del jugador
     */
    public Integer calcularEdad(){
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fechaNacimiento, hoy);
        return edad.getYears();
    }
}
