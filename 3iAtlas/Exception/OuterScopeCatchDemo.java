package Exception;

public class OuterScopeCatchDemo {
    
    // A method that throws an unchecked exception (no 'throws' needed)
    public static void innerMethod() {
        // This is a try block without a catch for the specific exception
        try {
            System.out.println("In innerMethod: About to cause an exception.");
            // Intentionally cause an unchecked exception
            int x = 10 / 0; // Throws ArithmeticException
            System.out.println("This line is unreachable.");
        } finally {
            // finally block executes even if not caught
            System.out.println("In innerMethod: finally block executed.");
        }
        // ArithmeticException is not caught here, so it propagates [cite: 91]
    }

    // A method that calls innerMethod but does not catch the exception
    public static void outerMethod() {
        System.out.println("In outerMethod: Calling innerMethod...");
        innerMethod(); // Exception propagates from here
        System.out.println("In outerMethod: This line is unreachable.");
    }

    public static void main(String[] args) {
        System.out.println("In main: Calling outerMethod...");
        try {
            outerMethod();
        } catch (ArithmeticException e) {
            // The exception is caught and handled in the 'main' scope [cite: 92]
            System.out.println("In main: Caught the propagated exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("In main: Caught a different exception: " + e.getMessage());
        }
        System.out.println("Program finished successfully after handling the exception.");
    }
}
