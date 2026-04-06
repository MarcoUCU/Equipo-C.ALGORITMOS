package ucu.edu.aed.tda;

public class TDANodo<T> {
    private T dato;
    private TDANodo<T> siguiente;

    public TDANodo(T dato){
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato(){
        return dato;
    }

    public void setSiguiente(TDANodo<T> siguiente){
        this.siguiente = siguiente;
    }

    public TDANodo<T> getSiguiente(){
        return siguiente;
    }
}