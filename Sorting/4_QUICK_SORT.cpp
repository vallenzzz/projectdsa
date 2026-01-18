//Java code that implements the Quick Sort algorithm to sort an array of integers

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many numbers you want to enter: ");
        int numElements = scanner.nextInt();
        int[] data = new int[maxsize];

        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter number: ");
            data[i] = scanner.nextInt();
        }

        quickSort(data, 0, numElements - 1);

        System.out.print("Sorted list for quick sort: ");
        for (int i = 0; i < numElements; i++) {
            System.out.print(" " + data[i]);
        }

        scanner.close();
    }

    public static void quickSort(int[] data, int first, int last) {
        if (first < last) {
            int pivotLocation = partition(data, first, last);
            quickSort(data, first, pivotLocation - 1);
            quickSort(data, pivotLocation + 1, last);
        }
    }

    public static int partition(int[] data, int first, int last) {
        int pivot = data[first];
        int smallIndex = first;

        for (int index = first + 1; index <= last; index++) {
            if (data[index] < pivot) {
                smallIndex++;
                swap(data, smallIndex, index);
            }
        }
        swap(data, first, smallIndex);

        return smallIndex;
    }

    public static void swap(int[] data, int first, int second) {
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    private static final int maxsize = 10;
}

This Java code implements the Quick Sort algorithm to sort an array of integers. It uses the Scanner class for input and the quickSort, partition, and swap functions to perform the sorting. The maxsize constant is also defined at the end of the code.