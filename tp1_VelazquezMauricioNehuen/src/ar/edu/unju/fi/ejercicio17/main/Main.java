package ar.edu.unju.fi.ejercicio17.main;

import ar.edu.unju.fi.ejercicio17.model.Jugador;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    private static Scanner sc;
    private static List<Jugador> jugadores;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        jugadores = new ArrayList<Jugador>();
        // Generamos jugadores para prueba del programa
        generarJugadores();
        int opc=0 ;
        while (opc != 8){
            try{
                opc = menu();
                switch (opc){
                    case 1:{ altaJugador(); break; }
                    case 2:{ mostrarJugadorPorNyA(); break; }
                    case 3:{ mostrarOrdenadosPorApellido(); break; }
                    case 4:{ modificarJugador(); break; }
                    case 5:{ eliminarJugador(); break; }
                    case 6:{ mostrarJugadores(); break;}
                    case 7:{ mostrarPorNacionalidad(); break; }
                    case 8:{System.out.println("Adios."); break;}
                    default:{System.out.println("Elegir una opcion correcta.");}
                }
            }catch (InputMismatchException e){
                System.out.println("ERROR. Ingrese un numero entero");
                sc.nextLine();
            }
        }
        sc.close();
    }

    /**
     * Menu de opciones
     * @return Entero que representa la opcion elegida
     */
    public static int menu(){
        int opc;
        System.out.println("----- Menu -----");
        System.out.println("1- Alta de jugador.");
        System.out.println("2- Mostrar datos de un jugador.");
        System.out.println("3- Mostrar jugadores ordenados por apellido.");
        System.out.println("4- Modificar datos de un jugador.");
        System.out.println("5- Eliminar un jugador.");
        System.out.println("6- Mostrar la cantidad de jugadores.");
        System.out.println("7- Mostrar cantidad de jugadores por Nacionalidad.");
        System.out.println("8- Salir.");
        System.out.print("Elegir -> ");
        opc = sc.nextInt();
        return opc;
    }

    /**
     * Metodo que da de alta a un jugador y lo agrega al arreglo de jugadores
     */
    public static void altaJugador(){
        String nombre, apellido, nacionalidad, posicion;
        LocalDate nacimiento;
        int estatura;
        double peso;

        // Nombre y Apellido
        nombre = ingresarString("Ingrese nombre del jugador: ");
        apellido = ingresarString("Ingrese apellido del jugador: ");
        // Fecha de nacimiento
        nacimiento = setFechadeNacimiento("Ingresar fecha de nacimiento. dd/mm/aaaa");
        // Nacionalidad
        nacionalidad = ingresarString("Ingrese la nacionalidad del jugador: ");
        // Estatura
        estatura = ingresarEstatura();
        // Peso
        peso = ingresarPeso();
        // Posicion
        posicion = ingresarPosicion();
        // Agregando jugador al arreglo de jugadores
        jugadores.add(new Jugador(nombre, apellido, nacimiento, nacionalidad, estatura, peso, posicion));
    }

    /**
     * Metodo que genera unos Jugadores para prueba del ejercicio
     */
    public static void generarJugadores(){
        jugadores.add(new Jugador("Leonidas", "Soza", LocalDate.of(2005,5,28),
                "Argentina", 160, 75.4, "Delantero"));
        jugadores.add(new Jugador("Facundo", "Alavar", LocalDate.of(1996,3,12),
                "Argentina", 180, 60.5, "Defensor"));
        jugadores.add(new Jugador("Mauro", "Chaile", LocalDate.of(1997,11,23),
                "Brasil", 177, 65.3, "Defensor"));
        jugadores.add(new Jugador("Ariel", "Martinez", LocalDate.of(1995,2,5),
                "Colombia", 160, 75.4, "Medio"));
        jugadores.add(new Jugador("Marcelo", "Robles", LocalDate.of(1996,8,8),
                "Ecuador", 180, 80.5, "Arquero"));
        jugadores.add(new Jugador("Marcos", "Quispe", LocalDate.of(2001,3,30),
                "Bolivia", 167, 81.4, "Delantero"));
        jugadores.add(new Jugador("Kevin", "Fernandez", LocalDate.of(1995,10,21),
                "Ecuador", 190, 75.2, "Defensor"));
        jugadores.add(new Jugador("Fabian", "Valdez", LocalDate.of(1997,4,1),
                "Uruguay", 160, 75.3, "Medio"));
        jugadores.add(new Jugador("Lautaro", "Granero", LocalDate.of(1996,8,10),
                "Uruguay", 180, 75.3, "Defensor"));
        jugadores.add(new Jugador("Rodrigo", "Blanco", LocalDate.of(2002,1,5),
                "Brasil", 175, 75.0, "Delantero"));
        jugadores.add(new Jugador("Juan", "Vazquez", LocalDate.of(1998,5,25),
                "Paraguay", 185, 85.0, "Medio"));
    }

    /**
     * Lee un String ingresado por el usuario
     * @param mensaje Mensaje que se imprime por pantalla solicitando un dato del jugador
     * @return String que representa la salida del scanner
     */
    public static String ingresarString(String mensaje){
        String output;
        while(true) {
            System.out.print(mensaje);
            output = sc.next();
            if (output.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("El nombre o apellido no debe contener numeros");
            }
        }
        return output;
    }

    /**
     * Ingresa una fecha de nacimiento escrita por el usuario
     * @param mensaje Mensaje que se imprime por pantalla solicitando la F. de Nacimiento
     * @return la fecha de nacimiento del jugador
     */
    public static LocalDate setFechadeNacimiento(String mensaje){
        int dia, mes, anio;
        LocalDate fecha;
        while (true) {
            try{
                System.out.println(mensaje);
                System.out.print("Ingrese el DIA: ");
                dia = sc.nextInt();
                System.out.print("Ingrese el MES: ");
                mes = sc.nextInt();
                while (true) {
                    System.out.print("Ingrese el Anio: ");
                    anio = sc.nextInt();
                    if(anio >= 1950 && anio <= 2017){
                        fecha = LocalDate.of(anio, mes, dia);
                        break;
                    } else {
                        System.out.println("El anio debe ser entre 1950 y 2017");
                    }
                }
                break;
            } catch (InputMismatchException e){
                System.out.println("ERROR. La dato ingresado debe ser un numero entero.");
                System.out.println();
                sc.nextLine();
            }catch(DateTimeException ex){
                System.out.println("ERROR. Dato mal ingresado, Dia[1-31] Mes[1-12] Anio[1980-2024].");
                System.out.println();
                sc.nextLine();
            }
        }
        return fecha;
    }

    /**
     * Lee la estatura ingresada por el usuario
     * @return Entero que representa a la estatura del jugador
     */
    public static int ingresarEstatura(){
        int estatura;
        while (true){
            try{
                System.out.print("Ingrese la estatura del jugador en cm: ");
                estatura = sc.nextInt();
                // Estatura minima 100cm, maxima 220cm
                if (estatura >= 100 && estatura <= 220){
                    break;
                }else {
                    System.out.println("La estatura debe rondar entre 100cm y 220cm");
                }
            } catch (InputMismatchException e){
                System.out.println("ERROR. La estatura ingresada debe ser un numero. Ej. 120cm");
                System.out.println();
                sc.nextLine();
            }
        }
        return estatura;
    }

    /**
     * Lee el peso ingresador por el usuario
     * @return double que representa el peso del jugador
     */
    public static double ingresarPeso(){
        double peso;
        while (true){
            try{
                System.out.print("Ingrese el peso del jugador: ");
                peso = sc.nextDouble();
                // Peso minimo 20kg, maximo 150kg
                if (peso >= 20.0 && peso <= 150.0){
                    break;
                } else {
                    System.out.println("El peso debe rondar entre 20.0kg y 150.0kg");
                }
            } catch (InputMismatchException e){
                System.out.println("ERROR. El peso ingresado debe ser un numero. Ej. 40,5");
                System.out.println();
                sc.nextLine();
            }
        }
        return peso;
    }

    /**
     * Lee desde un menu de opciones la posicion elegida por el usuario
     * @return String que representa la posicion del usuario
     */
    public static String ingresarPosicion(){
        String posicion="";
        while (true) {
            try{
                System.out.println("Elegir la posicion del jugador.");
                System.out.println("1- Delantero.");
                System.out.println("2- Medio.");
                System.out.println("3- Defensa.");
                System.out.println("4- Arquero.");
                System.out.print("Elegir -> ");
                int opc = sc.nextInt();
                switch (opc){
                    case 1: {posicion = "Delantero";break;}
                    case 2: {posicion = "Medio";break;}
                    case 3: {posicion = "Defensa";break;}
                    case 4: {posicion = "Arquero";break;}
                    default:{System.out.println("Elegir una opcion correcta.");}
                }
                break;
            } catch (InputMismatchException e){
                System.out.println("ERROR. La opcion ingresada debe ser un numero.");
                System.out.println();
                sc.nextLine();
            }
        }
        return posicion;
    }

    /**
     * Metodo que busca por nombre y apellido en el ArrayList de jugadores y
     * muestra por pantalla al jugador encontrado
     */
    public static void mostrarJugadorPorNyA(){
        String nombre, apellido;

        nombre = ingresarString("Ingrese nombre del jugador: ");
        apellido = ingresarString("Ingrese apellido del jugador: ");

        Jugador jugadorEncontrado = null;
        for(Jugador jugador : jugadores){
            if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)){
                jugadorEncontrado = jugador;
                break;
            }
        }
        if(jugadorEncontrado != null){
            System.out.println("------------------------------ Informacion del Jugador ------------------------------");
            System.out.println(jugadorEncontrado);
            System.out.println("-------------------------------------------------------------------------------------");
        } else{
            System.out.println("#########################################");
            System.out.println("# No se encontro el jugador solicitado. #");
            System.out.println("#########################################");
        }
    }

    /**
     * Metodo que muestra a todos los jugadores ordenados por Apellido
     * Antes de mostrar, crea una copia para no modificar el ArrayList original
     */
    public static void mostrarOrdenadosPorApellido(){
        // Creo una copia del ArrayList para no modificar el original
        ArrayList<Jugador> jugadoresCopia = new ArrayList<>(jugadores);
        jugadoresCopia.sort(Comparator.comparing(jugador -> jugador.getApellido()));
        jugadoresCopia.forEach(jugador -> System.out.println(jugador));
    }

    /**
     * Metodo que puede modificar cualquier dato del jugador
     */
    public static void modificarJugador(){
        String nombre, apellido;

        nombre = ingresarString("Ingrese nombre del jugador: ");
        apellido = ingresarString("Ingrese apellido del jugador: ");

        for(Jugador jugador : jugadores){
            if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)){
                int opc;
                do {
                    opc = menuModificar();
                    switch (opc){
                        case 1:
                            System.out.println("Modificar Nombre del jugador");
                            jugador.setNombre(ingresarString("Ingrese nuevo nombre del jugador: "));
                            System.out.println("### Se modifico el nombre del jugador correctamente ###");
                            opc=8;
                            break;
                        case 2:
                            System.out.println("Modificar Apellido del jugador");
                            jugador.setApellido(ingresarString("Ingrese nuevo apellido del jugador: "));
                            System.out.println("### Se modifico el apellido del jugador correctamente. ###");
                            opc=8;
                            break;
                        case 3:
                            System.out.println("Modificar Fecha de nacimiento..");
                            LocalDate fechaModificada = setFechadeNacimiento("Ingresar Nueva fecha de nacimiento. dd/mm/aaaa");
                            jugador.setFechaNacimiento(fechaModificada);
                            System.out.println("### Se modifico la fecha de nacimiento correctamente ###");
                            System.out.println(jugador);
                            opc = 8;
                            break;
                        case 4:
                            System.out.println("Modificar Nacionalidad del jugador");
                            jugador.setNacionalidad(ingresarString("Ingrese nueva nacionalidad: "));
                            System.out.println("### Se modifico la nacionalidad del jugador correctamente. ###");
                            opc=8;
                            break;
                        case 5:
                            System.out.println("Modificar Estatura del jugador");
                            jugador.setEstatura(ingresarEstatura());
                            System.out.println("### Se modifico la estatura del jugador correctamente. ###");
                            opc=8;
                            break;
                        case 6:
                            System.out.println("Modificar Peso del jugador");
                            jugador.setPeso(ingresarPeso());
                            System.out.println("### Se modifico el peso del jugador correctamente. ###");
                            opc=8;
                            break;
                        case 7:
                            System.out.println("Modificar Posicion del jugador");
                            jugador.setPosicion(ingresarPosicion());
                            System.out.println("### Se modifico la posicion del jugador correctamente. ####");
                            opc=8;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                }while (opc != 8);
                break;
            }
        }
        
    }

    /**
     * Menu de opciones para modificar jugador
     * @return Entero que representa la opcion elegida por el usuario
     */
    public static int menuModificar(){
        System.out.println("##### MENU DE MODIFICACION #####");
        System.out.println("1- Modificar Nombre.");
        System.out.println("2- Modificar Apellido.");
        System.out.println("3- Modificar Fecha de nacimiento.");
        System.out.println("4- Modificar Nacionalidad.");
        System.out.println("5- Modificar Estatura.");
        System.out.println("6- Modificar Peso.");
        System.out.println("7- Modificar Posicion.");
        System.out.println("8- Salir.");
        System.out.print("Elegir -> ");
        return sc.nextInt();
    }

    /**
     * Elimina un jugador del ArrayList de jugadores
     */
    public static void eliminarJugador(){
        String nombre, apellido;
        nombre = ingresarString("Ingrese nombre del jugador: ");
        apellido = ingresarString("Ingrese apellido del jugador: ");
        Iterator<Jugador> iterator = jugadores.iterator();

        while (iterator.hasNext()){
            Jugador jugador = iterator.next();
            if(jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)){
                iterator.remove();
                System.out.println("Se removio al Jugador " + apellido + " " + nombre);
                break;
            }
        }
    }

    /**
     * Metodo que muestra el total de jugadores
     */
    public static void mostrarJugadores(){
        System.out.println("### Lista Jugadores ###");
        jugadores.forEach(jugador -> System.out.println(jugador));
        System.out.println("Total: " + jugadores.size());
        System.out.println("#######################");
    }

    /**
     * Metodo que muestra jugadores por nacionalidad
     */
    public static void mostrarPorNacionalidad(){
        String nacionalidad = ingresarString("Ingrese nacionalidad: ");
        int contador = 0;

        System.out.println("### Jugadores con la nacionalidad " + nacionalidad + " ###");
        for(Jugador jugador : jugadores){
            if(jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)){
                System.out.println(jugador);
                contador++;
            }
        }
        System.out.println("Total: " + contador);
        System.out.println("#######################");
    }
}
