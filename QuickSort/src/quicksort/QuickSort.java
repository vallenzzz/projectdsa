/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quicksort;

import java.util.Scanner;
public class QuickSort {

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
        long[] stats = quickSort(data, numElements-1);
        long endTime = System.nanoTime();
        double runningTime = (endTime - startTime) / 1_000_000_000.0;

        System.out.print("Sorted list for quick sort: ");
        for (int i = 0; i < numElements; i++) {
            System.out.print(" " + data[i]);
        }
        
        displayComparisons(stats[0]);
        displayMoves(stats[1]);
        displayRunningTime(runningTime);

        scanner.close();
    }
    
    public static long[] quickSort(int[] data, int numElements) {
        long[] stats = new long[2]; // [comparisons, moves]
        quickSortRecursive(data, 0, numElements - 1, stats);
        return stats;
    }
    
    public static void quickSortRecursive(int[] data, int first, int last, long[] stats) {
        if (first < last) {
            int pivotLocation = partition(data, first, last, stats);
            quickSortRecursive(data, first, pivotLocation - 1, stats);
            quickSortRecursive(data, pivotLocation + 1, last, stats);
        }
    }

    public static int partition(int[] data, int first, int last, long[] stats) {
         int pivot = data[last];
        int i = first - 1;
        
        for (int j = first; j < last; j++) {
            stats[0]++; // Count comparison
            if (data[j] < pivot) {
                i++;
                // Swap - 3 moves per swap
                stats[1] += 3;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        
        // Swap pivot to correct position - 3 moves
        stats[1] += 3;
        int temp = data[i + 1];
        data[i + 1] = data[last];
        data[last] = temp;
        
        return i + 1;
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
