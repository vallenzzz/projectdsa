//Java code that performs insertion sort on an array of integers:

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many numbers you want to enter: ");
        int numElements = scanner.nextInt();
        int[] data = new int[maxsize];

        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter number: ");
            data[i] = scanner.nextInt();
        }

        insertionSort(data, numElements);

        System.out.print("Sorted list for insertion sort: ");
        for (int i = 0; i < numElements; i++) {
            System.out.print(" " + data[i]);
        }

        scanner.close();
    }

    public static void insertionSort(int[] data, int numElements) {
        int temp;
        for (int a = 1; a < numElements; a++) {
            temp = data[a];
            int b = a - 1;

            while (b >= 0 && temp < data[b]) {
                data[b + 1] = data[b];
                b--;
            }

            data[b + 1] = temp;
        }
    }

    private static final int maxsize = 10;
}

This Java code performs insertion sort on an array of integers. It uses the Scanner class for input, and the insertionSort function sorts the array in ascending order. The maxsize constant is also defined at the end of the code.
