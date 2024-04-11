package ar.edu.unju.fi.ejercicio8.main;

import ar.edu.unju.fi.ejercicio8.model.CalculadoraEspecial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CalculadoraEspecial calculadora = new CalculadoraEspecial();

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un numero: ");
        Integer numero = sc.nextInt();
        calculadora.setN(numero);

        System.out.println("La sumatoria es: " + calculadora.calcularSumatoria());
        System.out.println("La productorua es: " + calculadora.calcularProductoria());

        sc.close();
    }
}
