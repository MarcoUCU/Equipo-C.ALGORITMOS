package com.example;
import java.util.Arrays;
import java.util.List;
public class App {
    public static void main(String[] args) {
        Expresion expresion = new Expresion();

        List<Character> caso1 = Arrays.asList('{', '}', '{', '{', '}', '}');
        List<Character> caso2 = Arrays.asList('{', '{', '}', '{', '{', '}');
        List<Character> caso3 = Arrays.asList('}', '{');
        List<Character> caso4 = Arrays.asList('{', '{', '}', '}');

        System.out.println("Caso 1: " + expresion.controlCorchetes(caso1)); // true
        System.out.println("Caso 2: " + expresion.controlCorchetes(caso2)); // false
        System.out.println("Caso 3: " + expresion.controlCorchetes(caso3)); // false
        System.out.println("Caso 4: " + expresion.controlCorchetes(caso4)); // true
    }
}
