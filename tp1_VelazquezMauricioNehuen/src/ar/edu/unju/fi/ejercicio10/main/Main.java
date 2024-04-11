package ar.edu.unju.fi.ejercicio10.main;

import ar.edu.unju.fi.ejercicio10.model.Pizza;

import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static Pizza generarPizza(){
        Pizza pizza = new Pizza();

        while(true){
            System.out.println("Diametros disponibles: 20 - 30 - 40");
            System.out.print("Ingrese el diametro de la pizza: ");
            int diametro = sc.nextInt();
            if(diametro == 20 || diametro == 30 || diametro == 40){
                pizza.setDiametro(diametro);
                break;
            }
            System.out.println("Ingrese el diametro correspondiente");
        }

        while(true){
            System.out.print("Agregar Ingredientes especiales? [s]i/[n]o: ");
            char respuesta = sc.next().charAt(0);
            if(respuesta == 's' || respuesta == 'S' ){
                pizza.setIngredientesEspeciales(true);
                break;
            } else if(respuesta == 'n' || respuesta == 'N'){
                pizza.setIngredientesEspeciales(false);
                break;
            } else {
                System.out.println("Ingrese una respuesta correcta. S/s o N/n");
            }
        }

        return pizza;
    }
    public static void main(String[] args) {
        int catidadPizzas = 3;
        sc = new Scanner(System.in);

        for(int i = 0; i < catidadPizzas; i++){
            Pizza pizza = generarPizza();
            pizza.calcularPrecio();
            pizza.calcularArea();

            System.out.println("--------------------------------------");
            System.out.println("** Pizza " + (i+1) + " **");
            System.out.println(pizza);
            System.out.println("--------------------------------------");
        }

        sc.close();
    }
}
