package Exception;

import java.io.*;

class NetworkFailureException extends Exception {
    public NetworkFailureException(String msg, Throwable cause) { super(msg, cause); }
}
class InvalidLocationException extends Exception {
    public InvalidLocationException(String msg) { super(msg); }
}

class WeatherService {
    public double fetchTemperature(String city) throws NetworkFailureException, InvalidLocationException {
        if (city == null || city.trim().isEmpty()) throw new InvalidLocationException("City name empty");
        // Simulate network failure
        try {
            if (city.equalsIgnoreCase("Nowhere")) throw new IOException("Simulated connection failure");
            if (city.equalsIgnoreCase("Atlantis")) throw new InvalidLocationException("Location not found: " + city);
            // Simulate success
            return 25.0 + city.length() % 10; // dummy temperature
        } catch (IOException ioe) {
            throw new NetworkFailureException("Network error while fetching weather", ioe);
        }
    }
}

public class WeatherSimulation {
    public static void main(String[] args) {
        WeatherService svc = new WeatherService();
        try {
            System.out.println("Temperature in Dhaka: " + svc.fetchTemperature("Dhaka"));
            System.out.println("Temperature in Atlantis: " + svc.fetchTemperature("Atlantis"));
        } catch (InvalidLocationException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NetworkFailureException e) {
            System.out.println("Network Error: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
        }

        try {
            System.out.println("Temperature in Nowhere: " + svc.fetchTemperature("Nowhere"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " | Cause: " + e.getCause());
        }
    }
}

