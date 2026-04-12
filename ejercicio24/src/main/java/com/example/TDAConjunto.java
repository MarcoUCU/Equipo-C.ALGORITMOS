package com.example;

public interface TDAConjunto<T> extends TDALista<T>{

    TDAConjunto<T> union(TDAConjunto<T> otro);
    TDAConjunto<T> interseccion(TDAConjunto<T> otro);
}
