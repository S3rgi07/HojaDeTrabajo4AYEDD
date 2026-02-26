package com.example.implementation;

/**
 * Nodo genérico para usar en las listas encadenadas.
 * Funciona tanto para listas simples (usando solo next) como dobles (usando
 * prev).
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 * @param <T> Tipo de dato almacenado en el nodo.
 */
public class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    /**
     * Constructor del nodo.
     * 
     * @param data El valor que guardará el nodo.
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}