package com.example.adt;

/**
 * Clase abstracta para compartir lógica entre las listas simple y doblemente
 * encadenadas.
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 * @param <T> Tipo de dato.
 */
public abstract class AbstractList<T> implements IList<T> {

    /**
     * Implementación común de isEmpty basada en el tamaño.
     * 
     * @return true si la lista no tiene elementos.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}