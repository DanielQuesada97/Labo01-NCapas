package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    static Libreria libreria = new Libreria();

    public static void main(String[] args) {
        DataInitializer.inicializarDatosEjemplo(libreria);
        int opcion;

        do {
            showMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    verInventario();
                    break;
                case 3:
                    registrarVenta();
                    break;
                case 4:
                    verRegistroVentas();
                    break;
                case 5:
                    verLibroMasVendido();
                    break;
                case 6:
                    filtrarLibrosPorVentas();
                    break;
                case 7:
                    calcularTotalVentas();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpción inválida.");
            }

            if (opcion != 0) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n===== LIBRERÍA =====");
        System.out.println("1. Agregar libro al inventario");
        System.out.println("2. Ver inventario de libros");
        System.out.println("3. Registrar una venta");
        System.out.println("4. Ver registro de ventas");
        System.out.println("5. Ver libro más vendido");
        System.out.println("6. Filtrar libros por cantidad de ventas");
        System.out.println("7. Calcular total de ventas ($)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void agregarLibro() {
        System.out.println("\n=== AGREGAR NUEVO LIBRO ===");

        int nuevoId = libreria.getInventario().size() + 1;

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        double precio = 0;
        boolean precioValido = false;

        while (!precioValido) {
            try {
                System.out.print("Precio ($): ");
                precio = scanner.nextDouble();
                scanner.nextLine();

                if (precio <= 0) {
                    System.out.println("El precio debe ser mayor que cero. Intente de nuevo.");
                } else {
                    precioValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un valor numérico válido.");
                scanner.nextLine();
            }
        }

        Libro nuevoLibro = new Libro(nuevoId, titulo, autor, precio);
        libreria.agregarLibro(nuevoLibro);

        System.out.println("\nLibro agregado exitosamente:");
        System.out.println(nuevoLibro);
    }

    private static void verInventario() {
        List<Libro> inventario = libreria.getInventario();

        System.out.println("\nINVENTARIO DE LIBROS");

        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Libro libro : inventario) {
                System.out.println("ID: " + libro.getId());
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Precio: $" + libro.getPrecio());
                System.out.println("Ventas: " + libro.getVentasTotales());
                System.out.println();
            }
        }
    }

    private static void registrarVenta() {
        System.out.println("\n=== REGISTRAR VENTA ===");

        if (libreria.getInventario().isEmpty()) {
            System.out.println("No hay libros en el inventario. Agregue libros primero.");
            return;
        }

        System.out.println("\nLibros disponibles:");
        System.out.println("ID - TÍTULO - PRECIO");
        System.out.println("---------------------------");

        for (Libro libro : libreria.getInventario()) {
            System.out.println(libro.getId() + " - " + libro.getTitulo() + " - $" + libro.getPrecio());
        }

        int idLibro = 0;
        Libro libroSeleccionado = null;

        while (libroSeleccionado == null) {
            System.out.print("\nIngrese el ID del libro a vender: ");
            idLibro = scanner.nextInt();
            scanner.nextLine();

            libroSeleccionado = libreria.buscarLibroPorId(idLibro);

            if (libroSeleccionado == null) {
                System.out.println("ID de libro inválido. Intente de nuevo.");
            }
        }

        int cantidad = 0;
        boolean cantidadValida = false;

        while (!cantidadValida) {
            System.out.print("Ingrese la cantidad a vender: ");
            cantidad = scanner.nextInt();
            scanner.nextLine();

            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que cero. Intente de nuevo.");
            } else {
                cantidadValida = true;
            }
        }

        Venta nuevaVenta = libreria.registrarVenta(libroSeleccionado, cantidad);

        System.out.println("\nVenta registrada exitosamente:");
        nuevaVenta.mostrarDetalles();
    }

    private static void verRegistroVentas() {
        List<Venta> ventas = libreria.getRegistroVentas();

        System.out.println("\n=== REGISTRO DE VENTAS ===");

        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            for (int i = 0; i < ventas.size(); i++) {
                System.out.println("Venta #" + (i + 1));
                ventas.get(i).mostrarDetalles();
            }

            System.out.println("\nTotal de todas las ventas: $" + String.format("%.2f", libreria.calcularTotalVentas()));
        }
    }

    private static void verLibroMasVendido() {
        System.out.println("\n=== LIBRO MÁS VENDIDO ===");

        Libro masVendido = libreria.libroMasVendido();

        if (masVendido == null) {
            System.out.println("No hay libros en el inventario o no se han registrado ventas.");
        } else {
            if (masVendido.getVentasTotales() == 0) {
                System.out.println("Aún no se han registrado ventas para ningún libro.");
            } else {
                System.out.println(masVendido);
                System.out.println("Total de unidades vendidas: " + masVendido.getVentasTotales());
            }
        }
    }

    private static void filtrarLibrosPorVentas() {
        System.out.println("\n=== FILTRAR LIBROS POR VENTAS ===");

        int cantidadMinima = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Ingrese la cantidad mínima de ventas: ");
            cantidadMinima = scanner.nextInt();
            scanner.nextLine();

            if (cantidadMinima < 0) {
                System.out.println("La cantidad no puede ser negativa. Intente de nuevo.");
            } else {
                entradaValida = true;
            }
        }

        libreria.mostrarLibrosConVentasMayorA(cantidadMinima);
    }

    private static void calcularTotalVentas() {
        System.out.println("\n=== TOTAL DE VENTAS ($) ===");

        double total = libreria.calcularTotalVentas();

        if (libreria.getRegistroVentas().isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            System.out.println("El monto total de todas las ventas es: $" + String.format("%.2f", total));
        }
    }
}