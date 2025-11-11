package Exception;

public class CommandLineSum {
    public static void main(String[] args) {
        try {
            if (args.length < 2)
                throw new IllegalArgumentException("Please provide two numbers as arguments.");

            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            System.out.println("Sum = " + (num1 + num2));

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
