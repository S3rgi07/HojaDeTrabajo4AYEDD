package com.example.implementation;

import com.example.adt.AbstractStack;
import com.example.adt.IList;

/**
 * Implementación de Pila que utiliza una Lista (IList) internamente.
 * Esto es un ejemplo del patrón Adapter, adaptando la lista para comportarse
 * como pila.
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 * @param <T> Tipo de dato.
 */
public class StackList<T> extends AbstractStack<T> {
    private IList<T> internalList;

    /**
     * Constructor que recibe la implementación específica de lista a usar.
     * 
     * @param listType La lista (Simple o Doble) donde se guardarán los datos.
     */
    public StackList(IList<T> listType) {
        this.internalList = listType;
    }

    @Override
    public void push(T item) {
        internalList.add(item);
    }

    @Override
    public T pop() {
        return internalList.removeLast();
    }

    @Override
    public T peek() {
        return internalList.getLast();
    }

    @Override
    public int size() {
        return internalList.size();
    }
}