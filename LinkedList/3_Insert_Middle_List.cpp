Here's the equivalent Java code for the given C code, which inserts numbers at a specific location (middle) of a linked list:

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

public class LinkedListInsertionAtMiddle {
    static Number headptr = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char ch;
        boolean choice = true;

        while (choice) {
            System.out.println("\n\ne - Enter a number");
            System.out.println("l - List all numbers");
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
                case 'x':
                    choice = false;
                    break;
                default:
                    System.out.println("Enter only one from the above");
            }
        }
    }

    static void new_number() {
        int location;
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        Number newptr = new Number(num);

        if (headptr == null) {
            headptr = newptr;
        } else {
            System.out.print("After what number you want to enter: ");
            location = scanner.nextInt();

            Number currentptr = headptr;
            while (currentptr != null) {
                if (currentptr.number == location) {
                    break;
                } else {
                    currentptr = currentptr.ptrnext;
                }
            }

            if (currentptr == null) {
                System.out.println("\nThe number you entered does not exist!!!");
            } else {
                newptr.ptrnext = currentptr.ptrnext;
                currentptr.ptrnext = newptr;
            }
        }

        list_number();
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
}
```

This Java code accomplishes the same functionality as the given C code, inserting numbers at a specified location in the linked list and displaying the list when requested by the user. In Java, we use classes to represent structures, and dynamic memory allocation is not required as in C. Instead, we create instances of the `Number` class to represent nodes in the linked list.