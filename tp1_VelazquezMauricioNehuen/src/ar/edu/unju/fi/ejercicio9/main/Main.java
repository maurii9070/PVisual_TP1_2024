package ar.edu.unju.fi.ejercicio9.main;

import ar.edu.unju.fi.ejercicio9.model.Producto;

import java.util.Scanner;

public class Main {
    private static Scanner sc;

    public static Producto generarProducto(){
        Producto producto = new Producto();

        System.out.println("------------------------------------------------------------------");
        System.out.print("Ingrese nombre del producto: ");
        String nombre = sc.next();

        System.out.print("Ingrese codigo del producto: ");
        String codigo = sc.next();
        System.out.print("Ingrese precio del producto: ");
        float precio = sc.nextFloat();

        while (true){
            System.out.print("Ingrese descuento del producto[0,50]: ");
            int entrada = sc.nextInt();
            if (entrada >= 0 && entrada <= 50){
                Integer descuento = entrada;
                // Seteando el descuento
                producto.setDescuento(descuento);
                break;
            }
            System.out.println("El descuento debe estar entre 0% y 50%");
        }

        producto.setNombre(nombre);
        producto.setCodigo(codigo);
        producto.setPrecio(precio);

        return producto;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int cantidadProductos = 3;

        for (int i = 0; i < cantidadProductos; i++) {
            Producto producto = generarProducto();
            System.out.println("------------------------------------------------------------------");
            System.out.println(producto);
            System.out.println("Calculado descuento...");
            System.out.println("Producto: " + producto.getNombre() + " - Precio con Descuento: $" + producto.calcularDescuento());
        }

        sc.close();
    }
}
