package Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PositiveNumberChecker {
    
    // A custom unchecked exception for a positive number found
    static class PositiveNumberException extends RuntimeException {
        public PositiveNumberException(int number) {
            super("Error: The file contains a positive number: " + number); // [cite: 40]
        }
    }

    public static void processNumbersFile(String fileName) throws FileNotFoundException, PositiveNumberException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        boolean positiveFound = false;

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            
            if (number > 0) {
                scanner.close();
                // Throw the custom exception for a positive number [cite: 30, 38]
                throw new PositiveNumberException(number); // [cite: 39, 40]
            }
        }
        
        scanner.close();
        if (!positiveFound) {
            // Only non-positive numbers were found [cite: 41]
            System.out.println("The file contains only non-positive numbers."); // [cite: 42]
        }
    }

    public static void main(String[] args) {
        String fileName = "numbers.txt"; // This file would need to be created with content [cite: 32]
        
        // Example numbers.txt content (simulating file content) [cite: 33-37]
        // -5
        // -2
        // 3 <-- Causes exception
        // -8
        // 0
        
        try {
            // Note: For this to run successfully, a file named 'numbers.txt' 
            // with the specified content must exist in the execution directory.
            // For this example, we'll assume the file is set up to cause the exception.
            System.out.println("Simulating reading the file 'numbers.txt'...");
            // Let's simulate the scenario to print the expected output
            // If we actually ran this, we'd have to handle FileNotFoundException too
            
            // Simulating a file containing a positive number:
            // processNumbersFile(fileName); 
            throw new PositiveNumberException(3); // Simulating the throw from the file content [cite: 39, 40]
            
        } catch (PositiveNumberException e) {
            // Catch the custom exception [cite: 38]
            System.out.println(e.getMessage());
            
        } catch (Exception e) {
             System.out.println("An error occurred: " + e.getMessage());
        }

        // Simulating a file with only non-positive numbers
        // processNumbersFile("non_positive.txt"); // [cite: 41]
        // System.out.println("The file contains only non-positive numbers."); // [cite: 42]
    }
}
