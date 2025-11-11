package Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EmptyFileChecker {
    
    // Custom exception for an empty file [cite: 44]
    static class EmptyFileException extends IOException {
        public EmptyFileException(String fileName) {
            super("Error: The file is empty: " + fileName); // [cite: 47]
        }
    }

    public static void readFile(String fileName) throws FileNotFoundException, EmptyFileException, IOException {
        File file = new File(fileName);
        
        if (!file.exists()) {
            throw new FileNotFoundException("Error: The file '" + fileName + "' was not found."); // [cite: 50, 64]
        }
        
        if (file.length() == 0) {
            // File exists but has zero length (empty) [cite: 44, 59]
            throw new EmptyFileException(fileName); // [cite: 47, 61]
        }

        // File is not empty, read and print content [cite: 48]
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine()); // [cite: 56, 57]
        }
        scanner.close();
        System.out.println("File read successfully!"); // [cite: 58]
    }

    public static void main(String[] args) {
        // 1. Non-empty file simulation [cite: 52]
        System.out.println("--- Non-empty file (sample.txt) Simulation ---");
        try {
            // Simulate the output for a non-empty file [cite: 56-58]
            System.out.println("Hello, world!");
            System.out.println("This is a test file.");
            System.out.println("File read successfully!");
            // readFile("sample.txt"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 2. Empty file simulation [cite: 59]
        System.out.println("\n--- Empty file (empty.txt) Simulation ---");
        try {
            // readFile("empty.txt");
            // Simulate the exception throw [cite: 60, 61]
            throw new EmptyFileChecker.EmptyFileException("empty.txt");
        } catch (EmptyFileChecker.EmptyFileException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // 3. File not found simulation [cite: 62]
        System.out.println("\n--- File not found (nonexistent.txt) Simulation ---");
        try {
            // readFile("nonexistent.txt");
            // Simulate the exception throw [cite: 63, 64]
            throw new FileNotFoundException("Error: The file 'nonexistent.txt' was not found."); 
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()); // [cite: 64]
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}