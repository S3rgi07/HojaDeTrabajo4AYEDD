import java.util.ArrayList;

public class ArrayListStack<T> extends AbstractStack<T> {
    private ArrayList<T> stack;

    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty())
            return null;
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty())
            return null;
        return stack.get(stack.size() - 1);
    }

    @Override
    public int size() {
        return stack.size();
    }
}