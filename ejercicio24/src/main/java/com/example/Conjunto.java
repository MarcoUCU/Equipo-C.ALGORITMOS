package com.example;

import java.util.Comparator;
import java.util.function.Predicate;

public class Conjunto<T> implements TDAConjunto<T> {

    private Nodo<T> primero;

    public Conjunto() {
        this.primero = null;
    }

    //Agregar sin repetir
    @Override
    public void agregar(T dato) {
        if (!contiene(dato)) {
            Nodo<T> nuevo = new Nodo<>(dato);
            nuevo.setSiguiente(primero);
            primero = nuevo;
        }
    }

    //Verificar si existe
    @Override
    public boolean contiene(T dato) {
        Nodo<T> actual = primero;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    //union
    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();

        //recorrer este (agrega todos)
        Nodo<T> actual = this.primero;
        while (actual != null) {
            resultado.agregar(actual.getDato());
            actual = actual.getSiguiente();
        }

        //recorrer otro
        Conjunto<T> otroConjunto = (Conjunto<T>) otro;
        Nodo<T> actual2 = otroConjunto.primero;

        while (actual2 != null) {
            resultado.agregar(actual2.getDato());
            actual2 = actual2.getSiguiente();
        }

        return resultado;
    }

    //interseccion
    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();
        Conjunto<T> otroConjunto = (Conjunto<T>) otro;

        Nodo<T> actual = this.primero;

        while (actual != null) {
            if (otroConjunto.contiene(actual.getDato())) {
                resultado.agregar(actual.getDato());
            }
            actual = actual.getSiguiente();
        }

        return resultado;
    }

    //imprime todos los nodos
    public void imprimir() {
        Nodo<T> actual = primero;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    //MÉTODOS DE TDALista

    @Override
    public void agregar(int index, T elem) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T obtener(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remover(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remover(T elem) {
        return false;
    }

    @Override
    public int indiceDe(T elem) {
        return -1;
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        return null;
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        return null;
    }

    @Override
    public int tamaño() {
        int count = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            count++;
            actual = actual.getSiguiente();
        }
        return count;
    }

    @Override
    public boolean esVacio() {
        return primero == null;
    }

    @Override
    public void vaciar() {
        primero = null;
    }
}