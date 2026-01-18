//Generating random numbers and writing them to a file:
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numRand, max, min, range;

        // Open a file for writing
        try {
            File file = new File("data.txt");
            PrintWriter output = new PrintWriter(file);

            Scanner inputScanner = new Scanner(System.in);

            System.out.print("\nHow many random numbers do you want to generate?: ");
            numRand = inputScanner.nextInt();
            System.out.print("Enter the maximum value for your random numbers: ");
            max = inputScanner.nextInt();
            System.out.print("Enter the minimum value for your random numbers: ");
            min = inputScanner.nextInt();

            Random rand = new Random();

            range = (max - min) + 1; // plus 1 because the max value can still be generated

            for (int i = 0; i < numRand; i++) {
                int randomValue = rand.nextInt(range) + min; // plus min to shift min & max value
                output.println(randomValue);
            }

            System.out.println("\ndata.txt has been successfully created");

            output.close(); // close the file
            inputScanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}


This Java code generates random numbers and writing them to a file.



