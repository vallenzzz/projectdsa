/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queuelinkedlist;
import java.util.Scanner;

public class Queuelinkedlist {
    static Node front = null; //head
    static Node rear = null;
    static int totalPeople = 0;
    
    static Scanner input = new Scanner(System.in); // global scanner


    public static void main(String[] args) {
        char ch;
        int choice = 1;

        while (choice == 1) {
            System.out.println("\n[----------- Family Group Info -----------]");
            System.out.println("A - Add Family into queue");
            System.out.println("B - Delete family from queue");
            System.out.println("D - Display family queue content");
            System.out.println("X - Exit");
            System.out.print("Enter choice: ");
            ch = input.next().charAt(0);
            input.nextLine();
            ch = Character.toUpperCase(ch);

            switch (ch) {
                case 'A':
                    enqueue();
                    break;
                case 'B':
                    dequeue();
                    break;
                case 'D':
                    listNode();
                    break;
                case 'X':
                    choice = 0;  // Exit loop
                    break;
                default:
                    System.out.println("Invalid choice. Please select A, B, D, or X.");
            }

    }   
    }
    
    public static void enqueue() {
        
    System.out.print("Enter Head of Family Name: ");
    String headoffamily = input.nextLine();
    
    System.out.print("Enter Number of Family Members including head: ");
    int familysize = input.nextInt();
    input.nextLine();
    
    
    System.out.print("Enter Head of Family Phone No: ");
    String phoneno = input.nextLine();
    
    if (totalPeople + familysize > 100){
    System.out.println("Cannot add family! Total people would exceed 100 (Current: " + totalPeople + ", Adding: " + familysize + ").");
    }
           
    Node newNode = new Node(headoffamily, familysize, phoneno);
    
    //newNode.next = null;

    if (front == null) { //first node, list is empty
        front = newNode;
        rear = newNode;
        
    } else { //not first node, list is not empty
        rear.next = newNode;
        rear = newNode;
    }
    
    totalPeople = totalPeople + familysize;

    System.out.println("Family added to queue.");
}
    
    public static void dequeue() {
    if (front == null) {
        System.out.println("Queue is empty.");
        return;
    }
    totalPeople = totalPeople - front.familysize;

    System.out.println("Dequeued family: Family of " + front.headoffamily);
    front = front.next;

    if (front == null) {
        rear = null;
        totalPeople = 0;
// Reset rear if queue is now empty
    }
}
    
    public static void listNode() {
    if (front == null) {
        System.out.println("Queue is empty.");
        return;
    }

    System.out.println("Family Queue contents:");
    
    Node current = front;
    while (current != null) {
        System.out.print("\n\n" + "Head of Family Name: " + current.headoffamily + "\n" + "Family Size: " + current.familysize + "\n" + "Head of Family Phone Nummber: " + current.phoneno);
        current = current.next;
    }
    System.out.println(); // newline after list
}
    
}
