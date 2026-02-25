package com.example.implementation;

import com.example.adt.AbstractStack;
import com.example.adt.IList;

public class StackList<T> extends AbstractStack<T> {
    private IList<T> internalList;

    public StackList(IList<T> listType) {
        this.internalList = listType;
    }

    public void push(T item) {
        internalList.add(item);
    }

    public T pop() {
        return internalList.removeLast();
    }

    public T peek() {
        return internalList.getLast();
    }

    public int size() {
        return internalList.size();
    }
}
