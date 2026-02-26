package com.example;

import java.util.List;
import java.util.Scanner;

import com.example.adt.IStack;
import com.example.factory.StackFactory;
import com.example.io.FileReader;
import com.example.logic.Calculator;

public class Main {
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
            // El archivo datos.txt debe estar en la raíz (fuera de src)
            List<String> lines = fileReader.readLines("datos.txt");

            for (String infix : lines) {
                System.out.println("\nProcesando: " + infix);
                try {
                    String postfix = calculator.infixToPostfix(infix);
                    System.out.println("Postfix: " + postfix);

                    IStack<Double> evaluationStack = StackFactory.createStack(stackType, listType);

                    double result = calculator.evaluatePostfix(postfix, evaluationStack);
                    System.out.println("Resultado: " + result);

                } catch (Exception e) {
                    System.out.println("Error en la expresion: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error leyendo el archivo datos.txt: " + e.getMessage());
        }

        scanner.close();
    }
}