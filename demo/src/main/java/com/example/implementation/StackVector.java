package com.example.implementation;

import java.util.Vector;

import com.example.adt.AbstractStack;

/**
 * Implementación de Pila usando la clase Vector de Java.
 * Similar al ArrayList pero thread-safe (sincronizado).
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 * @param <T> Tipo de dato.
 */
public class StackVector<T> extends AbstractStack<T> {
    private Vector<T> stack;

    public StackVector() {
        this.stack = new Vector<>();
    }

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty())
            return null;
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty())
            return null;
        return stack.lastElement();
    }

    @Override
    public int size() {
        return stack.size();
    }
}