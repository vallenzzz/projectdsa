import java.util.Scanner;

public class Recursive_factorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int number = input.nextInt();
        int factNum = fact(number);
        System.out.printf("Factorial number for %d! = %d  %n", number, factNum);
    }
    
    
     public static int fact(int number) {
        if (number == 0) { // stopping condition
            return 1;
        } else {
            return (number * fact(number - 1));
        }
    }
}