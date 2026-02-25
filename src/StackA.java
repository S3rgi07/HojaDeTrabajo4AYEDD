//Esta clase fue utilizada para comprobar el funcionamiento con un ArrayList

import java.util.ArrayList;

public class StackA<T> implements Stack<T> {

    private ArrayList<T> stack;

    public StackA() {
        this.stack = new ArrayList<>();
    }

    /**
     * Agrega un item al stack.
     * 
     * @param item
     */
    /**
     * @param item
     */
    @Override
    public void push(T item) {
        stack.add(item);
    }

    /**
     * Remueve y retorna el item en la cima del stack.
     * 
     * @return
     */
    /**
     * @return T
     */
    @Override
    public T pop() {
        if (stack.isEmpty()) {
            throw new UnsupportedOperationException("El stack está vacío");
        }
        return stack.remove(stack.size() - 1);
    }

    /**
     * Retorna el item en la cima del stack sin removerlo.
     * 
     * @return
     */
    /**
     * @return T
     */
    @Override
    public T peek() {
        if (stack.isEmpty()) {
            throw new UnsupportedOperationException("El stack está vacío");
        }
        return stack.get(stack.size() - 1);
    }

    /**
     * Verifica si el stack está vacío
     * 
     * @return
     */
    /**
     * @return boolean
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

}