package ar.edu.unju.fi.ejercicio18.main;

import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

import java.util.*;

public class Main {

    private static Scanner sc;
    private static List<Pais> paises;
    private static List<DestinoTuristico> destinosTuristicos;

    public static void main(String[] args) {
        paises = new ArrayList<>();
        destinosTuristicos = new ArrayList<>();

        sc = new Scanner(System.in);
        int opcion = 0;
        cargarPaises();
        do{
            try{
                opcion = menu();
                switch (opcion){
                    case 1:{ altaDestinoTuristico(); break; }
                    case 2:{ mostrarDestinosTuristicos(); break; }
                    case 3:{ modificarPaisDestinosTuristicos(); break; }
                    case 4:{ limpiarDestinosTuristicos(); break; }
                    case 5:{ eliminarDestinoTuristico(); break; }
                    case 6:{ mostrarDestinosOrdenadosNombre(); break; }
                    case 7:{ mostrarPaises(); break; }
                    case 8:{ mostrarDestinosDePais(); break; }
                    case 9:{ System.out.println("Adios."); break; }
                    default:{System.out.println("Elegir una opcion correcta.");}
                }
            }catch (InputMismatchException e){
                System.out.println("ERROR. Solo se permiten numeros como opciones");
                sc.nextLine();
            }
        } while (opcion != 9);
        sc.close();
    }

    /**
     * Metodo que se encarga de cargar Paises
     */
    public static void cargarPaises(){
        paises.add(new Pais("AR", "Argentina"));
        paises.add(new Pais("BR", "Brasil"));
        paises.add(new Pais("VE", "Venezuela"));
        paises.add(new Pais("CL", "Chile"));
        paises.add(new Pais("CO", "Colombia"));
        paises.add(new Pais("UY", "Uruguay"));
        paises.add(new Pais("PY", "Paraguay"));
        paises.add(new Pais("PE", "Peru"));
        paises.add(new Pais("EC", "Ecuador"));
        paises.add(new Pais("MX", "Mexico"));
        paises.add(new Pais("BO", "Bolivia"));
        paises.add(new Pais("PA", "Panama"));
    }

    /**
     * Muestra el menu y espera el ingreso de una opcion
     * @return Opcion ingresada
     */
    public static int menu(){
        System.out.println("----------------------- Menu -----------------------");
        System.out.println("1- Alta Destino turistico.");
        System.out.println("2- Mostrar destinos turisticos.");
        System.out.println("3- Modificar pais de un destino turistico.");
        System.out.println("4- Limpiar lista de destinos turisticos.");
        System.out.println("5- Eliminar un destino turistico.");
        System.out.println("6- Mostrar destinos turisticos ordenados(nombre).");
        System.out.println("7- Mostrar paises disponibles.");
        System.out.println("8- Mostrar los destinos turisticos de un pais.");
        System.out.println("9- Salir.");
        System.out.print("Elegir -> ");
        return sc.nextInt();
    }

    public static void altaDestinoTuristico(){
        String codigoDestinoTuristico, codigoPais, nombreCliente;
        double precioDestinoTuristico;
        Pais paisDestino;
        byte cantidadDias;

        // Definir codigo destino turistico

        codigoPais = getCodigoPais();
        codigoDestinoTuristico = codigoPais + "-" + (int)Math.floor(Math.random()*999);
        System.out.println("El codigo generado es: " + codigoDestinoTuristico);

        // Definir nombre destino turistico
        nombreCliente = ingresarString("Ingrese el nombre del cliente: ");

        // Definir precio destino turistico
        precioDestinoTuristico = ingresarPrecio();

        // Definir pais destino turistico
        paisDestino = buscarPais(codigoPais);

        // Definir cantidad de dias
        cantidadDias = ingresarCantidadDias();

        DestinoTuristico destinoTuristico = new DestinoTuristico(codigoDestinoTuristico, nombreCliente,
                precioDestinoTuristico, paisDestino, cantidadDias);

        System.out.println("###############################");
        System.out.println("# Destino generado con exito! #");
        System.out.println("###############################");
        destinosTuristicos.add(destinoTuristico);

    }

    /**
     * Lee un string ingresado por el usuario, verifica que solo sean letras
     * @param mensaje Mensaje que se imprime por pantalla solicitando un dato del jugador
     * @return codigo o nombre que ingresa el usuario
     */
    public static String ingresarString(String mensaje){
        String output;
        while(true) {
            System.out.print(mensaje);
            output = sc.next();
            if (output.matches("[a-zA-Z]+")) {
                break;
            } else {
                System.out.println("El dato ingresado no debe contener numeros");
            }
        }
        return output;
    }

    /**
     * Busca un codigo de pais en la lista generada
     * @return Codigo de pais o ""
     */
    public static String getCodigoPais(){
        String codigoPais;
        String codigoPaisEncontrado;
        Pais paisEncontrado;
        while (true) {
            System.out.println("[AR] Argentina | [BR] Brasil | [VE] Venezuela | [CL] Chile");
            System.out.println("[CO] Colombia | [UY] Uruguay | [PY] Paraguay | [PE] Peru");
            System.out.println("[EC] Ecuador | [MX] Mexico | [BO] Bolivia | [PA] Panama");
            codigoPais = ingresarString("Ingrese el codigo de pais: ").toUpperCase();
            if (codigoPais.length() == 2){
                paisEncontrado = buscarPais(codigoPais);
                if(paisEncontrado != null){
                    codigoPaisEncontrado = paisEncontrado.getCodigo();
                    break;
                } else{
                    System.out.println("El codigo de pais no se encuntra en la lista.");
                }
            } else {System.out.println("El codigo de pais debe contener 2 letras.");}
        }
        return codigoPaisEncontrado;
    }

