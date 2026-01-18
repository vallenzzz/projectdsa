//Java code that implements the Quick Sort algorithm to sort an array of integers

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list size: ");
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

    public static void quickSort(int[] data, int bottom, int top) {
        int left, right, temp, pivot, flag;
        if (top > bottom) {
            pivot = data[top];
            right = top;
            left = bottom - 1;
            do {
                flag = 1;
                while (data[++left] < pivot);
                while (data[--right] > pivot);
                if (left < right) {
                    temp = data[left];
                    data[left] = data[right];
                    data[right] = temp;
                } else {
                    break;
                }
            } while (flag > 0);
            temp = data[left];
            data[left] = data[top];
            data[top] = temp;

            quickSort(data, bottom, left - 1);
            quickSort(data, left + 1, top);
        }
    }

    private static final int maxsize = 10;
}

This Java code implements the Quick Sort algorithm to sort an array of integers. It uses the Scanner class for input and the quickSort function to perform the sorting. The maxsize constant is also defined at the end of the code.




