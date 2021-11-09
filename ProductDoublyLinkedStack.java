import java.io.FileNotFoundException;

public class ProductDoublyLinkedStack {
    ProductDoublyLinkedList stack;

    public ProductDoublyLinkedStack() {
        stack = new ProductDoublyLinkedList();
    }

    public void readFromFile() throws FileNotFoundException {
        stack.readFromFile();
    }

    public void traverse() {
        stack.traverse();
    }

    public Product peek() {
        return stack.getHead().getProduct();
    }

    public void pop() {
        stack.removeAtFront();
    }

    public void push() {
        stack.addToFront();
    }
}
