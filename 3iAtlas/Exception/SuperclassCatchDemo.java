package Exception;

class ExceptionA extends Exception {}
// ExceptionB inherits from ExceptionA
class ExceptionB extends ExceptionA {} // [cite: 78]
// ExceptionC inherits from ExceptionB
class ExceptionC extends ExceptionB {} // [cite: 78]

public class SuperclassCatchDemo {
    
    public static void throwExceptions() throws ExceptionA, ExceptionB, ExceptionC {
        // Throw an ExceptionC
        System.out.println("Throwing ExceptionC...");
        throw new ExceptionC(); // ExceptionA's catch block will catch this
    }

    public static void main(String[] args) {
        // Try to catch ExceptionC with a catch block for ExceptionA [cite: 79]
        try {
            throwExceptions();
        } catch (ExceptionA e) { 
            // This catch block handles ExceptionA, ExceptionB, and ExceptionC
            System.out.println("Caught an exception of type: " + e.getClass().getName()); // [cite: 79]
        }
    }
}
