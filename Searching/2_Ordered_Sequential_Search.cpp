//Ordered Sequential Search
import java.io.*;
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
        for (int x = 0; x < numData; x++) {
            for (int y = x + 1; y < numData; y++) {
                if (data[x] > data[y]) {
                    int temp = data[x];
                    data[x] = data[y];
                    data[y] = temp;
                }
            }
        }

        // Display (sorted) list of numbers entered earlier by the user
        System.out.println("\nSorted list of elements entered: ");
        for (int i = 0; i < numData; i++) {
            System.out.print(data[i] + "\t");
        }

        // Read in the search value for ordered Sequential search
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("\n\nEnter the search value for ordered sequential search: ");
        searchValue = inputScanner.nextInt();

        // Order sequential search for element
        orderSeqSearch(data, numData, searchValue);

        inputScanner.close();
    }

    static void orderSeqSearch(int[] data, int size, int searchValue) {
        int count = 0;
        int i = size - 1;

        while (i >= 0) {
            count++;

            if (data[i] == searchValue) {
                System.out.println("\nSearch value found !");
                System.out.println("Number of comparisons: " + count);
                return;
            } else if (data[i] < searchValue) { // Terminate the search if the data item < keyfield
                System.out.println("\nSorry, no match found");
                System.out.println("Number of comparisons: " + count);
                return;
            }
            i--; // Reduce the size of array for searching
        }

        System.out.println("\nSorry, no match found.");
        System.out.println("Number of comparisons: " + count);
    }
}

This Java code reads data from a file, sorting the data in ascending order, and performing an ordered sequential search.