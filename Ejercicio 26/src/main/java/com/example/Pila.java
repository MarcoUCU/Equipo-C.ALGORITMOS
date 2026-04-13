import java.util.NoSuchElementException;

public class Pila<T> {
    private Nodo<T> tope;

    public Pila() {
        this.tope = null;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        return tope.getDato();
    }

    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        T dato = tope.getDato();
        tope = tope.getSiguiente();
        return dato;
    }

}
