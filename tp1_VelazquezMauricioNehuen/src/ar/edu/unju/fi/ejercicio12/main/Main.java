package ar.edu.unju.fi.ejercicio12.main;

import ar.edu.unju.fi.ejercicio12.model.Persona;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

    private static Scanner sc;

    public static Persona generarPersona(){
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Fecha de Nacimiento: dd/m/AAAA");
        System.out.print("Ingrese dia: ");
        int dia = sc.nextInt();
        System.out.print("Ingrese mes: ");
        int mes = sc.nextInt();
        System.out.print("Ingrese anio: ");
        int anio = sc.nextInt();

        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(anio, (mes - 1), dia);

        return new Persona(nombre, fechaNacimiento);
    }

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        Persona persona = generarPersona();
        System.out.println(persona);

        sc.close();
    }
}
