package com.example.adt;

/**
 * Define las operaciones básicas que debe tener cualquier implementación de una
 * Pila (Stack).
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 * @param <T> El tipo de dato que guardará la pila.
 */
public interface IStack<T> {

    /**
     * Agrega un elemento al tope de la pila.
     * 
     * @param item El elemento a agregar.
     */
    void push(T item);

    /**
     * Elimina y devuelve el elemento en el tope de la pila.
     * 
     * @return El elemento eliminado, o null si la pila está vacía.
     */
    T pop();

    /**
     * Muestra el elemento en el tope sin eliminarlo.
     * 
     * @return El elemento en el tope, o null si está vacía.
     */
    T peek();

    /**
     * Verifica si la pila no tiene elementos.
     * 
     * @return true si está vacía, false si tiene algo.
     */
    boolean isEmpty();

    /**
     * Obtiene la cantidad de elementos actuales en la pila.
     * 
     * @return El tamaño de la pila.
     */
    int size();
}