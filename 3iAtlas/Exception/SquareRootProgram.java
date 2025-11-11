package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SquareRootProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a real number: "); // [cite: 12, 14, 16]

        try {
            // Read input as a double
            double number = scanner.nextDouble(); // May throw InputMismatchException

            if (number < 0) {
                // Throw an exception for negative numbers
                throw new IllegalArgumentException("Cannot compute the square root of a negative number."); // [cite: 15]
            }

            double result = Math.sqrt(number);
            System.out.printf("The square root of %.1f is %.1f%n", number, result); // [cite: 13]

        } catch (InputMismatchException e) {
            // Handles cases where the user enters non-numeric input (e.g., "abc") [cite: 17]
            System.out.println("Error: Invalid input. Please enter a valid real number."); // [cite: 17]
            
        } catch (IllegalArgumentException e) {
            // Handles the exception thrown for a negative number [cite: 15]
            System.out.println(e.getMessage());
            
        } catch (Exception e) {
            // General handler for any other unexpected error [cite: 10]
            System.out.println("An unknown error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}