package ar.edu.unju.fi.ejercicio12.model;

import java.util.Calendar;

/**
 * Esta clase representa a una Persona.
 * @author Velazquez Mauricio Nehuen
 */
public class Persona {
    private String nombre;
    private Calendar fechaNacimiento;

    public Persona() {}

    /**
     *
     * @param nombre valor que se le asigna al nombre de la Persona
     * @param fechaNacimiento fecha que se le asigna a la fecha de nacimiento de la Persona
     */
    public Persona(String nombre, Calendar fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }


    @Override
    public String toString() {
        int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
        int mes = fechaNacimiento.get(Calendar.MONTH) + 1;
        int anio = fechaNacimiento.get(Calendar.YEAR);
        return "Persona {" + '\n' +
                "\tNombre: " + nombre + '\n' +
                "\tFecha de Nacimiento: " + dia + "/" + mes + "/" + anio + '\n' +
                "\tEdad: " + getEdad() + '\n' +
                "\tSigno: " + getSignoZodiacal() + '\n' +
                "\tEstacion: " + getEstacion() + '\n' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return Integer que representa la edad de la Persona
     */
    public Integer getEdad(){
        Calendar hoy = Calendar.getInstance();
        int edad = 0;

        if(fechaNacimiento.get(Calendar.MONTH) < hoy.get(Calendar.MONTH)){
            edad = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        }
        if(fechaNacimiento.get(Calendar.MONTH) == hoy.get(Calendar.MONTH)){
            if(fechaNacimiento.get(Calendar.DATE) <= hoy.get(Calendar.DATE)){
                edad = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
            } else {
                edad = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR) - 1;
            }
        }
        if(fechaNacimiento.get(Calendar.MONTH) > hoy.get(Calendar.MONTH)){
            edad = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR) - 1;
        }

        return edad;
    }

    /**
     *
     * @return String que representa el signo zodiacal de la Persona
     */
    public String getSignoZodiacal(){
        String signo;
        int dia = fechaNacimiento.get(Calendar.DATE);
        int mes = fechaNacimiento.get(Calendar.MONTH);

        switch (mes) {
            case Calendar.JANUARY:
                if (dia <= 20) {
                    signo = "Capricornio";
                } else {
                    signo = "Acuario";
                }
                break;
            case Calendar.FEBRUARY:
                if (dia <= 19) {
                    signo = "Acuario";
                } else {
                    signo = "Piscis";
                }
                break;
            case Calendar.MARCH:
                if (dia <= 20) {
                    signo = "Piscis";
                } else {
                    signo = "Aries";
                }
                break;
            case Calendar.APRIL:
                if (dia <= 20) {
                    signo = "Aries";
                } else {
                    signo = "Tauro";
                }
                break;
            case Calendar.MAY:
                if (dia <= 20) {
                    signo = "Tauro";
                } else {
                    signo = "Géminis";
                }
                break;
            case Calendar.JUNE:
                if (dia <= 21) {
                    signo = "Géminis";
                } else {
                    signo = "Cáncer";
                }
                break;
            case Calendar.JULY:
                if (dia <= 22) {
                    signo = "Cáncer";
                } else {
                    signo = "Leo";
                }
                break;
            case Calendar.AUGUST:
                if (dia <= 22) {
                    signo = "Leo";
                } else {
                    signo = "Virgo";
                }
                break;
            case Calendar.SEPTEMBER:
                if (dia <= 22) {
                    signo = "Virgo";
                } else {
                    signo = "Libra";
                }
                break;
            case Calendar.OCTOBER:
                if (dia <= 22) {
                    signo = "Libra";
                } else {
                    signo = "Escorpio";
                }
                break;
            case Calendar.NOVEMBER:
                if (dia <= 21) {
                    signo = "Escorpio";
                } else {
                    signo = "Sagitario";
                }
                break;
            case Calendar.DECEMBER:
                if (dia <= 21) {
                    signo = "Sagitario";
                } else {
                    signo = "Capricornio";
                }
                break;
            default:
                signo = "Fecha inválida";
                break;
        }

        return signo;
    }

    /**
     *
     * @return String que representa la estacion del año en la que nacio la Persona
     */
    public String getEstacion(){
        String estacion;
        int dia = fechaNacimiento.get(Calendar.DATE);
        int mes = fechaNacimiento.get(Calendar.MONTH);

        switch (mes) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
                estacion = "Verano";
                break;
            case Calendar.MARCH:
                if (dia >= 21) {
                    estacion = "Otoño";
                } else {
                    estacion = "Verano";
                }
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
                estacion = "Otoño";
                break;
            case Calendar.JUNE:
                if (dia >= 21) {
                    estacion = "Invierno";
                } else {
                    estacion = "Otoño";
                }
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
                estacion = "Invierno";
                break;
            case Calendar.SEPTEMBER:
                if (dia >= 21) {
                    estacion = "Primavera";
                } else {
                    estacion = "Invierno";
                }
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
                estacion = "Primavera";
                break;
            case Calendar.DECEMBER:
                if (dia >= 21) {
                    estacion = "Verano";
                } else {
                    estacion = "Primavera";
                }
                break;
            default:
                estacion = "Fecha inválida";
                break;
        }

        return estacion;
    }
}
