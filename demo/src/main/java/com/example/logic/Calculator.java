package com.example.logic;

import com.example.adt.IStack;
import com.example.implementation.StackArrayList;

/**
 * Singleton que maneja la lógica de la calculadora.
 * Convierte expresiones Infix a Postfix y las evalúa.
 * 
 * @author Sergio López
 * @author Cristopher Serrano
 */
public class Calculator {
    private static Calculator instance;

    /** Constructor privado para el Singleton. */
    private Calculator() {
    }

    /**
     * Obtiene la única instancia de la calculadora.
     * 
     * @return Instancia de Calculator.
     */
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    /**
     * Convierte una expresión de notación Infix a Postfix usando el algoritmo
     * Shunting Yard.
     * 
     * @param expression La expresión matemática en texto (ej. "3+4").
     * @return La expresión convertida a postfix (ej. "34+").
     */
    public String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        IStack<Character> stack = new StackArrayList<>();

        expression = expression.replaceAll("\\s+", "");

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    /**
     * Evalúa una expresión en formato Postfix.
     * 
     * @param postfix La expresión postfix a calcular.
     * @param stack   La pila que se usará para el cálculo.
     * @return El resultado numérico de la operación.
     */
    public double evaluatePostfix(String postfix, IStack<Double> stack) {
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push((double) (c - '0'));
            } else {
                if (stack.size() < 2)
                    continue;
                double val2 = stack.pop();
                double val1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                    case '^':
                        stack.push(Math.pow(val1, val2));
                        break;
                }
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }

    private int getPrecedence(char c) {
        switch (c) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }
}