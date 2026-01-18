/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mergesort;

import java.util.Scanner;

public class MergeSort {

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
        long[] stats = mergeSort(data, numElements - 1);
        long endTime = System.nanoTime();
        double runningTime = (endTime - startTime) / 1_000_000_000.0;

        System.out.print("Sorted list for merge sort: ");
        for (int i = 0; i < numElements; i++) {
            System.out.print(" " + data[i]);
        }
        
        displayComparisons(stats[0]);
        displayMoves(stats[1]);
        displayRunningTime(runningTime);

        scanner.close();
    }
    
    public static long[] mergeSort(int[] data, int numElements) {
        long[] stats = new long[2]; // [comparisons, moves]
        mergeSortRecursive(data, 0, numElements - 1, stats);
        return stats;
    }
    
     public static void mergeSortRecursive(int[] data, int first, int last, long[] stats) {
        int middle;

        if (first < last) {
            middle = (first + last) / 2;
            mergeSortRecursive(data, first, middle, stats);
            mergeSortRecursive(data, middle + 1, last, stats);
            mergeList(data, first, middle, last, stats);
        }

    }

    public static void mergeList(int[] data, int first, int middle, int last, long[]stats) {
        int n1 = middle - first + 1;
        int n2 = last - middle;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copy data to temp arrays (count moves)
        for (int i = 0; i < n1; i++) {
            stats[1]++; // Count move
            leftArray[i] = data[first + i];
        }
        for (int j = 0; j < n2; j++) {
            stats[1]++; // Count move
            rightArray[j] = data[middle + 1 + j];
        }
        
        // Merge the temp arrays
        int i = 0, j = 0, k = first;
        
        while (i < n1 && j < n2) {
            stats[0]++; // Count comparison
            stats[1]++; // Count move when copying back
            if (leftArray[i] <= rightArray[j]) {
                data[k] = leftArray[i];
                i++;
            } else {
                data[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements (count moves)
        while (i < n1) {
            stats[1]++; // Count move
            data[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            stats[1]++; // Count move
            data[k] = rightArray[j];
            j++;
            k++;
        }
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
