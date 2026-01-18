/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesort;

import java.util.Scanner;
public class BubbleSort {

    private static final int maxsize = 10;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list size: ");
        int numElements = scanner.nextInt();
        int[] data = new int[maxsize];

        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter number: ");
            data[i] = scanner.nextInt();
        }

        long startTime = System.nanoTime();
        long[] stats = bubbleSort(data, numElements);
        long endTime = System.nanoTime();
        double runningTime = (endTime - startTime) / 1_000_000_000.0;

        System.out.print("Sorted list for bubble sort: ");
        for (int i = 0; i < numElements; i++) {
            System.out.print(" " + data[i]);
        }
        
        displayComparisons(stats[0]);
        displayMoves(stats[1]);
        displayRunningTime(runningTime);

        scanner.close();
    }
    
    public static long[] bubbleSort(int[] data, int numElements) {
        int comparisons = 0;
        int moves = 0;
        int temp;

        while (numElements > 1) {
            numElements--;

            for (int i = 0; i < numElements; i++) {
                comparisons++;
                if (data[i] > data[i + 1]) {
                    moves +=3;
                    temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
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
