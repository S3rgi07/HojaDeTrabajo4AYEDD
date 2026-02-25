/**
 * @author Sergio López 25848
 * @author Cristhian Serrano 251375
 */

public class Calculator implements Calc {

    private StackA<Integer> stack = new StackA<>();

    /**
     * Verifica si el token es un operador válido
     * 
     * @param token
     * @return
     */

    /**
     * @param token
     * @return boolean
     */
    public boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");

    }

    /**
     * Aplica el operador a los operandos dados
     * 
     * @param a
     * @param b
     * @param operator
     * @return
     */

    public int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operator);
        }
    }

    /**
     * 
     * Realiza la operación postfix dada en la cadena de entrada
     * 
     * @param input
     * @return
     */

    /**
     * @param input
     * @return double
     */
    @Override
    public double operate(String input) {
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}