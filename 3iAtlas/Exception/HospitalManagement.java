package Exception;

import java.util.*;

class NoBedAvailableException extends Exception {
    public NoBedAvailableException(String msg) { super(msg); }
}

class InvalidPatientDataException extends Exception {
    public InvalidPatientDataException(String msg) { super(msg); }
}

class Hospital {
    private int capacity;
    private List<String> patients = new ArrayList<>();

    public Hospital(int capacity) { this.capacity = capacity; }

    public void admit(String name, int age) throws NoBedAvailableException, InvalidPatientDataException {
        if (name == null || name.trim().isEmpty() || age < 0) throw new InvalidPatientDataException("Invalid patient data.");
        if (patients.size() >= capacity) throw new NoBedAvailableException("No beds available.");
        patients.add(name);
        System.out.println("Admitted: " + name + " (age " + age + ")");
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Hospital h = new Hospital(2);
        try {
            h.admit("Alice", 30);
            h.admit("", 25); // invalid name
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            h.admit("Bob", 40);
            h.admit("Charlie", 50); // no beds
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

