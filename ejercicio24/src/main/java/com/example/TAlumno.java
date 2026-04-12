package com.example;

public class TAlumno {
    private int cedula;
    private String nombre;
    private String apellido;

public TAlumno(int cedula, String nombre, String apellido){
    this.cedula = cedula;
    this.nombre= nombre;
    this.apellido=apellido;
}

@Override
public String toString() {  //Se usa para que no devuelva la direccion hash cuando imprima
    return cedula + " - " + nombre + " " + apellido;
}

}
