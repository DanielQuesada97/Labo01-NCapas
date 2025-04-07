package org.example;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private double precio;
    private int ventasTotales;

    public Libro(int id, String titulo, String autor, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.ventasTotales = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(int ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    @Override
    public String toString() {
        return "Libro [ID: " + id +
                ", Título: " + titulo +
                ", Autor: " + autor +
                ", Precio: $" + precio +
                ", Ventas Totales: " + ventasTotales + "]";
    }


    public void actualizarVentas(int cantidadVendida) {
        this.ventasTotales += cantidadVendida;
    }
}