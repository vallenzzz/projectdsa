/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fypstacklinkedlist;

import java.util.Scanner;

public class FYPstacklinkedlist {
static Node headptr, newptr, currentptr;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int ch;
        headptr = null;

        do {
            System.out.println("\n\n### Welcome to FYP Logbook ###");
            System.out.println("1. - Enter New Progress");
            System.out.println("2. - List All Progress");
            System.out.println("3. - Remove Progress");
            System.out.println("4. - Exit");
            System.out.print("Please enter choice: ");

            ch = input.nextInt();

            switch (ch) {
                case 1:
                    push();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    pop();
                    break;
                case 4:
                    System.out.println("\nExit stack menu");
                    break;
                default:
                    System.out.println("\nInvalid entry. Please select 1, 2, 3, 4\n");
            }
        } while (ch != 4);
    }

    
    static void push(){
    System.out.println("In progress ");   
    
    System.out.print("Week: ");
    int week = input.nextInt();
    input.nextLine();
    
    System.out.print("Enter Start time: ");
    String starttime = input.nextLine();
    
    System.out.print("Enter end time: ");
    String endtime = input.nextLine();
    
    System.out.print("Enter discussion details: ");
    String discussiondetails = input.nextLine();
    
    System.out.print("Enter platform used: ");
    String platformused = input.nextLine();
    
    System.out.print("Enter your supervisor's feedback: ");
    String svfeedback = input.nextLine();
        
        Node newNode = new Node(week, starttime, endtime, discussiondetails, platformused, svfeedback); //create a new node(object)

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
        int position = 1;

        do {
            
            System.out.println("\n\n" + "-----------[" + position + "]-----------" + "\n"
                                      + "Week: " + currentNode.week +"\n"
                                      + "Start time: " + currentNode.starttime + "\n"
                                      + "End time: " + currentNode.endtime + "\n"
                                      + "Discussion details: " + currentNode.discussiondetails + "\n"
                                      + "Platform: " + currentNode.platformused + "\n"
                                      + "Supervisor's feedback: " + currentNode.svfeedback);
            
            position++;
            currentNode = currentNode.ptrnext;
        } while (currentNode != null);

    }
}
