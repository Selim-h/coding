package Exception;
class SomeClass {
    // Constructor throws an Exception [cite: 86]
    public SomeClass(int value) throws Exception {
        if (value < 0) {
            // Throw an exception if the initialization fails a condition
            throw new Exception("SomeClass object creation failed: Value cannot be negative."); 
        }
        System.out.println("SomeClass object created successfully with value: " + value);
    }
}

public class ConstructorFailureDemo {
    public static void main(String[] args) {
        SomeClass obj = null;

        // Try to create an object that will cause the constructor to fail [cite: 87]
        try {
            obj = new SomeClass(-5); // This will throw the exception
        } catch (Exception e) {
            // Catch the exception thrown by the constructor [cite: 85]
            System.out.println("Exception caught: " + e.getMessage()); 
        }

        // Try to create an object that will succeed
        try {
            obj = new SomeClass(10);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
