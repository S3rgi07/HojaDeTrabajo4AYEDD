package com.example.factory;

import com.example.adt.IStack;
// IMPORTANTE: Aquí importamos los nuevos nombres
import com.example.implementation.StackArrayList;
import com.example.implementation.StackVector;
import com.example.implementation.StackList;
import com.example.implementation.SingleLinkedList;
import com.example.implementation.DoubleLinkedList;

public class StackFactory {

    public static <T> IStack<T> createStack(String stackType, String listType) {
        if (stackType.equalsIgnoreCase("ArrayList")) {
            return new StackArrayList<T>(); // Nombre corregido
        } else if (stackType.equalsIgnoreCase("Vector")) {
            return new StackVector<T>(); // Nombre corregido
        } else if (stackType.equalsIgnoreCase("List")) {
            if (listType != null && listType.equalsIgnoreCase("Single")) {
                return new StackList<T>(new SingleLinkedList<T>()); // Nombre corregido
            } else {
                return new StackList<T>(new DoubleLinkedList<T>()); // Nombre corregido
            }
        }

        return new StackArrayList<T>(); // Default corregido
    }
}