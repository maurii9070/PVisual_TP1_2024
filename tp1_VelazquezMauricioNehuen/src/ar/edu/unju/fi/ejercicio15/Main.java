package ar.edu.unju.fi.ejercicio15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {
        String[] nombres;
        sc = new Scanner(System.in);

        nombres = new String[setCantidad()];
        insertarNombres(nombres);
        mostrarNombres(nombres);
        mostrarNombresReversa(nombres);
        sc.close();
    }

    /**
     * Define la cantidad de elementos que puede tener el arreglo
     * @return Entero que representa la cantidad de elementos del arreglo
     */
    public static int setCantidad(){
        int cantidad = 0;
        while (true){
            try{
                System.out.print("Ingrese tamanio del arreglo[5, 10]: ");
                cantidad = sc.nextInt();
                if(cantidad >= 5 && cantidad <= 10){break;}
            }catch(InputMismatchException e){
                System.err.println("Error" + e.getMessage());
            }
        }
       return cantidad;
    }

    /**
     * Inserta los nombres al arreglo, verificando que lo ingresado no contenga numeros
     * y contenga mas de 3 letras
     * @param nombres arreglo de nombres
     */
    public static void insertarNombres(String[] nombres){
        String nombre;
        int i = 0;
        while (i != nombres.length) {
            System.out.print("\nIngresar un nombre: ");
            nombre = sc.next();
            if (nombre.matches("[a-zA-Z]+") && nombre.length() >= 3) {
                nombres[i] = nombre;
                i++;
            } else {
                System.err.println("Los nombres no deben contener numeros");
            }
        }
    }

    /**
     * Muestra los nombres que hay en el arreglo
     * @param nombres arreglo de nombres
     */
    public static void mostrarNombres(String[] nombres){
        int i = 0;
        System.out.println("----- Nombres -----");
        for (String nombre : nombres) {
            System.out.println("["+i+"] " + nombre);
            i++;
        }
    }

    /**
     * Muestra en reversa los nombres que hay en el arreglo
     * @param nombres arreglo de nombres
     */
    public static void mostrarNombresReversa(String[] nombres){
        System.out.println("----- Nombres(Reversa) -----");
        for(int i = (nombres.length - 1); i >= 0; i--){
            System.out.println("["+i+"] " + nombres[i]);
        }
    }
}
