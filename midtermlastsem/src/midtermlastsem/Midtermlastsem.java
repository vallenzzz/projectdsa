/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package midtermlastsem;

/**
 *
 * @author User
 */
import java.util.Scanner;
public class Midtermlastsem {

    static VehicleNode head = null;
    static Scanner input = new Scanner(System.in);
    
    
    public static void main(String[] args) {
         char ch;
        boolean choice = true;

        while (choice) {
            System.out.println("\n\nR - Register Vehicle");
            System.out.println("D - Delete All Vehicles In List");
            System.out.println("L - List All Vehicles");
            System.out.println("X - Exit");
            System.out.print("Enter choice: ");
            ch = input.next().charAt(0);

            switch (ch) {
                case 'R':
                    register_vehicle(); //call the new_number method to create a new node(object)
                    break;
                case 'D':
                    delete_first_vehicle(); //call the list_number method to list all numbers
                    break;   
                case 'L':    
                    list_vehicles();
                    break;
                case 'X':
                    choice = false;
                    break;
                default:
                    System.out.println("Enter only one from the above");
            }
        }
    }
    
    static void register_vehicle(){
    System.out.print("Enter vehicle registration no: ");
        String vehicleregno = input.next();
        System.out.println("Enter owner name:");
        String ownername = input.next();
        System.out.println("Enter contact no");
        String contactno = input.next();
        
        VehicleNode newNode = new VehicleNode(vehicleregno, ownername, contactno);//create a new node(object) (newNode: object reference)

        if (head == null) { //condition to check if head is empty
            head = newNode; //if head is empty, set head to newNode
        } else {
            newNode.next = head; //if head is not empty, set newNode.next to head
            head = newNode; //set head to newNode
        }
    
    }
    
    
    static void delete_first_vehicle(){
    if (head == null){
    System.out.println("\n\n The list is empty. Nothing to delete");
    }else{
    head = head.next;
    }
    }
    
    static void list_vehicles(){
    if (head == null) {
            System.out.println("\nEmpty list");
            return;
        }

        VehicleNode currentptr = head;

        do {
            System.out.println("\n\n" + currentptr.vehicleregno + "\t" + currentptr.ownername + "\t" + currentptr.contactno);
            currentptr = currentptr.next;
        } while (currentptr != null);
    
    } 
}
