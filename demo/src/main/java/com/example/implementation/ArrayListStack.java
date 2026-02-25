package com.example.implementation;

import com.example.adt.AbstractStack;
import java.util.ArrayList;

public class StackArrayList<T> extends AbstractStack<T> {
    private ArrayList<T> stack;

    public StackArrayList() {
        this.stack = new ArrayList<>();
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
        return stack.get(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }
}