package Exception;

import java.io.IOException;

class ExceptionA extends Exception {} // [cite: 80]
class ExceptionB extends ExceptionA {} // [cite: 80]

public class GenericCatchDemo {
    
    public static void main(String[] args) {
        // 1. Catching custom ExceptionA [cite: 81]
        try {
            throw new ExceptionA();
        } catch (Exception e) { // Catches ExceptionA
            System.out.println("Caught an exception: " + e.getClass().getName()); // [cite: 82]
        }

        // 2. Catching custom ExceptionB [cite: 81]
        try {
            throw new ExceptionB();
        } catch (Exception e) { // Catches ExceptionB
            System.out.println("Caught an exception: " + e.getClass().getName()); // [cite: 82]
        }

        // 3. Catching NullPointerException (RuntimeException subclass) [cite: 81]
        try {
            String s = null;
            s.toString(); // Causes NullPointerException
        } catch (Exception e) { // Catches NullPointerException
            System.out.println("Caught an exception: " + e.getClass().getName()); // [cite: 82]
        }

        // 4. Catching IOException (Checked Exception) [cite: 81]
        try {
            throw new IOException();
        } catch (Exception e) { // Catches IOException
            System.out.println("Caught an exception: " + e.getClass().getName()); // [cite: 82]
        }
    }
}
