package com.example;

import java.util.List;
import java.util.Stack;
//No uso las clase sque hice de pilas y eso porque en la letra decia "Este método deberá ser
//desarrollado utilizando la clase Stack de Java."
public class Expresion {
    public boolean controlCorchetes(List<Character> listaDeEntrada){
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < listaDeEntrada.size(); i++) {
            Character c  = listaDeEntrada.get(i);

            if (c == '{') {
                pila.push(c);
            } else if (c == '}') {
                if (pila.isEmpty()) {
                    return false;
                }
                pila.pop();
            }
        }
        return pila.isEmpty();
    }
}
