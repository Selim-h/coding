import java.util.Scanner;

public class PascalTriangleCombined {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int numRows = sc.nextInt();

        System.out.println("\nNormal Pascal's Triangle:\n");
        printNormalPascal(numRows);

        System.out.println("\nReverse Pascal's Triangle:\n");
        printReversePascal(numRows);
    }

    // ---------- Normal Pascal Triangle ----------
    public static void printNormalPascal(int n) {
        for (int i = 0; i < n; i++) {
            // Print leading spaces for alignment
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }

            int value = 1;
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", value);
                value = (value * (i - j)) / (j + 1); // Formula for next value
            }
            System.out.println();
        }
    }

    // ---------- Reverse Pascal Triangle ----------
    public static void printReversePascal(int n) {
        for (int i = n - 1; i >= 0; i--) {
            // Print leading spaces for alignment
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  ");
            }

            int value = 1;
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", value);
                value = (value * (i - j)) / (j + 1);
            }
            System.out.println();
        }
    }
}
