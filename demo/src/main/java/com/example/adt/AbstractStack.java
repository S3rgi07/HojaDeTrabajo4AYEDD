package com.example.adt;

/**
 * Clase base para las pilas.
 * Implementa métodos comunes para no repetir código en las implementaciones
 * concretas.
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 * @param <T> Tipo de dato.
 */
public abstract class AbstractStack<T> implements IStack<T> {

    /**
     * Comprueba si la pila está vacía revisando si el tamaño es 0.
     * 
     * @return true si size() es 0.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}