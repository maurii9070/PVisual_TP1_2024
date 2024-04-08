package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int numero;
		int i = 1;
		Scanner scanner =  new Scanner(System.in);
		
		System.out.print("Ingrese un numero entero[1-10]: ");
		numero = scanner.nextInt();
		
		if (numero <= 10 && numero > 0) {
			System.out.println("Calculando factorial de " + numero);
			int factorial = numero;
			while (i < numero) {
				factorial = factorial * (numero - i);
				i++;			
			}
			System.out.println("El factorial de "+ numero + " es: "  + factorial);
		} else {
			System.out.println("El numero ingresado no está entre 1 y 10");
		}	
		
		
		scanner.close();

	}

}
