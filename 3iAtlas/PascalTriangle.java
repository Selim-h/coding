import java.util.Scanner;

public class PascalTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows for Pascal's Triangle (e.g., 5): ");
        int numRows = scanner.nextInt();
        
        System.out.println("\n=================================");
        System.out.println("  Pascal's Triangle (Normal Order)");
        System.out.println("=================================");
        displayPascalTriangle(numRows);

        System.out.println("\n=================================");
        System.out.println("  Pascal's Triangle (Reverse Order)");
        System.out.println("=================================");
        displayReversePascalTriangle(numRows);
        
        scanner.close();
    }

    /**
     * Generates and displays Pascal's Triangle in normal order (Row 0 at top).
     */
    public static void displayPascalTriangle(int numRows) {
        
        // Outer loop for the rows (r = 0, 1, 2, 3, 4 for 5 rows)
        for (int r = 0; r < numRows; r++) {
            
            // 1. Print Leading Spaces for Centering
            // Prints numRows - r spaces to center the triangle
            for (int s = 0; s < numRows - r; s++) {
                System.out.print("  "); // Two spaces for better alignment
            }

            // 'number' represents the value C(r, k). It always starts at 1 for k=0.
            int number = 1; 
            
            // Inner loop for the elements (columns) in the current row
            for (int k = 0; k <= r; k++) {
                
                // 2. Print the current number
                System.out.printf("%4d", number); // %4d ensures a 4-character width for alignment
                
                // 3. Calculate the NEXT number using the efficient formula:
                // C(r, k+1) = C(r, k) * (r - k) / (k + 1)
                number = number * (r - k) / (k + 1);
            }
            
            System.out.println(); // Move to the next line
        }
    }

    /**
     * Generates and displays Pascal's Triangle in reverse order (Row N at top).
     */
    public static void displayReversePascalTriangle(int numRows) {
        
        // Outer loop for the rows: starts at the last row (numRows - 1) and goes down to 0.
        for (int r = numRows - 1; r >= 0; r--) {
            
            // 1. Print Leading Spaces (Centering is the same as the normal triangle)
            for (int s = 0; s < numRows - r; s++) {
                System.out.print("  ");
            }

            int number = 1; 
            
            // Inner loop for the elements (same as before)
            for (int k = 0; k <= r; k++) {
                
                // 2. Print the current number
                System.out.printf("%4d", number);
                
                // 3. Calculate the NEXT number
                number = number * (r - k) / (k + 1);
            }
            
            System.out.println(); 
        }
    }
}
