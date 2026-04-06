package com.example;

public interface TDALista<T> {
    boolean agregar(T elemento);
    T obtener(int indice);
    T eliminar(int indice);
    boolean eliminar(T elemento);
    int tamano();
    boolean esVacio();
}
