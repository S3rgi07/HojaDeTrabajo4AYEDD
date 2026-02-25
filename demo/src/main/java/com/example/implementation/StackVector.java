package com.example.implementation;

import com.example.adt.AbstractStack;
import java.util.Vector;

public class StackVector<T> extends AbstractStack<T> {
    private Vector<T> stack;

    public StackVector() {
        this.stack = new Vector<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty())
            return null;
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty())
            return null;
        return stack.lastElement();
    }

    public int size() {
        return stack.size();
    }
}