import java.util.Scanner;

public class Tower_of_Hanoi {

    private static int step = 0; // This will keep the count between calls, similar to the static in C

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter number of disks: ");
        int numDisks = scanner.nextInt();

        if (numDisks > 0) {
            move(numDisks, 'A', 'C', 'B');
        }

        scanner.close();
    }

    public static void move(int numDisks, char from, char destination, char intermediate) {
        if (numDisks == 1) {
            System.out.printf("Step %d: Move disk 1 from needle %c to needle %c%n", ++step, from, destination);
            return;
        } else {
            move(numDisks - 1, from, intermediate, destination);
            System.out.printf("Step %d: Move disk %d from needle %c to needle %c%n", ++step, numDisks, from, destination);
            move(numDisks - 1, intermediate, destination, from);
        }
    }
}
