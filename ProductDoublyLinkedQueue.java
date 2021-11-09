import java.io.FileNotFoundException;

public class ProductDoublyLinkedQueue {
    ProductDoublyLinkedList queue;

    public ProductDoublyLinkedQueue() {
        queue = new ProductDoublyLinkedList();
    }

    public void add(Product product) {
        queue.addToEnd(product);
    }

    public void remove() {
        queue.removeAtEnd();
    }

    public Product peek() {
        return queue.getHead().getProduct();
    }

    public void readFromFileToQueue() throws FileNotFoundException {
        queue.readFromFileToQueue();
    }

    public void traverse() {
        queue.traverse();
    }

}
