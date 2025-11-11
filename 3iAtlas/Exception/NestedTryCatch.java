package Exception;

public class NestedTryCatch {
    public static void main(String[] args) {
        try {
            int[] arr = {10, 20, 30};
            try {
                int result = arr[1] / 0;  // Division by zero
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Inner Catch: Division by zero!");
            }

            System.out.println("Accessing invalid index...");
            System.out.println(arr[5]);  // Out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer Catch: Array index out of bounds!");
        }
    }
}

