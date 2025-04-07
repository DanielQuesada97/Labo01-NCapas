package org.example;

public class DataInitializer {

    public static void inicializarDatosEjemplo(Libreria libreria) {
        // agregar libros al inventario
        Libro libro1 = new Libro(1, "Dune", "Frank Herbert", 19.99);
        Libro libro2 = new Libro(2, "Foundation", "Isaac Asimov", 17.50);
        Libro libro3 = new Libro(3, "Neuromancer", "William Gibson", 16.95);
        Libro libro4 = new Libro(4, "The Name of the Wind", "Patrick Rothfuss", 21.00);
        Libro libro5 = new Libro(5, "The Wheel of Time", "Robert Jordan", 23.45);
        Libro libro6 = new Libro(6, "A Song of Ice and Fire", "George R.R. Martin", 24.30);
        Libro libro7 = new Libro(7, "Snow Crash", "Neal Stephenson", 18.20);
        Libro libro8 = new Libro(8, "Hyperion", "Dan Simmons", 20.99);
        Libro libro9 = new Libro(9, "The Stormlight Archive", "Brandon Sanderson", 25.80);
        Libro libro10 = new Libro(10, "The Three-Body Problem", "Liu Cixin", 19.75);

        libreria.agregarLibro(libro1);
        libreria.agregarLibro(libro2);
        libreria.agregarLibro(libro3);
        libreria.agregarLibro(libro4);
        libreria.agregarLibro(libro5);
        libreria.agregarLibro(libro6);
        libreria.agregarLibro(libro7);
        libreria.agregarLibro(libro8);
        libreria.agregarLibro(libro9);
        libreria.agregarLibro(libro10);

        // Registrar ventas
        libreria.registrarVenta(libro1, 123);
        libreria.registrarVenta(libro2, 32);
        libreria.registrarVenta(libro3, 32);
        libreria.registrarVenta(libro4, 33);
        libreria.registrarVenta(libro5, 36);
        libreria.registrarVenta(libro6, 124);
        libreria.registrarVenta(libro7, 37);
        libreria.registrarVenta(libro8, 83);
        libreria.registrarVenta(libro9, 39);
        libreria.registrarVenta(libro10, 30);

    }


}