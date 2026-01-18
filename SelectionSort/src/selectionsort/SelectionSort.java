/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selectionsort;

import java.util.Scanner;
public class SelectionSort {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list size: ");
        int numElements = scanner.nextInt();
        int[] data = new int[numElements];

        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter number: ");
            data[i] = scanner.nextInt();
        }
        
        
        long startTime = System.nanoTime();
        long[] stats = selectionSort(data, numElements);
        long endTime = System.nanoTime();
        double runningTime = (endTime - startTime) / 1_000_000_000.0;

        System.out.print("Sorted list for selection sort: ");
        for (int i = 0; i < numElements; i++) {
            System.out.print(" " + data[i]);
        }
        
        System.out.println();

        displayComparisons(stats[0]);
        displayMoves(stats[1]);
        displayRunningTime(runningTime);

        scanner.close();
    }
    
    public static long[] selectionSort(int[] data, int numElements) {
        long comparisons = 0;
        long moves = 0;
        int smallest, temp;
        for (int a = 0; a < numElements; a++) {
            smallest = a;
            for (int b = a + 1; b < numElements; b++) {
                comparisons++;
                if (data[b] < data[smallest]) {
                    smallest = b;
                }
            }
            if (smallest != 3){
            moves += 3;
            temp = data[a];
            data[a] = data[smallest];
            data[smallest] = temp;
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
