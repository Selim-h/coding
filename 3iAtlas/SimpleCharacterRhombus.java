import java.util.Scanner;

public class SimpleCharacterRhombus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: 7 is needed for the 'G' peak
        System.out.print("Enter the number for the center character (e.g., 7 for 'G'): ");
        int n = scanner.nextInt();
        
        scanner.close();

        System.out.println("\n--- Centered Pattern Output ---\n");
        
        // The core loop runs from -n+1 up to n-1. 
        // This generates 2n-1 total lines (13 lines for n=7).
        // The variable 'i' helps determine the line number and position.
        
        for (int i = -n + 1; i <= n - 1; i++) {
            
            // 1. Calculate the 'level' (height from the center)
            // 'level' will be 0 at the center (widest line) and n-1 at the top/bottom (narrowest line).
            int level = Math.abs(i); // Convert negative numbers to positive (e.g., -6 and 6 both become 6)
            
            // 2. Calculate the 'peak' character
            // The character peak (1 for 'A', 7 for 'G') is max_level - level
            int charCount = n - level; 
            
            // --- A. Print Leading Spaces (for centering) ---
            // The number of spaces needed is equal to 'level'
            for (int s = 0; s < level; s++) {
                System.out.print(" ");
            }
            
            // --- B. Print the Ascending Half (e.g., A, AB, ABC...) ---
            // 'j' goes from 0 up to charCount - 1
            for (int j = 0; j < charCount; j++) {
                // (char)('A' + 0) is 'A', (char)('A' + 1) is 'B', etc.
                char character = (char) ('A' + j); 
                System.out.print(character);
            }

            // --- C. Print the Descending Half (e.g., BA, CB A, DCBA...) ---
            // 'j' starts at charCount - 2 (to skip the peak character) and goes down to 0
            for (int j = charCount - 2; j >= 0; j--) {
                char character = (char) ('A' + j); 
                System.out.print(character);
            }
            
            // Move to the next line
            System.out.println();
        }
    }
}
