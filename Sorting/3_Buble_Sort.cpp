// Java code that implements the Bubble Sort algorithm to sort an array of integers:

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list size: ");
        int numElements = scanner.nextInt();
        int[] data = new int[maxsize];

        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter number: ");
            data[i] = scanner.nextInt();
        }

        bubbleSort(data, numElements);

        System.out.print("Sorted list for bubble sort: ");
        for (int i = 0; i < numElements; i++) {
            System.out.print(" " + data[i]);
        }

        scanner.close();
    }

    public static void bubbleSort(int[] data, int numElements) {
        int temp;

        while (numElements > 1) {
            numElements--;

            for (int i = 0; i < numElements; i++) {
                if (data[i] > data[i + 1]) {
                    temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }
    }

    private static final int maxsize = 10;
}

This Java code performs the Bubble Sort algorithm to sort an array of integers. It uses the Scanner class for input and the bubbleSort function to perform the sorting. The maxsize constant is also defined at the end of the code.