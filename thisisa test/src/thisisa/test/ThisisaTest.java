/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package thisisa.test;


public class ThisisaTest {

    private static final int maxsize = 10;
    public static void main(String[] args) {
        String test = "thisisataest";
        char[] array = test.toCharArray();
        int arraysize = array.length;
        
        bubbleSorttest(array, arraysize);
        printarray(array);
         
    }
    
    public static void bubbleSorttest(char array[], int arraysize) {
        int n = arraysize;
        
        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // If current element is less than next, swap them (for descending order)
                if (array[j] < array[j + 1]) {
                    // Exchange elements using exchange function
                    exchange(array, j, j + 1);
                }
            }
            System.out.print("Iteration " + (i + 1) + ": ");
            printarray(array);
        }
    }
    
    public static void exchange(char array[], int index1, int index2){
    char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    public static void printarray(char[] array){
        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
