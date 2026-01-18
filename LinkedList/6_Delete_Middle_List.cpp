Here's the equivalent Java code for the given C code, which deletes a specific number from the middle of a linked list:

```java
import java.util.Scanner;

class Number {
    int number;          // data field
    Number ptrnext;      // link field

    public Number(int number) {
        this.number = number;
        this.ptrnext = null;
    }
}

public class LinkedListDeletionAtMiddle {
    static Number headptr = null;
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
        Number newptr = new Number(num);

        if (headptr == null) {
            headptr = newptr;
        } else {
            newptr.ptrnext = headptr;
            headptr = newptr;
        }
    }

    static void list_number() {
        if (headptr == null) {
            System.out.println("\nEmpty list");
            return;
        }

        Number currentptr = headptr;

        do {
            System.out.println("\n\n" + currentptr.number);
            currentptr = currentptr.ptrnext;
        } while (currentptr != null);
    }

    static void delete_number() {
        if (headptr == null) {
            System.out.println("\n\nThe list is empty. Cannot delete!!!");
        } else {
            System.out.print("\nEnter number to delete: ");
            int number = scanner.nextInt();

            Number currentptr = headptr;
            Number previousptr = null;

            while (currentptr.ptrnext != null) {
                if (currentptr.number == number) {
                    break;
                } else {
                    previousptr = currentptr; // save the previous current address
                    currentptr = currentptr.ptrnext; // point to the next node
                }
            }

            if (currentptr.number == number) {
                if (currentptr == headptr) {
                    headptr = currentptr.ptrnext; // head points to the next node
                } else {
                    previousptr.ptrnext = currentptr.ptrnext; // previous node points to the next node
                }
                currentptr = null; // Set the reference to null to free the memory
            } else {
                System.out.println("\nNumber to be deleted is not in the list!!!");
            }
        }
    }
}
```

This Java code accomplishes the same functionality as the given C code, which deletes a specific number from the middle of the linked list and displays the list when requested by the user. In Java, we use classes to represent structures, and dynamic memory allocation is not required as in C. Instead, we create instances of the `Number` class to represent nodes in the linked list.