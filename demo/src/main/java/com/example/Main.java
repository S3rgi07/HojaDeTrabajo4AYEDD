package com.example;

import java.util.List;
import java.util.Scanner;

import com.example.adt.IStack;
import com.example.factory.StackFactory;
import com.example.io.FileReader;
import com.example.logic.Calculator;

/**
 * Clase principal del programa.
 * Interactúa con el usuario y coordina la lectura de archivos y cálculos.
 * * @author Sergio López
 * 
 * @author Cristopher Serrano
 */
public class Main {

    /**
     * Punto de entrada de la aplicación.
     * 
     * @param args Argumentos de línea de comandos (no usados).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        Calculator calculator = Calculator.getInstance();

        System.out.println("--- Calculadora Infix a Postfix ---");
        System.out.println("Seleccione implementacion de Stack (ArrayList, Vector, List):");
        String stackType = scanner.nextLine();
        String listType = "";

        if (stackType.equalsIgnoreCase("List")) {
            System.out.println("Seleccione tipo de Lista (Single, Double):");
            listType = scanner.nextLine();
        }

        try {
            // Se asume que datos.txt está en la raíz del proyecto
            List<String> lines = fileReader.readLines("datos.txt");

            for (String infix : lines) {
                System.out.println("\nProcesando: " + infix);
                try {
                    String postfix = calculator.infixToPostfix(infix);
                    System.out.println("Postfix: " + postfix);

                    // Crea la pila específica para evaluar esta operación
                    IStack<Double> evaluationStack = StackFactory.createStack(stackType, listType);

                    double result = calculator.evaluatePostfix(postfix, evaluationStack);
                    System.out.println("Resultado: " + result);

                } catch (Exception e) {
                    System.out.println("Error en la expresion: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error leyendo el archivo datos.txt: " + e.getMessage());
            System.out.println("Asegurese de que datos.txt este en la carpeta raiz del proyecto.");
        }

        scanner.close();
    }
}