package e19;

public class TDANodo <T>{
    private T dato;
    private TDANodo<T> siguiente;

    public TDANodo(T valor, TDANodo<T> next){
        this.dato = valor;
        this.siguiente = next;
    }

    public void setSiguiente(TDANodo<T> next){
        this.siguiente = next;
    }

    public T getDato(){
        return this.dato;
    }

    public TDANodo<T> getSiguiente(){
        return this.siguiente;
    }
}
