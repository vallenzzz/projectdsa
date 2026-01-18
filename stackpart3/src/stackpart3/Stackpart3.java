/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stackpart3;

import java.util.Scanner;

public class Stackpart3 { //stack using linked list
    static Node headptr, newptr, currentptr;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        char ch;
        headptr = null;

        do {
            System.out.println("\n\n[-------Stack Menu-------]");
            System.out.println("A - Push Stack");
            System.out.println("B - Pop Stack");
            System.out.println("D - Display Stack Content");
            System.out.println("X - Exit Menu");
            System.out.print("Please enter choice: ");

            Scanner scanner = new Scanner(System.in);
            ch = scanner.next().toUpperCase().charAt(0);

            switch (ch) {
                case 'A':
                    push();
                    break;
                case 'B':
                    pop();
                    break;
                case 'D':
                    display();
                    break;
                case 'X':
                    System.out.println("\nExit stack menu");
                    break;
                default:
                    System.out.println("\nInvalid entry. Please select A, B, D, X\n");
            }
        } while (ch != 'X');
    }

    
    static void push(){
    System.out.print("Enter a number: ");
        int num = input.nextInt();
        
        Node newNode = new Node(num);//create a new node(object)

        if (headptr == null) {
            headptr = newNode;
            
            
        } else {
            newNode.ptrnext = headptr;
            headptr = newNode;
        }

    }
    
    static void pop(){
     if (headptr == null) {
            System.out.println("\n\nThe list is empty. Nothing to delete!!!");
        } else {
            
            headptr = headptr.ptrnext;
            
        }

    }
    
    static void display(){
     if (headptr == null) {
            System.out.println("\nEmpty list");
            return;
        }

        Node currentNode = headptr;

        do {
            System.out.println("\n\n" + currentNode.number);
            currentNode = currentNode.ptrnext;
        } while (currentNode != null);

    }
    }
  
