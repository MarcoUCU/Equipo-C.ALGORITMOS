package ucu.edu.aed.tda;

public class Biblioteca extends ListaEnlazada<Libro>{

    public Biblioteca(){
    }

    public boolean nuevoLibro (Libro nuevo){
        TDANodo<Libro> unLibro = new TDANodo<Libro>(nuevo);
        if (this.esVacio()){
            this.primero = unLibro;
            return true;
        }
        
        TDANodo<Libro> actual = this.primero;

        if(primero.getDato().getTitulo().compareTo(unLibro.getDato().getTitulo())>0){
            unLibro.setSiguiente(actual);
            this.primero = unLibro;
            return true;
        }

        while (actual.getSiguiente()!=null){
            String nombreSiguiente = actual.getSiguiente().getDato().getTitulo();        
            String nombreAgregar = unLibro.getDato().getTitulo();
            if ((nombreAgregar.compareTo(nombreSiguiente))<0){
                unLibro.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(unLibro);
                return true;
            }
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(unLibro);
        return true;
    }
    
    public Libro retirarCatalogo(String id) {
        if (this.esVacio()) return null;
    
        TDANodo<Libro> actual = this.primero;
        int contador = 0;
    
        while (actual != null) {
            if (actual.getDato().getCodigo().equals(id)) {
                return this.eliminar(contador);
            }
            actual = actual.getSiguiente();
            contador++;
        }
        return null;
    }

    public int existencias(String id){
        if (this.esVacio()){return -1;}

        TDANodo<Libro> actual = this.primero;

        while(actual!=null){
            if(actual.getDato().getCodigo().equals(id)){
                return actual.getDato().getCantidad();
            }
            actual = actual.getSiguiente();
        }

        return -1;
    }

    public String listarLibros(){
        if (this.esVacio()){return "Vacío";}
        
        TDANodo<Libro> actual = this.primero;
        String resultado = "=== Catálogo ===\n";
        int contador = 1;

        while(actual!=null){
            resultado+= contador + ") Nombre: " + actual.getDato().getTitulo() + " Stock: " + actual.getDato().getCantidad()+ "\n";
            actual = actual.getSiguiente();
            contador++;
        }
        return resultado;
    }

    public boolean cambiarStock(String id, short variacion){
        if (this.esVacio()){return false;}

        TDANodo<Libro> actual = this.primero;

        while(actual!=null){
            if(actual.getDato().getCodigo().equals(id)){
                actual.getDato().cambiarStock((byte) variacion);
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    public void prestamo(String id, short cantidad){
        this.cambiarStock(id, (short)(-cantidad));
    }

    public void devolucion(String id, short cantidad){
        this.cambiarStock(id, (short)(cantidad));
    }


}
