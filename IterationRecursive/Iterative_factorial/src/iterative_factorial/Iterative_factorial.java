//star recursion
import java.util.Scanner;

public class Problem2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;

        System.out.print("Enter number of stars: ");
        n = scanner.nextInt();
        System.out.println();

        recursion(n);

        System.out.println();
    }

    public static void recursion(int n) {
        if (n < 0) {
            return;
        } else {
            for (int i = n; i > 0; i--) {
                System.out.print("*");
            }
            System.out.println();

            recursion(n - 1);
        }
    }
}
