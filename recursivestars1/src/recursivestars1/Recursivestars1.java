/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursivestars1;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Recursivestars1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number:");
        int i = input.nextInt();
        System.out.println();
        
        recursive(i);
    }
    
    public static void recursive (int i){
        int x = 0;
        
        if (i<=0){
        return;
        }else{
            
        for (x = 0; x < i; x++){
        System.out.print("*");
        }
        
        System.out.println();
        recursive(i-1);
        }   
    }
}
