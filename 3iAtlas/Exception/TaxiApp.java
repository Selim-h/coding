package Exception;

class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String msg) { super(msg); }
}

class InvalidDestinationException extends Exception {
    public InvalidDestinationException(String msg) { super(msg); }
}

class TaxiService {
    boolean driverAvailable = true;
    String[] serviceableAreas = {"Dhaka", "Barishal", "Khulna"};

    public void requestRide(String destination)
            throws NoDriverAvailableException, InvalidDestinationException {
        if (!driverAvailable) throw new NoDriverAvailableException("No drivers available!");
        boolean valid = false;
        for (String area : serviceableAreas)
            if (area.equalsIgnoreCase(destination)) valid = true;
        if (!valid) throw new InvalidDestinationException("Destination not serviceable: " + destination);
        driverAvailable = false;
        System.out.println("Ride confirmed to " + destination);
    }
}

public class TaxiApp {
    public static void main(String[] args) {
        TaxiService t = new TaxiService();
        try {
            t.requestRide("Dhaka");
            t.requestRide("Sylhet");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