    /**
     * Busca un pais por su codigo
     * @param codigo codigo de pais
     * @return Objeto Pais encontrado o null
     */
    public static Pais buscarPais(String codigo){
        Pais paisEncontrado = null;
        for (Pais pais : paises){
            if(pais.getCodigo().equals(codigo)){
                paisEncontrado = pais;
                break;
            }
        }
        return paisEncontrado;
    }

    /**
     * Lee el precio ingresado por el usuario
     * @return precio del Destino turistico
     */
    public static double ingresarPrecio(){
        double precio;
        while (true){
            try{
                System.out.print("Ingrese el precio del viaje: ");
                precio = sc.nextDouble();
                // Peso minimo 20kg, maximo 150kg
                if (precio >= 0){
                    break;
                } else {
                    System.out.println("El precio debe ser un numero positivo.");
                }
            } catch (InputMismatchException e){
                System.out.println("ERROR. El precio ingresado debe ser un numero tipo Double");
                sc.nextLine();
            }
        }
        return precio;
    }

    /**
     * Lee la cantidad de dias ingresados por el usuario
     * @return cantidad de dias
     */
    public static byte ingresarCantidadDias(){
        byte cantidadDias;
        while (true){
            try{
                System.out.print("Ingrese la cantidad de dias: ");
                cantidadDias = sc.nextByte();
                if (cantidadDias >= 0){
                    break;
                }else {
                    System.out.println("Los dias deben ser un numero positivo");
                }
            } catch (InputMismatchException e){
                System.out.println("ERROR. Los dias ingresados deben ser1 un numero entero.");
                sc.nextLine();
            }
        }
        return cantidadDias;
    }

    /**
     * Muestra todos los destinos turisticos
     */
    public static void mostrarDestinosTuristicos(){
        System.out.println("------------------------ Destinos Turisticos ------------------------");
        for (DestinoTuristico destinoTuristico : destinosTuristicos){
            System.out.println(destinoTuristico);
        }
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Metodo que modifica el pais de un destino turistico
     */
    public static void modificarPaisDestinosTuristicos(){
        mostrarDestinosTuristicos();
        System.out.print("Ingrese codigo de destino turistico a modificar: ");
        String codigoDestinoTuristico = sc.next().toUpperCase();
        for (DestinoTuristico destinoTuristico : destinosTuristicos){
            if(destinoTuristico.getCodigo().equals(codigoDestinoTuristico)){
                System.out.println("Ingrese codigo del nuevo pais destino.");
                String codigoPais = getCodigoPais();
                Pais paisEncontrado = buscarPais(codigoPais);
                // Generamos un nuevo codigo que tenga que ver con el nuevo pais seleccionado
                destinoTuristico.setCodigo(codigoPais + "-" + (int)Math.floor(Math.random()*999));
                System.out.println("-----------------------------------------------------");
                System.out.println("Nuevo codigo generado: " + destinoTuristico.getCodigo());
                // Cambiamos el pais
                destinoTuristico.setPais(paisEncontrado);
                System.out.println("Pais modificado correctamente.");
                break;
            }
        }
        System.out.println("No se encontro el destino turistico a modificar. Leer la lista");
    }

    /**
     * Metodo que limpia los destinos turisticos
     */
    public static void limpiarDestinosTuristicos(){
        destinosTuristicos.clear();
        System.out.println("#############################################");
        System.out.println("# Lista de destinos limpiada correctamente. #");
        System.out.println("#############################################");
    }

    /**
     * Metodo que elimina un destino turistico
     */
    public static void eliminarDestinoTuristico(){
        mostrarDestinosTuristicos();
        System.out.print("Ingrese codigo de destino turistico a eliminar: ");
        String codigoDestinoTuristico = sc.next().toUpperCase();

        Iterator<DestinoTuristico> iterator = destinosTuristicos.iterator();

        while (iterator.hasNext()){
            DestinoTuristico destinoTuristico = iterator.next();
            if(destinoTuristico.getCodigo().toUpperCase().equals(codigoDestinoTuristico)){
                iterator.remove();
                System.out.println("##################################################");
                System.out.println("# Se elimino el destino turistico correctamente. #");
                System.out.println("##################################################");
                break;
            }
        }
    }

    /**
     * Metodo que muestra los destinos turisticos ordenados por nombre
     */
    public static void mostrarDestinosOrdenadosNombre(){
        ArrayList<DestinoTuristico> destinosCopia = new ArrayList<>(destinosTuristicos);
        destinosCopia.sort(Comparator.comparing(destino -> destino.getNombre()));
        System.out.println("---------------------------------------------------------------------");
        destinosCopia.forEach(destino -> System.out.println(destino));
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Metodo que muestra los paises
     */
    public static void mostrarPaises(){
        System.out.println("---------- Paises ----------");
        paises.forEach(pais -> System.out.println(pais));
        System.out.println("----------------------------");
    }

    /**
     * Metodo que muestra los destinos turisticos
     * pertenecientes a un pais
     */
    public static void mostrarDestinosDePais(){
        String codigoPais = getCodigoPais().toUpperCase();
        System.out.println("---------- Destinos con codigo pais = " + codigoPais + " ----------");
        for (DestinoTuristico destinoTuristico : destinosTuristicos){
            if(destinoTuristico.getPais().getCodigo().equals(codigoPais)){
                System.out.println(destinoTuristico);
            }
        }
    }
}
