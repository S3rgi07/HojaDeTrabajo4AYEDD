import java.io.IOException;

public class Main {
    /**
     * @param args
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        FileReader fileReader = new FileReader();
        String input = "";
        try {
            input = fileReader.readFile("datos.txt");
        } catch (IOException ex) {
            System.out.println("No se pudo encontrar o leer el archivo 'datos.txt'. " + ex.getMessage());
        }
        double result = calculator.operate(input);
        System.out.println("Calculadora de Notación Postfix");
        System.out.println("------------------------------");
        System.out.println("Expresión: " + input);
        System.out.println("Resultado: " + result);
        System.out.println("------------------------------");
    }
}