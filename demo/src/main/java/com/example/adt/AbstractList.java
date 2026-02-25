package com.example.adt;

public abstract class AbstractList<T> implements IList<T> {
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
