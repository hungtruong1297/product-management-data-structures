import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.Scanner;

public class ProductDoublyLinkedList {
    private ProductNode head;
    private ProductNode tail;
    private final Scanner sc = new Scanner(System.in);

    public ProductDoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Add to front
    public void addToFront() {
        System.out.println("Type new product");
        System.out.print("Code: ");
        String code = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        Product newProduct = new Product(code, name, quantity, price);
        addToFront(newProduct);
    }
    public void addToFront(Product product) {
        ProductNode node = new ProductNode(product);
        if (isEmpty()) {
            tail = node;
            head = node;
            return;
        }
        head.setPrevious(node);
        node.setNext(head);
        head = node;
    }

    // Add to end
    public void addToEnd() {
        System.out.println("Type new product");
        System.out.print("Code: ");
        String code = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        Product newProduct = new Product(code, name, quantity, price);
        addToEnd(newProduct);
    }

    public void addToEnd(Product product) {
        ProductNode node = new ProductNode(product);

        if (isEmpty()) {
            tail = node;
            head = node;
            return;
        }

        tail.setNext(node);
        node.setPrevious(tail);
        tail = node;
    }

    // Check if LinkedList is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Traverse
    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        ProductNode current = head;
        while (current != null) {
            System.out.println(current.getProduct());
            current = current.getNext();
        }
    }

    // Search by Code
    public void searchByCode() {
        System.out.println("Type your code: ");
        String code = sc.nextLine();
        ProductNode result = searchByCode(code);
        if (result == null) {
            System.out.println("Product not found.");
        } else
            System.out.println(result.getProduct());
    }

    public ProductNode searchByCode(String code) {
        ProductNode current = head;
        while (current != null) {
            if (current.getProduct().getCode().equalsIgnoreCase(code)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Remove by Entering code by User

    public void removeByCode() {
        System.out.println("Type your code needs removing: ");
        String code = sc.nextLine();
        if (removeByCode(code)==null) {
            System.out.println("Couldn't find Code to remove.");
        } else {
            System.out.println("Removed.");
        }
    }

    public ProductNode removeByCode(String code) {

        //Step 1: Search
        ProductNode current = returnProductNodeByCode(code);
        if (current == null) {
            return null;
        }
        // Step 2: If found. Then handle first item and last item
        if (current.getPrevious() == null) {
            removeAtFront();
            return current;
        }
        if (current.getNext() == null) {
            removeAtEnd();
            return current;
        }

        // Step 3: Handle middle cases
        ProductNode previous = current.getPrevious();
        ProductNode next = current.getNext();

        previous.setNext(current.getNext());
        next.setPrevious(current.getPrevious());

        // Step 4: Cleaning up Removed Node
        current.setNext(null);
        current.setPrevious(null);

        return current;
    }

    private ProductNode returnProductNodeByCode(String str) {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return null;
        }
        ProductNode current = head;
        while (current != null) {
            if (current.getProduct().getCode().compareToIgnoreCase(str) == 0) {
                return current;
            }
            current = current.getNext();
        }
        return tail.getNext();
    }

    // Get length or Size of Linked List
    public int getSize() {
        int size = 0;
        ProductNode current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    // Remove Node at front
    public void removeAtFront() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (getSize() == 1) {
            clear();
            return;
        }

        ProductNode newHead = head.getNext();
        newHead.setPrevious(null);
        head = newHead;
    }

    // Remove Node at end
    public void removeAtEnd() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (getSize() == 1) {
            clear();
            return;
        }

        ProductNode newTail = tail.getPrevious();
        tail.getPrevious().setNext(null);
        newTail.setNext(null);
        tail.setPrevious(null);
        tail = newTail;
    }

    // Sorting by Code, using Selectiong Sort
    public void sortByCode() {
        // Selection Sort
        ProductNode current = head;
        ProductNode index;
        while (current != null) {
            ProductNode min = current;
            index = current.getNext();
            while (index != null) {
                if (compareByCode(index, min) < 0) {
                    min = index;
                }
                index = index.getNext();
            }
            swapProduct(min, current);
            current = current.getNext();
        }
    }

    // Reset head and tail. But not cleaning
    public void clear() {
        head = null;
        tail = null;
    }

    /*  Compare by Code - return an integer.
        = 0: equal
        > 0: node1 bigger than node2
        < 0: node1 smaller than node2
     */
    public int compareByCode(ProductNode node1, ProductNode node2) {
        ProductNode tempNode;
        return node1.getProduct().getCode().compareToIgnoreCase(node2.getProduct().getCode());
    }

    // Swap Product content
    public void swapProduct(ProductNode node1, ProductNode node2) {
        ProductNode tempNode = new ProductNode();
        tempNode.setProduct(node1.getProduct());
        node1.setProduct(node2.getProduct());
        node2.setProduct(tempNode.getProduct());
    }

    // Convert First Item Quantity To Binary and Print using Stack
    public void convertFirstItemQuantityToBinary() {
        int quantity = head.getProduct().getQuantity();
        System.out.print("Convert " + quantity + " to Binary: ");
        System.out.print(convertQuantityToBinary(quantity) + "\n");
    }

    // Using String Buffer here is more efficient because don't have to
    // re-create new String Object
    public StringBuffer convertQuantityToBinary(int quantity) {
        StringBuffer result = new StringBuffer();
        IntegerStack numbers = new IntegerStack();
        while (quantity != 0) {
            numbers.push(quantity % 2);
            quantity /= 2;
            result.insert(0, numbers.pop());
        }
        return result;
    }

    // Write Linked List to a .txt file
    public void writeToFile() throws IOException {
        File file = new File("product_list.txt");
        FileWriter writer = new FileWriter(file);
        StringBuffer result = new StringBuffer();

        ProductNode current = head;
        while (current != null) {
            result.append(current.getProduct()).append("\n");
            current = current.getNext();
        }

        writer.write(result.toString());
        writer.close();
    }

    // Read File to LinkedList.
    // Type: Stack
    public void readFromFile() throws FileNotFoundException {
        readFromFile("product_list.txt");
    }
    public void readFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            Product newProduct = makeProduct(line);
            addToFront(newProduct);
        }
    }

    // Create a new Product using String array
    // Split by ","
    public Product makeProduct(String lineToParse) {
        String[] result = lineToParse.split(",");

        String code = result[0];
        String name = result[1];
        int quantity = Integer.parseInt(result[2]);
        double price = Double.parseDouble(result[3]);

        return new Product(code,name,quantity,price);
    }

    // Read File to LinkedList.
    // Type: Queue
    public void readFromFileToQueue() throws FileNotFoundException {
        readFromFileToQueue("product_list.txt");
    }
    public void readFromFileToQueue(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            Product newProduct = makeProduct(line);
            addToEnd(newProduct);
        }
    }


    public ProductNode getHead() {
        return head;
    }

    public void setHead(ProductNode head) {
        this.head = head;
    }

    public ProductNode getTail() {
        return tail;
    }

    public void setTail(ProductNode tail) {
        this.tail = tail;
    }

}
