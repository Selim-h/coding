import java.util.Scanner;

public class CharacterRhombus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get the input number (center width)
        System.out.print("Enter the number for the center character ('A'=1, 'G'=7): ");
        int n = scanner.nextInt();
        
        scanner.close();

        System.out.println("\nExpected Output:");
        
        // --- 2. Print the Upper Half (including the center line) ---
        // The loop goes from 1 (for 'A') up to n (for the widest character, e.g., 'G')
        for (int i = 1; i <= n; i++) {
            printCharacterLine(n, i);
        }

        // --- 3. Print the Lower Half ---
        // The loop goes from n-1 down to 1 (to mirror the top part)
        for (int i = n - 1; i >= 1; i--) {
            printCharacterLine(n, i);
        }
    }

    /**
     * Helper method to print a single line of the rhombus structure.
     * @param maxLevel The maximum depth (e.g., 7 for 'G')
     * @param currentLevel The current line's depth (e.g., 3 for 'C')
     */
    public static void printCharacterLine(int maxLevel, int currentLevel) {
        
        // --- A. Print Leading Spaces (for the triangle shape) ---
        // This is only needed if you want a perfect diamond shape.
        // For the pattern in the image (left-justified), we skip this.
        
        // --- B. Print the Left Side (Ascending Characters) ---
        // The characters go from 'A' up to the character determined by 'currentLevel'
        for (int j = 0; j < currentLevel; j++) {
            // 'A' is ASCII 65. Adding 'j' gives B, C, etc.
            char character = (char) ('A' + j); 
            System.out.print(character);
        }

        // --- C. Print the Right Side (Descending Characters) ---
        // The characters go from the character *before* the peak, down to 'A'.
        // We start from currentLevel - 2 and go down to 0.
        for (int j = currentLevel - 2; j >= 0; j--) {
            // 'A' is ASCII 65. Adding 'j' gives the characters B, A, etc.
            char character = (char) ('A' + j); 
            System.out.print(character);
        }

        // Move to the next line after printing the full structure for the current level
        System.out.println();
    }
}