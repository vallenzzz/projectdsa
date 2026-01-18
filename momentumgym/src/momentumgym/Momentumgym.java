/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package momentumgym;

import java.util.Scanner;

public class Momentumgym {
    
    static Node head = null;
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        char ch;
        boolean choice = true;

        while (choice) {
            System.out.println("\n\nA. Register Participant");
            System.out.println("B. Delete Registration");
            System.out.println("C. Display All Participants");
            System.out.println("D. Exit");
            System.out.print("Enter choice: ");
            ch = input.next().charAt(0);

            switch (ch) {
                case 'a':
                    new_participant();
                    break;
                case 'b':
                    delete_participants();
                    break;
                case 'c':
                    list_participants();
                    break;   
                case 'd':
                    choice = false;
                    break;
                default:
                    System.out.println("Enter only one from the above");
            }
        }
    }
    
    
    static void new_participant() { //create a new node(object)
         System.out.print("Enter Participant ID: ");
        String id = input.next();
        System.out.println("Enter Participant Name:");
        String name = input.next();
        System.out.print("Enter Participant Phone Number: ");
        String phoneno = input.next();
        System.out.println("Enter Participant Age:");
        int age = input.nextInt();
        System.out.print("Enter Class Name: ");
        String classname = input.next();
        System.out.println("Enter Participant Email:");
        String email = input.next();
        System.out.print("Enter Registration Date: ");
        String regdate = input.next();
        
        Node newNode = new Node(id, name, phoneno, email, age, classname, regdate);//create a new node(object) (newNode: object reference)

        if (head == null) { //condition to check if head is empty
            head = newNode; //if head is empty, set head to newNode
        } else {
            newNode.next = head; //if head is not empty, set newNode.next to head
            head = newNode; //set head to newNode
        }
    }
    
    static void delete_participants(){
      if (head == null) {
            System.out.println("\n\nThe list is empty. Nothing to delete!!!");
            return;
        }
        
        System.out.print("Enter Participant ID to be deleted: ");
        String deleteid = input.next();
        
        // Check if deleting the first node (head)
        if (head.id.equals(deleteid)) {
            head = head.next;
            System.out.println("Participant is deleted");
            return;
        }
        
        // Linear sequential search for nodes in the middle or end
        Node currentptr = head;
        Node prevptr = null;
        
        while (currentptr != null) {
            if (currentptr.id.equals(deleteid)) { // Found the node to delete
                prevptr.next = currentptr.next;
                System.out.println("Participant is deleted");
                return;
            }
            prevptr = currentptr;
            currentptr = currentptr.next;
        }
        
        System.out.println("Sorry, no match found"); // ID was not found

    }
    
    static void list_participants() { //list all numbers (node)
        if (head == null) {
            System.out.println("\nEmpty list");
            return;
        }

        Node currentptr = head;

        do {
            System.out.println("\n\n" + currentptr.id + "\t" + currentptr.name + "\t" + currentptr.phoneno + "\t" + currentptr.email + "\t" + currentptr.age + "\t" + currentptr.classname + "\t" + currentptr.regdate);
            currentptr = currentptr.next;
        } while (currentptr != null);
    }
}
