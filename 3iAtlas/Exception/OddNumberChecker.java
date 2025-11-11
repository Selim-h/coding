package Exception;

public class OddNumberChecker {
    
    /**
     * Checks if a number is odd. Throws an exception if it is.
     */
    public static void checkNumber(int number) throws IllegalArgumentException {
        if (number % 2 != 0) {
            // The number is odd, so throw the exception [cite: 21]
            throw new IllegalArgumentException("The number " + number + " is odd!"); // [cite: 23]
        }
        // If the number is even, print a success message [cite: 24]
        System.out.println("The number " + number + " is even."); 
    }

    public static void main(String[] args) {
        // Test with an odd number
        try {
            checkNumber(7);
        } catch (IllegalArgumentException e) {
            // Catch the exception and print the message
            System.out.println(e.getMessage());
        }

        // Test with an even number
        try {
            checkNumber(8); // [cite: 24]
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}