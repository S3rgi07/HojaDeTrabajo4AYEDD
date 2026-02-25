import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackTest {
    @Test
    public void testPushPopPeek() {
        Stack<Integer> stack = new StackA<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());
        assertThrows(UnsupportedOperationException.class, () -> {
            stack.pop();
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            stack.peek();
        });

    }

}