//Java code that performs selection sort on an array of integers

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

        selectionSort(data, numElements);

        System.out.print("Sorted list for selection sort: ");
        for (int i = 0; i < numElements; i++) {
            System.out.print(" " + data[i]);
        }

        scanner.close();
    }

    public static void selectionSort(int[] data, int numElements) {
        int smallest, temp;
        for (int a = 0; a < numElements; a++) {
            smallest = a;
            for (int b = a + 1; b < numElements; b++) {
                if (data[b] < data[smallest]) {
                    smallest = b;
                }
            }
            temp = data[a];
            data[a] = data[smallest];
            data[smallest] = temp;
        }
    }
}

This Java code uses Java syntax and the Scanner class for input.

