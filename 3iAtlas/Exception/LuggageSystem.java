package Exception;

class OverweightLuggageException extends Exception {
    public OverweightLuggageException(String msg) { super(msg); }
}
class InvalidLuggageException extends Exception {
    public InvalidLuggageException(String msg) { super(msg); }
}

public class LuggageSystem {
    public static void checkLuggage(double weight, double limit)
            throws OverweightLuggageException, InvalidLuggageException {
        if (weight <= 0) throw new InvalidLuggageException("Invalid luggage weight!");
        if (weight > limit) throw new OverweightLuggageException("Luggage overweight by " + (weight - limit) + " kg!");
        System.out.println("Luggage accepted. Weight: " + weight + " kg");
    }

    public static void main(String[] args) {
        try {
            checkLuggage(18, 20);
            checkLuggage(25, 20);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

