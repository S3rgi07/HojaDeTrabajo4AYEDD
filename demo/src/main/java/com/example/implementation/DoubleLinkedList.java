package com.example.implementation;

import com.example.adt.AbstractList;

/**
 * Lista doblemente encadenada.
 * Tiene referencias al inicio (head) y al final (tail) para operaciones más
 * rápidas.
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 * @param <T> Tipo de dato.
 */
public class DoubleLinkedList<T> extends AbstractList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int count;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Agrega al final en O(1) usando la referencia tail.
     * 
     * @param item Dato a agregar.
     */
    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }

    /**
     * Elimina el último elemento en O(1) actualizando el tail.
     * 
     * @return Dato eliminado.
     */
    @Override
    public T removeLast() {
        if (isEmpty())
            return null;
        T data = tail.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        count--;
        return data;
    }

    @Override
    public T getLast() {
        if (isEmpty())
            return null;
        return tail.data;
    }

    @Override
    public int size() {
        return count;
    }
}