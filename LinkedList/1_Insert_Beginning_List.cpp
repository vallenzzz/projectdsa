
import java.util.Scanner;

class Number {
    int number;          // data field

    Number next;      // link field
                 //pointing (referring) to the next node in the linked list.

    public Number(int number) {  //contructor
        this.number = number;

        this.next = null;
    }
}

public class LinkedListInsertion {
    static Number head = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char ch;
        boolean choice = true;

        while (choice) {
            System.out.println("\n\ne - Enter a number");
            System.out.println("l - List all numbers");
            System.out.println("d - Delete a number");
            System.out.println("x - Exit");
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
                    System.out.println("Enter only one from the above");
            }
        }
    }

    static void new_number() {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        Number newNode = new Number(num);//create a new node(object)

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    static void list_number() {
        if (head == null) {
            System.out.println("\nEmpty list");
            return;
        }

        Number currentptr = head;

        do {
            System.out.println("\n\n" + currentptr.number);
            currentptr = currentptr.next;
        } while (currentptr != null);
    }


     static void delete_number() {
        if (head == null) {
            System.out.println("\n\nThe list is empty. Nothing to delete!!!");
        } else {
            Number current = head;
            head = head.next;
            current = null; // Set the reference to null to free the memory
        }
    }
}
