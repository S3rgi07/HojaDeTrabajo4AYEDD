import java.io.IOException;
import java.util.List;

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
        List<String> input = null;
        try {
            input = fileReader.readFile("datos.txt");
        } catch (IOException ex) {
            System.out.println("No se pudo encontrar o leer el archivo 'datos.txt'. " + ex.getMessage());
        }
        System.out.println("Calculadora de Notación Postfix");
        System.out.println("------------------------------");
        for (String line : input) {
            double result = calculator.operate(line);
            System.out.println("Expresión: " + line);
            System.out.println("Resultado: " + result);
            System.out.println("------------------------------");
        }
    }
}