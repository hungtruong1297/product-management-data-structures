import java.util.EmptyStackException;
import java.util.LinkedList;

public class IntegerStack {
    LinkedList<Integer> list = new LinkedList<>();

    public void push(int i) {
        list.push(i);
    }

    public int peek() {
        if (list.isEmpty()) {
            throw new EmptyStackException();
        }
        return list.peek();
    }

    public int pop() {
        return list.pop();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}