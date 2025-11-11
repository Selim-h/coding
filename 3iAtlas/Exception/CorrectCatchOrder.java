package Exception;

// Example demonstrating the correct order: specific to general

public class CorrectCatchOrder {
    public static void main(String[] args) {
        try {
            // int x = 1 / 0; // Uncomment to throw ArithmeticException
            int[] arr = new int[1];
            arr[1] = 10; // Throws ArrayIndexOutOfBoundsException
            
        } catch (ArrayIndexOutOfBoundsException e) { // More specific (subclass of RuntimeException)
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            
        } catch (RuntimeException e) { // More general (superclass of AIOOBE)
            System.out.println("Caught RuntimeException");
            
        } catch (Exception e) { // Most general
            System.out.println("Caught Exception");
        }
    }
}

/*
// Example demonstrating the INCORRECT order (Compiler Error) [cite: 84]

class IncorrectCatchOrder {
    public static void main(String[] args) {
        try {
            int[] arr = new int[1];
            arr[1] = 10; 
        } catch (Exception e) { // TOO general, catches everything
            System.out.println("Caught Exception");
            
        // The following block is now unreachable, causing a compiler error. [cite: 84]
        // catch (ArrayIndexOutOfBoundsException e) { 
        //     System.out.println("Caught ArrayIndexOutOfBoundsException"); 
        // } 
    }
}
*/