package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Libreria {
    private List<Libro> inventario;
    private List<Venta> registroVentas;

    public Libreria() {
        this.inventario = new ArrayList<>();
        this.registroVentas = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        inventario.add(libro);
    }

    public void registrarVenta(Venta venta) {
        registroVentas.add(venta);
    }

    public Venta registrarVenta(Libro libro, int cantidad) {
        Venta nuevaVenta = new Venta(libro, cantidad);
        registroVentas.add(nuevaVenta);
        return nuevaVenta;
    }

    public Libro libroMasVendido() {
        if (inventario.isEmpty()) {
            return null;
        }

        Optional<Libro> libroMasVendido = inventario.stream()
                .max(Comparator.comparing(Libro::getVentasTotales));

        return libroMasVendido.orElse(null);
    }

    public List<Libro> librosConVentasMayorA(int cantidadMinima) {
        return inventario.stream()
                .filter(libro -> libro.getVentasTotales() > cantidadMinima)
                .collect(Collectors.toList());
    }

    public void mostrarLibrosConVentasMayorA(int cantidadMinima) {
        List<Libro> librosConVentasAltas = librosConVentasMayorA(cantidadMinima);

        System.out.println("==== Libros con más de " + cantidadMinima + " ventas ====");
        if (librosConVentasAltas.isEmpty()) {
            System.out.println("No hay libros que superen " + cantidadMinima + " ventas.");
        } else {
            librosConVentasAltas.forEach(System.out::println);
        }
        System.out.println("======================================");
    }

    public List<Libro> getInventario() {
        return inventario;
    }

    public List<Venta> getRegistroVentas() {
        return registroVentas;
    }

    public Libro buscarLibroPorId(int id) {
        return inventario.stream()
                .filter(libro -> libro.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public double calcularTotalVentas() {
        return registroVentas.stream()
                .mapToDouble(Venta::calcularMontoTotal)
                .sum();
    }
}