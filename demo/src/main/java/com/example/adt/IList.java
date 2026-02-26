package com.example.adt;

/**
 * Interfaz para las listas encadenadas que usaremos como base para las pilas.
 * Solo define lo necesario para este proyecto.
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 * @param <T> Tipo de dato de los elementos.
 */
public interface IList<T> {

    /**
     * Agrega un elemento al final de la lista.
     * 
     * @param item Dato a guardar.
     */
    void add(T item);

    /**
     * Elimina el último elemento de la lista y lo devuelve.
     * Útil para comportarse como una pila (LIFO).
     * 
     * @return El elemento eliminado.
     */
    T removeLast();

    /**
     * Obtiene el último elemento sin borrarlo.
     * 
     * @return El último dato de la lista.
     */
    T getLast();

    /**
     * Devuelve la cantidad de nodos en la lista.
     * 
     * @return Tamaño de la lista.
     */
    int size();

    /**
     * Revisa si la lista está vacía.
     * 
     * @return true si no hay nodos.
     */
    boolean isEmpty();
}