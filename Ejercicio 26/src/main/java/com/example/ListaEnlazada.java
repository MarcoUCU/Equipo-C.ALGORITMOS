public class ListaEnlazada<T> implements TDALista<T> {
    private Nodo<T> primero;
    private int largo;

    public ListaEnlazada() {
        this.primero = null;
        this.largo = 0;
    }

    @Override
    public boolean add(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);

        if (isEmpty()) {
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }

        largo++;
        return true;
    }

    @Override
    public T get(int indice) {
        if (indice < 0 || indice >= largo) {
            return null;
        }

        Nodo<T> actual = primero;
        int contador = 0;

        while (contador < indice) {
            actual = actual.getSiguiente();
            contador++;
        }

        return actual.getDato();
    }

    @Override
    public T remove(int indice) {
        if (indice < 0 || indice >= largo) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        T eliminado;

        if (indice == 0) {
            eliminado = primero.getDato();
            primero = primero.getSiguiente();
        } else {
            Nodo<T> actual = primero;
            int contador = 0;

            while (contador < indice - 1) {
                actual = actual.getSiguiente();
                contador++;
            }

            Nodo<T> nodoAEliminar = actual.getSiguiente();
            eliminado = nodoAEliminar.getDato();
            actual.setSiguiente(nodoAEliminar.getSiguiente());
        }

        largo--;
        return eliminado;
    }

    @Override
    public boolean remove(T elemento) {
        if (isEmpty()) {
            return false;
        }

        if ((primero.getDato() == null && elemento == null) ||
            (primero.getDato() != null && primero.getDato().equals(elemento))) {
            primero = primero.getSiguiente();
            largo--;
            return true;
        }

        Nodo<T> actual = primero;

        while (actual.getSiguiente() != null) {
            T datoSiguiente = actual.getSiguiente().getDato();

            if ((datoSiguiente == null && elemento == null) ||
                (datoSiguiente != null && datoSiguiente.equals(elemento))) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                largo--;
                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    @Override
    public int size() {
        return largo;
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }
}
