package Exception;


public class CustomExceptionProgram {
    public static void main(String[] args) {
        try {
            // Manually throw a new Exception object
            throw new Exception("This is a custom exception message!"); 
            
        } catch (Exception e) {
            // Catch the thrown exception
            System.out.println("Exception caught: " + e.getMessage()); // [cite: 19]
        }
    }
}