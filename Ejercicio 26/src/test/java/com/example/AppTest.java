package com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AppTest {

    @Test
    public void expresionVaciaDebeSerCorrecta() {
        Expresion expresion = new Expresion();
        List<Character> lista = Arrays.asList();

        assertTrue(expresion.controlCorchetes(lista));
    }

    @Test
    public void unaParejaCorrecta() {
        Expresion expresion = new Expresion();
        List<Character> lista = Arrays.asList('{', '}');

        assertTrue(expresion.controlCorchetes(lista));
    }

    @Test
    public void muchasLlavesBienHechas() {
        Expresion expresion = new Expresion();
        List<Character> lista = Arrays.asList('{', '}', '{', '{', '}', '}');

        assertTrue(expresion.controlCorchetes(lista));
    }

    @Test
    public void llavesAnidadasCorrectas() {
        Expresion expresion = new Expresion();
        List<Character> lista = Arrays.asList('{', '{', '}', '}');

        assertTrue(expresion.controlCorchetes(lista));
    }

    @Test
    public void empiezaConCierreDebeDarFalse() {
        Expresion expresion = new Expresion();
        List<Character> lista = Arrays.asList('}', '{');

        assertFalse(expresion.controlCorchetes(lista));
    }

    @Test
    public void faltaUnaLlaveDeCierre() {
        Expresion expresion = new Expresion();
        List<Character> lista = Arrays.asList('{', '{', '}');

        assertFalse(expresion.controlCorchetes(lista));
    }

    @Test
    public void sobraUnaLlaveDeCierre() {
        Expresion expresion = new Expresion();
        List<Character> lista = Arrays.asList('{', '}', '}');

        assertFalse(expresion.controlCorchetes(lista));
    }

    @Test
    public void casoDelEjemploIncorrecto() {
        Expresion expresion = new Expresion();
        List<Character> lista = Arrays.asList('{', '{', '}', '{', '{', '}');

        assertFalse(expresion.controlCorchetes(lista));
    }
}
