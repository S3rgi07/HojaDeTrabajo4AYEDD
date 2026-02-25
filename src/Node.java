public class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev; // Solo se usa en doblemente encadenada

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}