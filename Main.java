import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ProductDoublyLinkedList list = new ProductDoublyLinkedList();
    public static ProductDoublyLinkedStack stack = new ProductDoublyLinkedStack();
    public static ProductDoublyLinkedQueue queue = new ProductDoublyLinkedQueue();

    public static void main(String[] args) throws IOException {

        // Yêu cầu nâng cao: Tiêu chí 15
        // Để in ra Console thì vô hiệu hóa function này.
        setOutputToFile();

        // Hiển thị Menu chính của chương trình
        displayMenu();

        // Mẫu Code
        /*
        Product rice = new Product("A", "Rice", 200, 50);
        Product noodle = new Product("B", "Noodle", 25, 100);
        Product apple = new Product("C", "Apple", 250, 2000);
        Product macbook = new Product("D", "Macbook", 450, 4000);
        Product water = new Product("E", "Water", 990, 20);
        Product chair = new Product("F", "Chair", 350, 1200);
        list.addToEnd(rice);
        list.addToEnd(noodle);
        list.addToFront(macbook);
        list.removeAtEnd();
        list.removeAtEnd();
        list.removeAtEnd();
        list.addToEnd(apple);
        list.removeAtFront();
        list.addToFront(chair);
        list.removeAtEnd();
        list.addToEnd(water);
        list.traverse();
         */
    }


    public static void displayMenu() throws IOException {
        boolean quit = false;
        while (!quit) {
            displayOptions();
            int input = getInput();
            switch (input) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    list.readFromFile();
                    list.traverse();
                    break;
                case 2:
                    list.addToEnd();
                    break;
                case 3:
                    list.traverse();
                    break;
                case 4:
                    list.writeToFile();
                    break;
                case 5:
                    list.searchByCode();
                    break;
                case 6:
                    list.removeByCode();
                    break;
                case 7:
                    list.sortByCode();
                    break;
                case 8:
                    list.convertFirstItemQuantityToBinary();
                    break;
                case 9:
                    stack.readFromFile();
                    stack.traverse();
                    break;
                case 10:
                    queue.readFromFileToQueue();
                    queue.traverse();
                    break;
                default:
                    System.out.println("Input is not valid.");
                    System.out.println("Please try again: (from 0 - 10");
                    break;
            }


        }
        System.out.println("✅ Bye, have a nice day!️");

    }
    public static int getInput() {
        System.out.print("Enter your option: ");
        return sc.nextInt();
    }

    public static void displayOptions() {
        System.out.println("""
                    ----MENU----
                    0. Exit
                    1. Read file and display
                    2. Add new object (to end)
                    3. Traverse
                    4. Write file
                    5. Search by code
                    6. Remove by code
                    7. Sort by code
                    8. Convert first product's quantity to Binary
                    9. Write file to stack and display
                    10. Write file to queue and display
                    """);
    }

    // Print to console_output.txt instead of Console
    public static void setOutputToFile() throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("console_output.txt", true));
        System.setOut(out);
    }

}
