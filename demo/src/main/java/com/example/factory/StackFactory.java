package com.example.factory;

import com.example.adt.IStack;
import com.example.implementation.StackArrayList;
import com.example.implementation.StackVector;
import com.example.implementation.StackList;
import com.example.implementation.SingleLinkedList;
import com.example.implementation.DoubleLinkedList;

/**
 * Fábrica (Factory Pattern) para crear instancias de Pilas.
 * Decide qué implementación usar basándose en la entrada del usuario.
 * 
 * @author Sergio López
 * @author Cristopher Serrano
 */
public class StackFactory {

    /**
     * Constructor por defecto.
     */
    public StackFactory() {
        // Constructor vacío
    }

    /**
     * Crea una pila del tipo solicitado.
     * 
     * @param <T>       Tipo de dato de la pila.
     * @param stackType Tipo de pila ("ArrayList", "Vector", "List").
     * @param listType  Si es lista, especifica cuál ("Single", "Double").
     * @return Una instancia de IStack lista para usar.
     */
    public static <T> IStack<T> createStack(String stackType, String listType) {
        if (stackType.equalsIgnoreCase("ArrayList")) {
            return new StackArrayList<T>();
        } else if (stackType.equalsIgnoreCase("Vector")) {
            return new StackVector<T>();
        } else if (stackType.equalsIgnoreCase("List")) {
            if (listType != null && listType.equalsIgnoreCase("Single")) {
                return new StackList<T>(new SingleLinkedList<T>());
            } else {
                return new StackList<T>(new DoubleLinkedList<T>());
            }
        }
        return new StackArrayList<T>();
    }
}