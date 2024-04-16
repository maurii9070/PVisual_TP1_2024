package ar.edu.unju.fi.ejercicio14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {

        int[] elementos;
        int cantidad;
        sc = new Scanner(System.in);

        while (true){
            try{
                System.out.print("\nIngrese un numero entre [3 - 10]: ");
                cantidad = sc.nextInt();
                if(cantidad >= 3 && cantidad <= 10){
                    elementos = new int[cantidad];
                    agregarElementos(elementos, cantidad);
                    break;
                } else {
                    System.out.println("Debe ingresar un numero entre [3 - 10]. ");
                }
            }catch (InputMismatchException e){
                System.err.println("Debe ingresar un numero entero. ");
                sc.nextLine();
            }
        }
        mostrarElementos(elementos);
        mostrarSuma(elementos);
        sc.close();
    }

    /**
     * Agrega n elementos a un Array
     * @param elementos arreglo de numeros enteros
     * @param cantidad la cantidad de elementos permitidos en el arreglo
     */
    public static void agregarElementos(int[] elementos, int cantidad){
        int i = 0 ;
        while(true){
            try{
                System.out.print("\nIngrese un numero entero: ");
                elementos[i] = sc.nextInt();
                i++;
                if(i == cantidad){break;}
            }catch (InputMismatchException e){
                System.err.println("Debe ingresar un numero entero. ");
                sc.nextLine();
            }
        }
    }

    /**
     * Muestra los elementos del arreglo con una salida de string formateada
     * Ejemplo. [1, 2, 3, 4]
     * @param elementos arreglo de numeros enteros
     */
    public static void mostrarElementos(int[] elementos){
        String output = "Elementos: [";
        for (int elemento : elementos) {
            output += elemento + ", ";
        }
        System.out.println(output.substring(0, output.length() - 2) + "]");
    }

    /**
     * Muestra la suma de todos los elementos que contiene el arreglo.
     * @param elementos arreglo de numeros enteros
     */
    public static void mostrarSuma(int[] elementos){
        int suma = 0;
        for (int elemento : elementos) {
            suma += elemento;
        }
        System.out.println("La suma de todos los elementos es: " + suma);
    }
}
