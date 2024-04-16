package ar.edu.unju.fi.ejercicio13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arreglo = new int[8];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arreglo.length; i++) {
            try {
                System.out.print("Ingrese un numero entero: ");
                arreglo[i] = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error, el numero debe ser entero");
                sc.nextLine();
                break;
            }
        }
        mostrarElementos(arreglo);
        sc.close();
    }

    /**
     * Muestra los elementos del arreglo
     * @param arreglo arreglo de interos
     */
    public static void mostrarElementos(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(i+"-) " + arreglo[i]);
        }
    }
}
