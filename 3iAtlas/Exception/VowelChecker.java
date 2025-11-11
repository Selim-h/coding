package Exception;
public class VowelChecker {

    // Custom unchecked exception for no vowels found
    static class NoVowelsException extends RuntimeException {
        public NoVowelsException(String input) {
            super("The string '" + input + "' does not contain any vowels."); // [cite: 76]
        }
    }

    /**
     * Checks if the string contains any vowels.
     */
    public static void checkVowels(String input) throws NoVowelsException {
        // Use a regular expression to check for any vowel (case-insensitive)
        if (!input.toLowerCase().matches(".*[aeiou].*")) {
            // Throw exception if no vowels are found 
            throw new NoVowelsException(input); // [cite: 76]
        }
        
        // If vowels are found
        System.out.println("The string '" + input + "' contains vowels."); 
    }

    public static void main(String[] args) {
        // Test 1: No vowels [cite: 76]
        try {
            checkVowels("rhythm"); // [cite: 76]
        } catch (NoVowelsException e) {
            System.out.println(e.getMessage());
        }

        // Test 2: Contains vowels
        try {
            checkVowels("hello"); 
        } catch (NoVowelsException e) {
            System.out.println(e.getMessage());
        }
    }
}
