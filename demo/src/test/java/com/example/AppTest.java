package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.adt.IList;
import com.example.adt.IStack;
import com.example.implementation.DoubleLinkedList;
import com.example.implementation.SingleLinkedList;
import com.example.implementation.StackArrayList;
import com.example.implementation.StackList;
import com.example.implementation.StackVector;

class AppTest {

    // --- PRUEBAS PARA LAS PILAS (STACKS) ---

    @Test
    void testStackArrayListPushPop() {
        IStack<Integer> stack = new StackArrayList<>();
        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.size(), "El tamaño debería ser 2");
        assertEquals(20, stack.peek(), "El tope debería ser 20");
        assertEquals(20, stack.pop(), "Debería sacar 20");
        assertEquals(10, stack.pop(), "Debería sacar 10");
        assertTrue(stack.isEmpty(), "La pila debería estar vacía");
    }

    @Test
    void testStackVectorPushPop() {
        IStack<String> stack = new StackVector<>();
        stack.push("Hola");

        assertFalse(stack.isEmpty());
        assertEquals("Hola", stack.pop());
    }

    // --- PRUEBAS PARA LAS LISTAS (LISTS) ---

    @Test
    void testSingleLinkedListAddRemove() {
        IList<String> list = new SingleLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(3, list.size());
        assertEquals("C", list.getLast(), "El último debería ser C");

        // Probamos eliminar desde el final (comportamiento de pila)
        assertEquals("C", list.removeLast());
        assertEquals("B", list.removeLast());
        assertEquals("A", list.removeLast());

        assertEquals(0, list.size());
    }

    @Test
    void testDoubleLinkedListAddRemove() {
        IList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);

        assertEquals(2, list.getLast());
        assertEquals(2, list.removeLast()); // Debe sacar el 2
        assertEquals(1, list.getLast()); // Ahora el último es 1
        assertEquals(1, list.removeLast()); // Debe sacar el 1

        assertTrue(list.isEmpty());
    }

    // --- PRUEBA DE INTEGRACIÓN (Stack usando Lista) ---

    @Test
    void testStackListImplementation() {
        // Probamos que el StackList funcione usando una DoubleLinkedList por debajo
        IStack<Integer> stack = new StackList<>(new DoubleLinkedList<>());

        stack.push(100);
        stack.push(200);

        assertEquals(200, stack.pop());
        assertEquals(100, stack.peek());
    }
}