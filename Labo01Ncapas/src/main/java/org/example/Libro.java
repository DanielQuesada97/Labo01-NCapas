package org.example;

public class Libro {
    private String id;
    private String titulo;
    private String autor;
    private String precio;
    private String ventasTotales;

    public Libro(String id, String titulo, String autor, String precio, String ventasTotales) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.ventasTotales = ventasTotales;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getPrecio() {
        return precio;
    }

    public String getVentasTotales() {
        return ventasTotales;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setVentasTotales(String ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", precio='" + precio + '\'' +
                ", ventasTotales='" + ventasTotales + '\'' +
                '}';
    }
}