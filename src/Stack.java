
public interface Stack<T> {

    /**
     * Agrega un item al stack.
     * 
     * @param item
     */
    void push(T item);

    /**
     * Remueve y retorna el item en la cima del stack.
     * 
     * @return
     */
    T pop();

    /**
     * Retorna el item en la cima del stack sin removerlo.
     * 
     * @return
     */
    T peek();

}