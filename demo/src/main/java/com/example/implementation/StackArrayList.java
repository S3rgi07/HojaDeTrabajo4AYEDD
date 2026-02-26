package com.example.implementation;

import java.util.ArrayList;

import com.example.adt.AbstractStack;

/**
 * Implementación de Pila usando la clase ArrayList de Java.
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 * @param <T> Tipo de dato.
 */
public class StackArrayList<T> extends AbstractStack<T> {
    private ArrayList<T> stack;

    public StackArrayList() {
        this.stack = new ArrayList<>();
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
        return stack.get(stack.size() - 1);
    }

    @Override
    public int size() {
        return stack.size();
    }
}