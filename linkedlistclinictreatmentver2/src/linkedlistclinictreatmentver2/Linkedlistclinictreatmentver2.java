/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlistclinictreatmentver2;

/**
 *
 * @author User
 */
import java.util.Scanner;
public class Linkedlistclinictreatmentver2 {

    static Scanner input = new Scanner(System.in);
    static clinicroom head = null;
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
        int location;
        System.out.print("Enter room number: ");
        int room = input.nextInt();
        System.out.println("Enter patient number:");
        String patientnumber = input.next();
        
        clinicroom newNode = new clinicroom(room, patientnumber);//create a new node(object) (newNode: object reference)

        if (head == null) { //condition to check if head is empty
            head = newNode; //if head is empty, set head to newNode
        } else {
            System.out.println("After what room number you want to enter");
            location = input.nextInt();
            
            clinicroom currentNode = head; // start at the head of the list
            while (currentNode != null){ //traverse the list to find the number after which the new number will be insreted 
            if (currentNode.room == location){ //if number is found, break the loop
            break; //exit while loop, straight to the if (currentNode)
            } else { //if number is not found, move to the next node
            currentNode = currentNode.next;
            }
            }
            
            if (currentNode == null){ //if number is not found, print error message
            System.out.println("The number you entered does not exist.");
            }else{
            newNode.next = currentNode.next; //link field of new node points to the next node
            currentNode.next = newNode; //link field of current node points to the new node
            }
        }
        
        list_patient();
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
