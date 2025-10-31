/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursive;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Recursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number:");
        int i = input.nextInt();
        System.out.println();
        
        System.out.println("Enter second number:");
        int n = input.nextInt();
        System.out.println();
        
        int total = recursive(i, n);
        
        System.out.println("total: " + total);
    }
    
    public static int recursive (int i, int n){
        
    if (i == n){ //stopping condition
    return i;
    }else{
        return (i + recursive(i+1, n));
    
    }
    
    
    }
    
}
