package Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileFinder {
    
    /**
     * Attempts to read a file and throws FileNotFoundException if the file
     * does not exist.
     */
    public static void readFile(String fileName) throws FileNotFoundException {
        // The Scanner constructor can throw FileNotFoundException [cite: 25]
        Scanner fileScanner = new Scanner(new File(fileName)); 
        
        // If the file is found, you would process it here
        System.out.println("File '" + fileName + "' found successfully!");
        fileScanner.close();
    }

    public static void main(String[] args) {
        String fileName = "sample.txt"; // [cite: 28]
        try {
            readFile(fileName);
        } catch (FileNotFoundException e) {
            // Catch the specific exception [cite: 26]
            System.out.println("Error: The file '" + fileName + "' was not found."); // [cite: 28]
        }
    }
}
