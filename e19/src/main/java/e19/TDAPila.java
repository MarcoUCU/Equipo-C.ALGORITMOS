package e19;

public class TDAPila<T> {
    private TDANodo<T> cima;

    public TDAPila() {
        this.cima = null;
    }

    public boolean esVacia() {
        return cima == null;
    }

    public void push(T valor) {
        TDANodo<T> nuevoNodo = new TDANodo<>(valor, cima);
        cima = nuevoNodo;
    }

    public T pop() {
        if (this.esVacia()) return null;
        TDANodo<T> cimaEliminar = cima;
        cima = cima.getSiguiente();
        return cimaEliminar.getDato();
    }

    public T peek() {
        if (this.esVacia()) return null;
        return cima.getDato();
    }
}