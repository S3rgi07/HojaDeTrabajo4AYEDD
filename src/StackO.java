
import java.util.Arrays;

public class StackO<T> implements Stack<T> {

    private T[] stack;
    private int capacidad_inicial = 10;
    private int top;

    /**
     * Constructor
     */
    public StackO() {
        this.stack = (T[]) new Object[capacidad_inicial];
    }

    /**
     * Agrega un item al stack.
     * 
     * @param item
     */
    /**
     * @param item
     */
    /**
     * @param item
     */
    /**
     * @param item
     */
    @Override
    public void push(T item) {
        if (top == stack.length - 1) {
            resize();
        }
        stack[++top] = item;
    }

    /**
     * Remueve y retorna el item en la cima del stack.
     * 
     * @return
     */
    /**
     * @return T
     */
    /**
     * @return T
     */
    /**
     * @return T
     */
    @Override
    public T pop() {
        if (top == -1) {
            throw new UnsupportedOperationException("El stack está vacío");
        }

        return stack[top--];
    }

    /**
     * Retorna el item en la cima del stack sin removerlo.
     * 
     * @return
     */

    /**
     * @return T
     */
    /**
     * @return T
     */
    /**
     * @return T
     */
    @Override
    public T peek() {
        if (top == -1) {
            throw new UnsupportedOperationException("El stack está vacío");
        } else if (isEmpty()) {
            throw new UnsupportedOperationException("El stack está vacío");
        }
        return stack[top];
    }

    /**
     * Verifica si el stack está vacío
     * 
     * @return
     */
    /**
     * @return boolean
     */
    /**
     * @return boolean
     */
    /**
     * @return boolean
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Duplica el tamaño del stack cuando está lleno
     */
    private void resize() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }
}