package ucu.edu.aed.tda;

public class Libro {
    private String titulo; 
    private String idLibro; // Asumimos que el id puede contener numeros y letras.
    private short cantidad; //Asumimos que en un short entra la cantidad de libros disponibles
    private double precio; //asumimos que el precio usa decimales.

    public Libro(String idLibro, String titulo, double precio, short cantidad) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public short getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void cambiarStock(short variacion) {
        if (this.cantidad + variacion >= 0) {
            this.cantidad += variacion;
        }
    }
}