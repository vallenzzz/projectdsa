import java.util.Scanner;

public class Fibonacci{
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number for Fibonacci sequence: ");
        int num = input.nextInt();
        System.out.printf("Fibonacci %d = %d %n", num, fib(num));
    }


   public static int fib(int num) {
        if (num == 0 || num == 1) { // stopping condition
            return num;
        }
        return (fib(num - 1) + fib(num - 2));
    }
}
