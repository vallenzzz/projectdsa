import java.util.Scanner;

public class StackExample {
    static int top = -1; // Step 1: Initialize the top of the stack to -1
    static int MAXSTACK = 3; // Step 2: Define the maximum stack size
    static int[] stack = new int[MAXSTACK]; // Step 3: Create an integer array to represent the stack
    static int i, getPush;
    static char ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n\nThe top value is now " + top);
            System.out.println("\n[-------Stack Menu-------]");
            System.out.println("A - Push Stack");
            System.out.println("B - Pop Stack");
            System.out.println("D - Display Stack Content");
            System.out.println("X - Exit Menu");
            System.out.print("Please enter choice: ");

            ch = scanner.next().charAt(0);
            ch = Character.toUpperCase(ch);

            switch (ch) {
                case 'A':
                    System.out.print("Please enter the number to push stack: ");
                    getPush = scanner.nextInt();
                    push(getPush); // Step 4: Push operation
                    break;

                case 'B':
                    System.out.println("Pop the stack");
                    pop(); // Step 5: Pop operation
                    break;

                case 'D':
                    display(top); // Step 6: Display the contents of the stack
                    break;

                case 'X':
                    System.out.println("Exit stack menu");
                    break;

                default:
                    System.out.println("Invalid entry. Please select A, B, D, X");
            }
        } while (ch != 'X');

        scanner.close();
    }

    static void push(int item) {
        if (top + 1 == MAXSTACK) {
            System.out.println("\n!!! stack OVERFLOW - can't push stack !!!");
            return;
        } else {
            stack[++top] = item; // Step 7: Insertion (push) into the stack
            display(top);
        }
    }

    static void pop() {
        if (top < 0) {
            System.out.println("\n!!! stack UNDERFLOW - can't pop stack !!!");
            return;
        } else {
            top = top - 1; // Step 8: Removal (pop) from the stack
            display(top);
        }
    }

    static void display(int list) {
        System.out.println("\nContents of stack: ");
        if (list == -1) {
            System.out.println("The stack is now empty");
        } else {
            for (i = 0; i <= list; i++) {
                System.out.println("Number at location stack " + i + " = " + stack[i]);
            }
        }
    }
}


This Java code demonstrates a basic stack operation menu.
