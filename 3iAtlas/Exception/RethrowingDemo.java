package Exception;

public class RethrowingDemo {
    
    // Method 2: Throws the initial exception [cite: 89]
    public static void someMethod2() throws Exception {
        System.out.println("In someMethod2: Throwing initial exception.");
        throw new Exception("Exception originating in someMethod2!");
    }

    // Method 1: Calls Method 2, catches, and rethrows [cite: 89]
    public static void someMethod() throws Exception {
        try {
            System.out.println("In someMethod: Calling someMethod2...");
            someMethod2();
        } catch (Exception e) {
            System.out.println("In someMethod: Caught exception, rethrowing it..."); // [cite: 88]
            // Rethrow the exception [cite: 90]
            throw e; 
        }
    }

    public static void main(String[] args) {
        // Main: Calls Method 1 and catches the rethrown exception [cite: 90]
        try {
            someMethod();
        } catch (Exception e) {
            System.out.println("In main: Caught the rethrown exception."); 
            System.out.println("--- Stack Trace ---");
            // Print the stack trace to see the original call chain [cite: 90]
            e.printStackTrace(System.out);
            System.out.println("-------------------");
        }
    }
}