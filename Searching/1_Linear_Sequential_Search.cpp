//Linear Sequential Search
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

        // Read in the search value for linear sequential search
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("\n\nEnter the search value for linear sequential search: ");
        searchValue = inputScanner.nextInt();

        // Linear sequential search for element
        seqSearch(data, numData, searchValue);

        inputScanner.close();
    }

    static void seqSearch(int[] data, int size, int searchValue) {
        int count = 0;

        for (int i = 0; i < size; i++) {
            count++;

            if (data[i] == searchValue) {
                System.out.println("\nSearch value found !");
                System.out.println("Number of comparisons: " + count);
                return;
            }
        }

        System.out.println("\nSorry, no match found");
        System.out.println("Number of comparisons: " + count);
    }
}
This Java code reads data from a file and performing a linear sequential search.
