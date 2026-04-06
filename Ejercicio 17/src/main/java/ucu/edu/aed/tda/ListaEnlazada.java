package ucu.edu.aed.tda;

import java.util.Comparator;
import java.util.function.Predicate;

public class ListaEnlazada<T> implements TDALista<T> {
    
    @Override
        public void agregar(T elemento){
            TDANodo<T> nuevo = new TDANodo<>(elemento);
            if (primero == null){
                primero = nuevo;
                return;
            }

            TDANodo<T> actual = primero;

            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }

            actual.setSiguiente(nuevo);
        }
    
    @Override
        public void agregar(int index, T elemento){
            if (index < 0 || index > tamaño()) {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }
            TDANodo<T> nuevo = new TDANodo<>(elemento);

            if (index == 0){
                nuevo.setSiguiente(primero);
                primero = nuevo;
                return;
            }

            TDANodo<T> actual = primero;
            int i = 0;

            while (i < index -1){
                actual = actual.getSiguiente();
                i++;
            }
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }

    @Override
        public T obtener(int index){
            if (index < 0 || index >= tamaño()){
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }

            TDANodo<T> actual = primero;
            int i = 0;

            while (i < index){
                actual = actual.getSiguiente();
                i++;
            }
            return actual.getDato();
        }

    @Override
        public T eliminar(int index) {
            if (index < 0 || index >= tamaño()) {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }

            if (index == 0) {
                T dato = primero.getDato();
                primero = primero.getSiguiente();
                return dato;
            }

            TDANodo<T> actual = primero;
            int i = 0;

            while (i < index - 1) {
                actual = actual.getSiguiente();
                i++;
            }

            T dato = actual.getSiguiente().getDato();
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            return dato;
        }

    @Override
        public boolean eliminar(T elemento) {
            if (esVacio()) {
                return false;
            }

            if (primero.getDato().equals(elemento)) {
                primero = primero.getSiguiente();
                return true;
            }

            TDANodo<T> actual = primero;

            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getDato().equals(elemento)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    return true;
                }
                actual = actual.getSiguiente();
            }

            return false;
        }

    @Override
        public boolean contiene(T elemento) {
            TDANodo<T> actual = primero;

            while (actual != null) {
                if (actual.getDato().equals(elemento)) {
                    return true;
                }
                actual = actual.getSiguiente();
            }

            return false;
        }

    @Override
        public int indiceDe(T elemento) {
            TDANodo<T> actual = primero;
            int i = 0;

            while (actual != null) {
                if (actual.getDato().equals(elemento)) {
                    return i;
                }
                actual = actual.getSiguiente();
                i++;
            }

            return -1;
        }

    @Override
        public T buscar(Predicate<T> criterio) {
            TDANodo<T> actual = primero;

            while (actual != null) {
                if (criterio.test(actual.getDato())) {
                    return actual.getDato();
                }
                actual = actual.getSiguiente();
            }

            return null;
        }

    @Override
        public TDALista<T> ordenar(Comparator<T> comparator) {
            ListaEnlazada<T> ordenada = new ListaEnlazada<>();

            TDANodo<T> actual = primero;

            while (actual != null) {
                T elem = actual.getDato();

                if (ordenada.esVacio()) {
                    ordenada.agregar(elem);
                } else {
                    int i = 0;
                    while (i < ordenada.tamaño() && comparator.compare(elem, ordenada.obtener(i)) > 0) {
                        i++;
                    }
                    ordenada.agregar(i, elem);
                }

                actual = actual.getSiguiente();
            }

            return ordenada;
        }

    @Override
        public int tamaño() {
            int contador = 0;
            TDANodo<T> actual = primero;

            while (actual != null) {
                contador++;
                actual = actual.getSiguiente();
            }

            return contador;
        }

    @Override
        public boolean esVacio() {
            return primero == null;
        }

    @Override
        public void vaciar() {
            primero = null;
        }

    protected TDANodo<T> primero; //cambie a protected 

} 


