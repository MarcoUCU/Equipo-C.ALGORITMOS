package main.java.ucu.edu.aed.tda;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        procesarAdquisiciones(biblioteca); //metodos para agarrar los datos de los .txt. Se hacen en main y no en la biblioteca para no romper SRP.
        procesarPrestamos(biblioteca);

        biblioteca.listarLibros(); //Se listan los libros al finalizar los metodos anteriores
    }

    private static void procesarAdquisiciones(Biblioteca biblioteca) { //metodo para procesar adquisiciones desde el .txt. 
        try {
            InputStream is = Main.class.getResourceAsStream("/adquisiciones.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(","); //separa por comas 

                short codigo = Short.parseShort(partes[0].trim());
                String titulo = partes[1].trim();
                short precio = Short.parseShort(partes[2].trim());
                short cantidad = Short.parseShort(partes[3].trim());

                
                Libro libro = biblioteca.buscarLibro(codigo); //buscar si ya existe

                if (libro == null) { //si no está en la biblioteca, lo crea
                    Libro libroNuevo = new Libro(codigo, titulo, precio, cantidad);
                    biblioteca.nuevoLibro(libroNuevo);
                    System.out.println("Nuevo libro agregado: " + titulo);
                } else {  //si está, agrega ejemplares con el método de la biblioteca
                    biblioteca.agregarEjemplares(codigo, cantidad);
                    System.out.println("Se agregaron ejemplares a: " + titulo);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error leyendo adquisiciones: " + e.getMessage()); //si la lectura falla, tira una exception
        }
    }

    private static void procesarPrestamos(Biblioteca biblioteca) { //metodo para procesar prestamos desde el .txt
        try {
            InputStream is = Main.class.getResourceAsStream("/prestamos.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split(","); //separa por comas

                short codigo = Short.parseShort(partes[0].trim());
                String tipo = partes[1].trim();
                short cantidad = Short.parseShort(partes[2].trim());

                if (tipo.equalsIgnoreCase("PRESTAMO")) {  //si es un prestamo, entonces llama al metodo prestamo de la biblioteca
                    biblioteca.prestamo(codigo, cantidad);
                } else if (tipo.equalsIgnoreCase("DEVOLUCION")) { //si es una devolucion, entonces llama al metodo devolucion de la biblioteca
                    biblioteca.devolucion(codigo, cantidad);
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error leyendo prestamos: " + e.getMessage()); //si la lectura falla, tira una exception
        }
    }
}