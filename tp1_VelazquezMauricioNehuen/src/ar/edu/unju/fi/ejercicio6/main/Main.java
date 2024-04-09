package ar.edu.unju.fi.ejercicio6.main;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona;

public class Main {
	
	private static Scanner sc = null;
	
	public static Persona generarPersonaDefecto() {
		Persona persona = new Persona();
		
		System.out.print("Ingresar DNI: ");
		String dni = sc.next();
		
		System.out.print("Ingresar su Nombre: ");
		String nombre = sc.next();
		
		System.out.println("Fecha Nacimiento --> dd/m/AAAA");		
		System.out.print("Ingresar DIA: ");
		byte dia = sc.nextByte();
		
		System.out.print("Ingresar MES: ");
		byte mes = sc.nextByte();
		
		System.out.print("Ingresar Año: ");
		short anio = sc.nextShort();
		
		LocalDate nacimiento = LocalDate.of(anio, mes, dia);
		
		System.out.print("Provincia: ");
		String provincia = sc.next();
		
		persona.setDni(dni);
		persona.setNombre(nombre);
		persona.setFechaNacimiento(nacimiento);
		persona.setProvincia(provincia);
		
		return persona;
	}

	public static Persona generarPersonaParametrizado() {
		
		System.out.print("Ingresar DNI: ");
		String dni = sc.next();
		
		System.out.print("Ingresar su Nombre: ");
		String nombre = sc.next();
		
		System.out.println("Fecha Nacimiento --> dd/m/AAAA");		
		System.out.print("Ingresar DIA: ");
		byte dia = sc.nextByte();
		
		System.out.print("Ingresar MES: ");
		byte mes = sc.nextByte();
		
		System.out.print("Ingresar Año: ");
		short anio = sc.nextShort();
		
		LocalDate nacimiento = LocalDate.of(anio, mes, dia);
		
		System.out.print("Provincia: ");
		String provincia = sc.next();
		
		Persona persona = new Persona(dni, nombre, nacimiento, provincia);
		
		return persona;
	}
	
	public static Persona generarPersonaSinProvincia() {	

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ingresar DNI: ");
		String dni = sc.next();
		
		System.out.print("Ingresar su Nombre: ");
		String nombre = sc.next();
		
		System.out.println("Fecha Nacimiento --> dd/m/AAAA");		
		System.out.print("Ingresar DIA: ");
		byte dia = sc.nextByte();
		
		System.out.print("Ingresar MES: ");
		byte mes = sc.nextByte();
		
		System.out.print("Ingresar Año: ");
		short anio = sc.nextShort();
		
		LocalDate nacimiento = LocalDate.of(anio, mes, dia);

		
		Persona persona = new Persona(dni, nombre, nacimiento);
		
		sc.close();
		return persona;
	}
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		Persona persona1 = generarPersonaDefecto();
		System.out.println("-----------");
		Persona persona2 = generarPersonaParametrizado();
		System.out.println("-----------");
		Persona persona3 = generarPersonaSinProvincia();
		
		System.out.println(persona1);
		System.out.println(persona2);
		System.out.println(persona3);
		
		sc.close();
	}

}
