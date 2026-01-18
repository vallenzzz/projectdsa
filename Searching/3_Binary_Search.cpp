//Binary Search
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numData = 0;
        int[] data = new int[10000];
        int searchValue;

        // Read in values from data.txt
        try {
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);

            System.out.println("The random numbers in data.txt are:\n");

            while (scanner.hasNextInt()) {
                data[numData] = scanner.nextInt();
                System.out.print(data[numData] + "\t");
                numData++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

        // Sort list in ascending order
        Arrays.sort(data, 0, numData);

        // Display (sorted) list of numbers entered earlier by the user
        System.out.println("\nSorted list of elements entered: ");
        for (int i = 0; i < numData; i++) {
            System.out.print(data[i] + "\t");
        }

        // Read in the search value for binary search
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("\n\nEnter the search value for binary search: ");
        searchValue = inputScanner.nextInt();

        // Call the binary search function
        binarySearch(data, numData, searchValue);

        inputScanner.close();
    }

    static void binarySearch(int[] data, int size, int searchValue) {
        int first = 0;
        int last = size - 1;
        int mid;
        int count = 0;

        while (first <= last) {
            count++;
            mid = (first + last) / 2;
            System.out.println("\nValue for mid: " + mid);

            if (searchValue == data[mid]) {
                System.out.println("\nSearch value found !");
                System.out.println("Number of comparisons: " + count);
                return;
            } else if (searchValue < data[mid]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        System.out.println("\nSorry, no match found !");
        System.out.println("Number of comparisons: " + count);
    }
}

This Java code reads data from a file, sorting the data in ascending order, and performing a binary search.
