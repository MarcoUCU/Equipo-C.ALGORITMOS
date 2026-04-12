package com.example;
import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
    TDAConjunto<TAlumno> aed1 = new Conjunto<>();
    TDAConjunto<TAlumno> pf = new Conjunto<>();
    TAlumno Alumno1 = new TAlumno( 1234, "Juan", "Gomez");
    TAlumno Alumno2 = new TAlumno(5678, "Joseph", "Abad");
    TAlumno Alumno3 = new TAlumno(8765, "Gabriela", "Ramirez");
    TAlumno Alumno4 = new TAlumno(4321, "Andres", "Albanil");
        aed1.agregar(Alumno1);
        aed1.agregar(Alumno2);
        pf.agregar(Alumno2);
        pf.agregar(Alumno4);
        TDAConjunto<TAlumno> resultado = pf.union(aed1);
        ((Conjunto<TAlumno>) resultado).imprimir(); //lo casteo como conjunto para poder usar imprimir()
         TDAConjunto<TAlumno> resultado2 = pf.interseccion(aed1);
         ((Conjunto<TAlumno>) resultado2).imprimir(); //denuevo lo casteo
    }
}
