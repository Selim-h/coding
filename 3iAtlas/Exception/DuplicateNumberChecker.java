package Exception;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class DuplicateNumberChecker {
    
    // Custom unchecked exception for a duplicate number
    static class DuplicateNumberException extends RuntimeException {
        public DuplicateNumberException(int number) {
            super("Duplicate number found: " + number); // [cite: 73]
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean running = true;
        
        System.out.println("Enter integers (enter a non-integer to stop):"); // [cite: 68]

        try {
            while (running) {
                System.out.print("Enter a number: "); // [cite: 69-72]
                
                // Read next input
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();

                    if (uniqueNumbers.contains(number)) {
                        // Throw exception if the number is already in the set [cite: 66]
                        throw new DuplicateNumberException(number); // [cite: 72, 73]
                    }
                    
                    // If no duplicate, add to the set
                    uniqueNumbers.add(number);
                } else {
                    // Non-integer input, stop the loop
                    System.out.println("Input finished.");
                    running = false;
                }
            }
        } catch (DuplicateNumberException e) {
            // Catch the custom exception
            System.out.println(e.getMessage()); // [cite: 73]
        } catch (InputMismatchException e) {
            // Should be handled by the 'else' block above, but included for robustness
            System.out.println("Invalid input. Stopping.");
        } finally {
            scanner.close();
        }
    }
}
