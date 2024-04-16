package ar.edu.unju.fi.ejercicio16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner sc ;
    public static void main(String[] args) {
        sc = new Scanner(System.in);

        String[] nombres = new String[5];

        insertarNombres(nombres);
        mostrarNombres(nombres);
        System.out.println("----------------------");
        System.out.println("Cantidad de elementos. "+nombres.length);

        while(true){
            try{
                System.out.print("Ingrese una posicion a eliminar [0,4]: ");
                byte pos = sc.nextByte();
                if(pos >= 0 && pos < nombres.length) {
                    eliminarNombre(nombres, pos);
                    break;
                }else {
                    System.err.println("La posicion no existe");
                }
            }catch (InputMismatchException ex) {
                System.out.println("Debe ingresar un numero entero(byte)");
                sc.nextLine();
            }finally {
                System.out.println("---- Nombres Modificados ----");
                mostrarNombres(nombres);
            }
        }
        sc.close();
    }

    /**
     * Inserta los nombres al arreglo, verificando que lo ingresado no contenga numeros
     * y contenga mas de 3 letras
     * @param nombres arreglo de nombres
     */
    public static void insertarNombres(String[] nombres){
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingresar un nombre: ");
            String nombre = sc.next();
            nombres[i] = nombre;
        }
    }

    /**
     * Muestra los nombres almacenados en el arreglo
     * @param nombres arreglo de nombres
     */
    public static void mostrarNombres(String[] nombres){
        int i = 0;

        System.out.println("----- Nombres -----");
        while(i != nombres.length){
            System.out.println("["+i+"] " + nombres[i]);
            i++;
        }
    }

    /**
     * Elimina un elemento del arreglo dando una posicion
     * @param nombres arreglo de nombres
     * @param pos posicion a eliminar
     */
    public static void eliminarNombre(String[] nombres, byte pos){
        for (int i = 0; i < nombres.length; i++) {
            if(i >= pos && i < nombres.length - 1){
                nombres[i] = nombres[i + 1];
            }
        }
        nombres[nombres.length - 1] = "";
    }
}
