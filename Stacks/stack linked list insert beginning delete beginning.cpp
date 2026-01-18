// Program to illustrates the deletion at beginning of a linked list

import java.util.Scanner;

public class LinkedListExample {

    static class Number {
        int number;
        Number ptrnext;
    }

    static Number headptr, newptr, currentptr;

    public static void main(String[] args) {
        char ch;
        boolean choice = true;

        headptr = null;
        Scanner scanner = new Scanner(System.in);

        while (choice) {
            System.out.println("\n\ne - Enter a number");
            System.out.println("l - List all numbers");
            System.out.println("d - Delete a number");
            System.out.println("x - Exit\n");
            System.out.print("Enter choice: ");
            ch = scanner.next().charAt(0);

            switch (ch) {
                case 'e':
                    new_number();
                    break;
                case 'l':
                    list_number();
                    break;
                case 'd':
                    delete_number();
                    break;
                case 'x':
                    choice = false;
                    break;
                default:
                    System.out.println("\nEnter only one from the above");
            }
        }

        scanner.close();
    }

    static void new_number() {
        newptr = new Number();

        if (headptr == null) {
            headptr = newptr;
            newptr.ptrnext = null;
        } else {
            newptr.ptrnext = headptr;
            headptr = newptr;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a number: ");
        newptr.number = scanner.nextInt();
    }

    static void list_number() {
        if (headptr == null) {
            System.out.println("\nEmpty list");
            return;
        }

        currentptr = headptr;
        do {
            System.out.println("\n\n" + currentptr.number);
            currentptr = currentptr.ptrnext;
        } while (currentptr != null);
    }

    static void delete_number() {
        if (headptr == null) {
            System.out.println("\n\nThe list is empty. Cannot delete!!!");
        } else {
            currentptr = headptr;
            headptr = headptr.ptrnext;
            currentptr = null;
        }
    }
}


Please note that this code uses Java's Scanner class to read input 







