package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingresar un numero estero: ");
		numero = scanner.nextInt();
		
		if (numero % 2 == 0) {
			int triple = numero * 3;
			System.out.println("El numero es par.");
			System.out.println("El triple del numero es: " + triple);
		} else {
			int doble = numero * 2;
			System.out.println("El numero es impar.");
			System.out.println("El doble del numero es: " + doble);
		}
		
		scanner.close();
	}

}
