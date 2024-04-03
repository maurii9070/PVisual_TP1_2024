package ar.edu.unju.fi.ejercicio2;

public class Main {

	public static void main(String[] args) {
		String nombrePais;
		byte edad;
		int alturaEdificio;
		float precioProducto;
		String numeroTelefono;
		float calculoCos;
		
		nombrePais = "Argentina";
		edad = 27;
		// Altura en metros
		alturaEdificio = 30;
		precioProducto = (float)20.5;
		numeroTelefono = "388-123-4567";
		calculoCos = (float) 0.8775825618903;
		
		System.out.println("Nombre Pais: " + nombrePais);
		System.out.println("Edad: " + edad);
		System.out.println("Altura de edificio: " + alturaEdificio + "m.");
		System.out.println("Precio producto: $" + precioProducto );
		System.out.println("Numero Telefono: " + numeroTelefono);
		System.out.println("Cos(0.5): " + calculoCos);
	}

}
