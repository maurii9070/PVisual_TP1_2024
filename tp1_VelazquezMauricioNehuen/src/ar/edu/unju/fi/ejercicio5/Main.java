package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int numero;
		Boolean enRango = false;
		
		Scanner scanner = new Scanner(System.in);
		
		while (!enRango) {
			System.out.print("Ingrese un numero entero[1-9]: ");
			numero = scanner.nextInt();
			if (numero > 0 && numero <= 9) {
				System.out.println("La tabla del [" + numero + "] es.");
				for (int i = 0; i <= 10; i++) {
					int resultado = numero * i;
					System.out.println(numero + " x " + i + " = " + resultado);					
				}
				enRango = true;
			} else {
				System.out.println("El numero no está en el rango requerido.");
			}
		}

		scanner.close();
	}

}
