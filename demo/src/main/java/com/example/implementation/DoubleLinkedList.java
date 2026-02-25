package com.example.implementation;

import com.example.adt.AbstractList;

public class DoubleLinkedList<T> extends AbstractList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int count;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

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