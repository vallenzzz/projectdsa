//  Java code that implements the Merge Sort algorithm to sort an array of integers

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list size: ");
        int numElements = scanner.nextInt();
        int[] data = new int[maxsize];

        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter number: ");
            data[i] = scanner.nextInt();
        }

        mergeSort(data, 0, numElements - 1);

        System.out.print("Sorted list for merge sort: ");
        for (int i = 0; i < numElements; i++) {
            System.out.print(" " + data[i]);
        }

        scanner.close();
    }

    public static void mergeSort(int[] data, int first, int last) {
        int middle;

        if (first < last) {
            middle = (first + last) / 2;
            mergeSort(data, first, middle);
            mergeSort(data, middle + 1, last);
            mergeList(data, first, middle, last);
        }
    }

    public static void mergeList(int[] data, int first, int middle, int last) {
        int L, R, count, i;
        int[] temp = new int[maxsize];

        L = first;
        count = first;
        R = middle + 1;

        while ((L <= middle) && (R <= last)) {
            if (data[L] <= data[R]) {
                temp[count] = data[L];
                L++;
            } else {
                temp[count] = data[R];
                R++;
            }
            count++;
        }

        if (L > middle) {
            for (i = R; i <= last; i++) {
                temp[count] = data[i];
                count++;
            }
        } else {
            for (i = L; i <= middle; i++) {
                temp[count] = data[i];
                count++;
            }
        }

        for (i = first; i <= last; i++) {
            data[i] = temp[i];
        }
    }

    private static final int maxsize = 10;
}

This Java code implements the Merge Sort algorithm to sort an array of integers. It uses the Scanner class for input and the mergeSort and mergeList functions to perform the sorting. The maxsize constant is also defined at the end of the code.