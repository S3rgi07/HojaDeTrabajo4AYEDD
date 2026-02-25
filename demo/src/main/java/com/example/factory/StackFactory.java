package com.example.factory;

import com.example.adt.IStack;
import com.example.implementation.ArrayListStack;
import com.example.implementation.VectorStack;
import com.example.implementation.ListStack;
import com.example.implementation.SingleLinkedList;
import com.example.implementation.DoubleLinkedList;

public class StackFactory {

    // El secreto es el <T> en el 'new' para forzar el tipo
    public static <T> IStack<T> createStack(String stackType, String listType) {
        if (stackType.equalsIgnoreCase("ArrayList")) {
            return new ArrayListStack<T>();
        } else if (stackType.equalsIgnoreCase("Vector")) {
            return new VectorStack<T>();
        } else if (stackType.equalsIgnoreCase("List")) {
            if (listType != null && listType.equalsIgnoreCase("Single")) {
                return new ListStack<T>(new SingleLinkedList<T>());
            } else {
                return new ListStack<T>(new DoubleLinkedList<T>());
            }
        }

        return new ArrayListStack<T>();
    }
}