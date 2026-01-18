/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package insertionsort;

import java.util.Scanner;

public class InsertionSort {

   private static final int maxsize = 10;
   
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

        System.out.print("How many numbers you want to enter: ");
        int numElements = scanner.nextInt();
        int[] data = new int[maxsize];

        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter number: ");
            data[i] = scanner.nextInt();
        }

        long startTime = System.nanoTime();
        long[] stats = insertionSort(data, numElements);
        long endTime = System.nanoTime();
        double runningTime = (endTime - startTime) / 1_000_000_000.0;

        System.out.print("Sorted list for insertion sort: ");
        for (int i = 0; i < numElements; i++) {
            System.out.print(" " + data[i]);
        }
        
        System.out.println();

        displayComparisons(stats[0]);
        displayMoves(stats[1]);
        displayRunningTime(runningTime);

        scanner.close();
    }
    
    public static long[] insertionSort(int[] data, int numElements) {
        long comparisons = 0;
        long moves = 0;
        int temp;
        for (int a = 1; a < numElements; a++) {
            temp = data[a];
            int b = a - 1;

            while (b >= 0 && temp < data[b]) {
                comparisons++;
                if(data[b]>temp){
                data[b + 1] = data[b];
                b--;
                }else{
                    break;
                }
            }
            if(b+1 !=a){
                moves++;
            data[b + 1] = temp;
            }
            }
            return new long[] {comparisons, moves};
        }

    
    public static void displayComparisons(long comparisons) {
        System.out.println("Number of data comparisons: " + comparisons);
    }

    public static void displayMoves(long moves) {
        System.out.println("Number of data moves: " + moves);
    }

    public static void displayRunningTime(double seconds) {
        System.out.println("Running time: " + seconds + " seconds");
    }

    
}
