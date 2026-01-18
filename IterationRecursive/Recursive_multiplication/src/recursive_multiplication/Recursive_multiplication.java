import java.util.Scanner;

public class Recursive_multiplication{
    
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        System.out.print("Enter how many times: ");
        int times = scanner.nextInt();

        System.out.printf("Result %d * %d = %d%n", num, times, multiply(num, times));
    }

    // Recursive multiplication
    public static int multiply(int num, int times) {
        if (times == 1) {
            return num;
        } else {
            return num + multiply(num, times - 1);
        }
    }
}
