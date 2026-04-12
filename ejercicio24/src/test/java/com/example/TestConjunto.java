package com.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TestConjunto {
    @Test
public void testUnionBasica() {
    TDAConjunto<Integer> a = new Conjunto<>();
    TDAConjunto<Integer> b = new Conjunto<>();

    a.agregar(1);
    a.agregar(2);
    a.agregar(3);

    b.agregar(3);
    b.agregar(4);

    TDAConjunto<Integer> resultado = a.union(b);

    assertTrue(resultado.contiene(1));
    assertTrue(resultado.contiene(2));
    assertTrue(resultado.contiene(3));
    assertTrue(resultado.contiene(4));
    assertEquals(4, resultado.tamaño());
}
@Test
public void testInterseccionBasica() {
    TDAConjunto<Integer> a = new Conjunto<>();
    TDAConjunto<Integer> b = new Conjunto<>();

    a.agregar(1);
    a.agregar(2);
    a.agregar(3);

    b.agregar(2);
    b.agregar(3);
    b.agregar(4);

    TDAConjunto<Integer> resultado = a.interseccion(b);

    assertTrue(resultado.contiene(2));
    assertTrue(resultado.contiene(3));
    assertFalse(resultado.contiene(1));
    assertEquals(2, resultado.tamaño());
}
@Test
public void testInterseccionVacia() {
    TDAConjunto<Integer> a = new Conjunto<>();
    TDAConjunto<Integer> b = new Conjunto<>();

    a.agregar(1);
    a.agregar(2);

    b.agregar(3);
    b.agregar(4);

    TDAConjunto<Integer> resultado = a.interseccion(b);

    assertEquals(0, resultado.tamaño());
}
@Test
public void testUnionConVacio() {
    TDAConjunto<Integer> a = new Conjunto<>();
    TDAConjunto<Integer> b = new Conjunto<>();

    a.agregar(1);
    a.agregar(2);

    TDAConjunto<Integer> resultado = a.union(b);

    assertEquals(2, resultado.tamaño());
    assertTrue(resultado.contiene(1));
    assertTrue(resultado.contiene(2));
}
@Test
public void testConjuntosIguales() {
    TDAConjunto<Integer> a = new Conjunto<>();
    TDAConjunto<Integer> b = new Conjunto<>();

    a.agregar(1);
    a.agregar(2);

    b.agregar(1);
    b.agregar(2);

    TDAConjunto<Integer> inter = a.interseccion(b);
    TDAConjunto<Integer> uni = a.union(b);

    assertEquals(2, inter.tamaño());
    assertEquals(2, uni.tamaño());
}
@Test
public void testSubconjunto() {
    TDAConjunto<Integer> a = new Conjunto<>();
    TDAConjunto<Integer> b = new Conjunto<>();

    a.agregar(1);
    a.agregar(2);
    a.agregar(3);

    b.agregar(2);
    b.agregar(3);

    TDAConjunto<Integer> inter = a.interseccion(b);
    TDAConjunto<Integer> uni = a.union(b);

    assertEquals(2, inter.tamaño());
    assertEquals(3, uni.tamaño());
}
}
