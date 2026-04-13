public interface TDALista<T> {

    boolean add(T elemento);

    T get(int indice);

    T remove(int indice);

    boolean remove(T elemento);

    int size();

    boolean isEmpty();
}
