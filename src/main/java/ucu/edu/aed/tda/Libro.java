package ucu.edu.aed.tda;

public class Libro {
    private String titulo; 
    private short idLibro; // Asumimos que en un numero de 16 bits se puede guardar el id de un libro
    private byte cantidad; // Asumimos que en 8 bits entran la cantidad de libros disponibles
    private short precio; // Asumimos que el precio esta en pesos uruguayos y no usa decimales.

    public Libro(short idLibro, String titulo, short precio, byte cantidad) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public short getCodigo() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public short getCantidad() {
        return cantidad;
    }

    public short getPrecio() {
        return precio;
    }

    public void cambiarStock(byte variacion) {
        if (this.cantidad + variacion >= 0) {
            this.cantidad += variacion;
        }
    }
}