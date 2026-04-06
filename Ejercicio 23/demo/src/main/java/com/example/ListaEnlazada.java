package com.example;

public class ListaEnlazada<T> implements TDALista<T> {
    protected TDANodo<T> primero;

    public ListaEnlazada(){
        this.primero = null;
    }

    public boolean agregar(T dato){
        TDANodo<T> nuevoNodo = new TDANodo<T>(dato);
        if (this.esVacio()){this.primero = nuevoNodo; return true;}
        else{
            TDANodo<T> actual = this.primero;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
            return true;
        }
    }
    
    public int tamano(){
        int contador = 1;
        TDANodo<T> actual = this.primero;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
                contador += 1;
            }
        return contador;
    }

    public boolean esVacio(){
        if (primero == null){return true;}
        return false;
    }

    @Override
        public T eliminar(int index) {
            if (index < 0 || index >= tamano()) {
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

        public T obtener(int index){
            if (index < 0 || index >= tamano()){
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
}