package ar.edu.unju.fi.ejercicio7.main;

import ar.edu.unju.fi.ejercicio7.model.Empleado;

import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static Empleado generarEmpleado(){
        System.out.print("Ingrese nombre del empleado: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese legajo del empleado: ");
        String legajo = sc.nextLine();

        System.out.print("Ingrese el salario del empleado: ");
        Float salario = sc.nextFloat();

        return new Empleado(nombre, legajo, salario);
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        Empleado empleado = generarEmpleado();
        System.out.println("------------------------");
        System.out.println(empleado.mostrarDatos());

        System.out.println("Aumentando salario....");
        empleado.aumentarSalario();

        System.out.println("------------------------");
        System.out.println(empleado.mostrarDatos());

        sc.close();
    }
}
