package com.example.implementation;

import com.example.adt.AbstractList;

/**
 * Implementación de una lista simplemente encadenada.
 * Solo guarda referencia al siguiente nodo.
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 * @param <T> Tipo de dato.
 */
public class SingleLinkedList<T> extends AbstractList<T> {
    private Node<T> head;
    private int count;

    public SingleLinkedList() {
        head = null;
        count = 0;
    }

    /**
     * Agrega un nodo al final recorriendo toda la lista.
     * 
     * @param item Dato a agregar.
     */
    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        count++;
    }

    /**
     * Elimina el último nodo recorriendo la lista hasta el penúltimo.
     * 
     * @return El dato del nodo eliminado.
     */
    @Override
    public T removeLast() {
        if (isEmpty())
            return null;

        if (head.next == null) {
            T data = head.data;
            head = null;
            count--;
            return data;
        }

        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        count--;
        return data;
    }

    @Override
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int size() {
        return count;
    }
}