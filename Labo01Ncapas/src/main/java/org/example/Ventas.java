import java.time.LocalDate;

public class Venta {
    private Libro libro;
    private int cantidadVendida;
    private LocalDate fechaVenta;

    // Constructor
    public Venta(Libro libro, int cantidadVendida, LocalDate fechaVenta) {
        this.libro = libro;
        this.cantidadVendida = cantidadVendida;
        this.fechaVenta = fechaVenta;

        // Actualizar las ventas totales del libro después de registrar la venta
        this.libro.actualizarVentas(cantidadVendida);
    }

    // Getters
    public Libro getLibro() {
        return libro;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    // Setters
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    // Método para registrar una venta
    public static Venta registrarVenta(Libro libro, int cantidadVendida) {
        return new Venta(libro, cantidadVendida, LocalDate.now());
    }

    // Método para mostrar los detalles de la venta
    public void mostrarDetalles() {
        System.out.println("Detalles de la venta:");
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("Cantidad vendida: " + cantidadVendida);
        System.out.println("Fecha de venta: " + fechaVenta);
        System.out.println("Precio total: $" + (libro.getPrecio() * cantidadVendida));
    }

    public String toShow() {
        return "Venta{" +
                "libro=" + libro.getTitulo() +
                ", cantidadVendida=" + cantidadVendida +
                ", fechaVenta=" + fechaVenta +
                ", precio total=$" + (libro.getPrecio() * cantidadVendida) +
                '}';
    }
}