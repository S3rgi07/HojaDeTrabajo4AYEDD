public interface IList<T> {
    void add(T item); // Agregar al final

    T removeLast(); // Eliminar del final (para simular pop)

    T getLast(); // Obtener el último (para simular peek)

    int size();

    boolean isEmpty();
}