package ar.edu.unju.fi.ejercicio7.model;

/**
 * Clase que representa a un Empleado de X empresa
 * @author Velazquez, Mauricio Nehuen
 */
public class Empleado {
    private String nombre;
    private String legajo;
    private Float salario;

    private static final Float SALARIO_MINIMO = 210000.00F;
    private static final Float AUMENTO_POR_MERITOS = 20000.00F;

    /**
     *
     * @param nombre del empleado
     * @param legajo del empleado
     * @param salario del empleado
     */
    public Empleado(String nombre, String legajo, Float salario) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.salario = salario >= SALARIO_MINIMO ? salario : SALARIO_MINIMO;
    }

    /**
     *
     * @return String donde se muestran los datos del empleado
     */
    public String mostrarDatos() {
        return "Empleado {\n" +
                "\tNombre del empleado: " + nombre + '\n' +
                "\tLegajo: " + legajo + '\n' +
                "\tSalario: $" + salario + '\n' +
                '}';
    }

    /**
     * Aumenta el salario del empleado por meritos.
     */
    public void aumentarSalario(){
        salario += AUMENTO_POR_MERITOS;
    }
}
