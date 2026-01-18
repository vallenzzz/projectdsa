/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlistclinictreatment;

/**
 *
 * @author User
 */
import java.util.Scanner;
public class Linkedlistclinictreatment {
    
    static Scanner input = new Scanner(System.in);
    static clinicroom  head = null;
    public static void main(String[] args) {
        char ch;
        boolean choice = true;

        while (choice) {
            System.out.println("\n\ne - Enter new patient");
            System.out.println("l - List all patients");
            System.out.println("x - Exit");
            System.out.print("Enter choice: ");
            ch = input.next().charAt(0);

            switch (ch) {
                case 'e':
                    new_patient(); //call the new_number method to create a new node(object)
                    break;
                case 'l':
                    list_patient(); //call the list_number method to list all numbers
                    break;   
                case 'x':
                    choice = false;
                    break;
                default:
                    System.out.println("Enter only one from the above");
            }
        }
    }
    
    static void new_patient() { //create a new node(object)
        System.out.print("Enter room number: ");
        int room = input.nextInt();
        System.out.println("Enter patient number:");
        String patientnumber = input.next();
        
        clinicroom newNode = new clinicroom(room, patientnumber);//create a new node(object) (newNode: object reference)

        if (head == null) { //condition to check if head is empty
            head = newNode; //if head is empty, set head to newNode
        } else {
            clinicroom currentNode = head; //sets currentnode as head
            
            while (currentNode.next != null){ //find node to beinserted
            currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }
    
    static void list_patient() { //list all numbers (node)
        if (head == null) {
            System.out.println("\nEmpty list");
            return;
        }

        clinicroom currentptr = head;

        do {
            System.out.println("\n\n" + currentptr.room + "\t" + currentptr.patientnumber);
            currentptr = currentptr.next;
        } while (currentptr != null);
    }
    
}
