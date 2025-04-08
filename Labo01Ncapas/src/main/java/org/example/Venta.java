package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Venta {
    private Libro libro;
    private int cantidadVendida;
    private LocalDateTime fechaVenta;

    public Venta(Libro libro, int cantidadVendida) {
        this.libro = libro;
        this.cantidadVendida = cantidadVendida;
        this.fechaVenta = LocalDateTime.now(); // Se registra la fecha actual

        // Actualizar las estadísticas de venta del libro
        libro.actualizarVentas(cantidadVendida);
    }

    public Venta(Libro libro, int cantidadVendida, LocalDateTime fechaVenta) {
        this.libro = libro;
        this.cantidadVendida = cantidadVendida;
        this.fechaVenta = fechaVenta;

        // Actualizar las estadísticas de venta del libro
        libro.actualizarVentas(cantidadVendida);
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double calcularMontoTotal() {
        return libro.getPrecio() * cantidadVendida;
    }

    public void mostrarDetalles() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("=== Detalles de la Venta ===");
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("Cantidad: " + cantidadVendida + " unidades");
        System.out.println("Precio: $" + libro.getPrecio());
        System.out.println("Total: $" + calcularMontoTotal());
        System.out.println("Fecha: " + fechaVenta.format(formatter));
        System.out.println("============================");
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Venta [Libro: " + libro.getTitulo() +
                ", Cantidad: " + cantidadVendida +
                ", Fecha: " + fechaVenta.format(formatter) +
                ", Total: $" + calcularMontoTotal() + "]";
    }
}