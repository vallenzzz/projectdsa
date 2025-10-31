/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iterative;

/**
 *
 * @author User
 */
import java.util.Scanner;
public class Iterative {

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
        
        int total = iterative(i, n);
        
        System.out.println("total: " + total);
    }
    
    public static int iterative(int i, int n){
       
       int result = 0;
       
       while (i <= n){
       result = result + i;
       i++;
       }
        return result;
   }
    
}
