/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursivestars2;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Recursivestars2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number:");
        int i = input.nextInt();
        System.out.println();
        
        ascending(i);
        descending(i-1);
    }
    
    public static void ascending (int i){
        int x = 0;
        
        if (i<=0){
        return;
        }else{
        
        ascending(i-1);
        
        if (x < i){
        System.out.print(" ");
        }
            
        for (x = 0; x < i; x++){
        System.out.print("*");
        
        if (x < i){System.out.print(" ");}
        }
        System.out.println();
        }   
    }
    
    public static void descending (int i){
        int x = 0;
        
        if (i<=0){
        return;
        }else{
            
        if (x < i){System.out.print(" ");}
            
        for (x = 0; x < i; x++){
        System.out.print("*");
        if (x < i){
        System.out.print(" ");
        }
        }
        System.out.println();
        descending(i-1);
        }   
    }
}
