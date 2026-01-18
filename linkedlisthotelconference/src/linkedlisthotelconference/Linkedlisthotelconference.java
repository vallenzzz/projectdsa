/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlisthotelconference;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class Linkedlisthotelconference {

    static Room head = null;
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        char ch;
        boolean choice = true;

        while (choice) {
            System.out.println("\n\ne - Enter an event");
            System.out.println("l - List all events");
            System.out.println("x - Exit");
            System.out.print("Enter choice: ");
            ch = input.next().charAt(0);

            switch (ch) {
                case 'e':
                    new_event(); //call the new_number method to create a new node(object)
                    break;
                case 'l':
                    list_event(); //call the list_number method to list all numbers
                    break;   
                case 'x':
                    choice = false;
                    break;
                default:
                    System.out.println("Enter only one from the above");
            }
        }
    }
    
    
    static void new_event() { //create a new node(object)
        System.out.print("Enter room number: ");
        int room = input.nextInt();
        System.out.println("Enter event name");
        String event = input.next();
        
        Room newNode = new Room(room, event);//create a new node(object) (newNode: object reference)

        if (head == null) { //condition to check if head is empty
            head = newNode; //if head is empty, set head to newNode
        } else {
            newNode.next = head; //if head is not empty, set newNode.next to head
            head = newNode; //set head to newNode
        }
    }
    
    static void list_event() { //list all numbers (node)
        if (head == null) {
            System.out.println("\nEmpty list");
            return;
        }

        Room currentptr = head;

        do {
            System.out.println("\n\n" + currentptr.room + "\t" + currentptr.event);
            currentptr = currentptr.next;
        } while (currentptr != null);
    }
    
}
