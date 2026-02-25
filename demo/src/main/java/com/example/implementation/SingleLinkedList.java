package com.example.implementation;

import com.example.adt.AbstractList;

public class SingleLinkedList<T> extends AbstractList<T> {
    private Node<T> head;
    private int count;

    public SingleLinkedList() {
        head = null;
        count = 0;
    }

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