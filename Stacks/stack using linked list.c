import java.util.Scanner;

class StackNode {
    int data;
    StackNode next;
}

public class StackUsingLinkedList {
    static StackNode stackHead = null; // Step 1: Initialize the stack as empty
    static StackNode newNode, delNode, displayNode;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, value;

        System.out.println(":: Stack using Linked List ::");

        while (true) {
            System.out.println("\n****** MENU ******");
            System.out.println("1. Push\n2. Pop\n3. Display\n4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to be inserted: ");
                    value = scanner.nextInt();
                    push(value); // Step 2: Push operation
                    break;
                case 2:
                    pop(); // Step 3: Pop operation
                    break;
                case 3:
                    display(); // Step 4: Display the contents of the stack
                    break;
                case 4:
                    scanner.close();
                    System.exit(0); // Step 5: Exit the program
                default:
                    System.out.println("\nWrong selection!!! Please try again!!!");
            }
        }
    }

    static void push(int value) {
        newNode = new StackNode();
        newNode.data = value;

        if (stackHead == null) {
            newNode.next = null;
        } else {
            newNode.next = stackHead;
        }

        stackHead = newNode; // Step 6: Insertion at the top of the stack
        System.out.println("\nInsertion is Success!!!");
    }

    static void pop() {
        if (stackHead == null) {
            System.out.println("\nStack is Empty!!!");
        } else {
            delNode = stackHead;
            System.out.println("\nDeleted element: " + delNode.data);
            stackHead = delNode.next; // Step 7: Removal of the top element
        }
    }

    static void display() {
        if (stackHead == null) {
            System.out.println("\nStack is Empty!!!");
        } else {
            displayNode = stackHead;
            while (displayNode.next != null) {
                System.out.print(displayNode.data + "--->"); // Step 8: Display elements
                displayNode = displayNode.next;
            }
            System.out.println(displayNode.data + "--->NULL");
        }
    }
}

This Java code demonstrates stack using a linked list. The user can push elements onto the stack, pop elements from the stack, display the contents of the stack, and exit the program.