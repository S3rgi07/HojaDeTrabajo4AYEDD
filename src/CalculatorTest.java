import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test

    public void testIsOperator() {
        Calculator calculator = new Calculator();

        assert (calculator.isOperator("+"));
        assert (calculator.isOperator("-"));
        assert (calculator.isOperator("*"));
        assert (calculator.isOperator("/"));
        assert (!calculator.isOperator("5"));
        assert (!calculator.isOperator("a"));
        assert (!calculator.isOperator(""));
    }

    @Test

    public void testApplyOperator() {
        Calculator calculator = new Calculator();

        assertEquals(5, calculator.applyOperator(2, 3, "+"));
        assertEquals(-1, calculator.applyOperator(2, 3, "-"));
        assertEquals(6, calculator.applyOperator(2, 3, "*"));
        assertEquals(2, calculator.applyOperator(6, 3, "/"));

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.applyOperator(6, 0, "/");
        });
        assertEquals("División por cero", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.applyOperator(6, 3, "%");
        });
        assertEquals("Operador desconocido: %", exception.getMessage());
    }

    @Test

    public void testOperate() {
        Calculator calculator = new Calculator();

        assertEquals(7, calculator.operate("3 4 +"));
        assertEquals(1, calculator.operate("5 4 -"));
        assertEquals(12, calculator.operate("3 4 *"));
        assertEquals(2, calculator.operate("8 4 /"));
    }
}