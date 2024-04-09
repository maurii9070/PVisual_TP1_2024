package ar.edu.unju.fi.ejercicio6.model;


import java.time.LocalDate;
import java.time.Period;

public class Persona {
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String provincia;
	
	public Persona() {}

	public Persona(String dni, String nombre, LocalDate fechaNacimiento, String provincia) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = provincia;
	}

	public Persona(String dni, String nombre, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = "Jujuy";
	}

	@Override
	public String toString() {
		return "Persona {\n" +
					"\tdni: " + dni + "\n" +
					"\tnombre: " + nombre + "\n" +
					"\tfechaNacimiento: " + fechaNacimiento + "\n" +
					"\tprovincia: " + provincia + "\n" + 
					"\tedad: " + getEdad() + 
					(esMayor() 
							? "-->La persona es mayor de edad." 
							: "-->La persona es menor de edad.") + "\n" +
				"}";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public Integer getEdad() {
		LocalDate hoy = LocalDate.now();
		Period edad = Period.between(this.fechaNacimiento, hoy);
		return edad.getYears();
	}
	
	public Boolean esMayor() {
		return getEdad() >= 18 ? true : false ;
	}
		
}
