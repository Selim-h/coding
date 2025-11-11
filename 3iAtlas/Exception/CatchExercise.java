package Exception;

public class CatchExercise {
    public static void main(String[] args) {
        try {
            // Declare an array of size 5 (indices 0 to 4)
            int[] a = new int[5];

            // This line causes ArithmeticException but is not executed
            // because the next line throws an ArrayIndexOutOfBoundsException first.
            // int division_result = 30 / 0;

            // Intentionally causes ArrayIndexOutOfBoundsException
            // The array 'a' has indices 0-4. Accessing index 5 is out of bounds.
            a[5] = 30 / 5; // [cite: 2, 5]

            // This line would cause an ArithmeticException if 'a[5] = 30/5;' was valid
            // int test_arithmetic = 10/0; 
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // Catches the exception thrown by a[5] = ... [cite: 3]
            System.out.println("ArrayIndexOutOfBoundsException occurs"); // [cite: 7]
            
        } catch (ArithmeticException e) {
            // This block is reachable if an ArithmeticException occurred first
            System.out.println("ArithmeticException occurs"); // [cite: 3]
            
        } catch (Exception e) {
            // General catch block (good practice, but not required by the prompt)
            System.out.println("An unexpected exception occurred.");
        }

        System.out.println("Rest of the code"); // [cite: 8]
    }
}
