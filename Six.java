// Base class
class Vehicle {

    protected String make;
    protected String model;
    protected int year;
    protected String fuelType;

    // Constructor
    public Vehicle(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    // Method to calculate fuel efficiency (to be overridden)
    public double calculateFuelEfficiency() {
        return 0.0;
    }

    // Method to calculate distance traveled
    public double calculateDistance(double fuelUsed) {
        return calculateFuelEfficiency() * fuelUsed;
    }

    // Method to get max speed (to be overridden)
    public double getMaxSpeed() {
        return 0.0;
    }

    // Display info
    public void displayInfo() {
        System.out.println(
            year + " " + make + " " + model + " (" + fuelType + ")"
        );
    }
}

// Subclass Truck
class Truck extends Vehicle {

    public Truck(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 8.0; // km per liter
    }

    @Override
    public double getMaxSpeed() {
        return 120.0; // km/h
    }
}

// Subclass Car
class Car extends Vehicle {

    public Car(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 15.0; // km per liter
    }

    @Override
    public double getMaxSpeed() {
        return 180.0; // km/h
    }
}

// Subclass Motorcycle
class Motorcycle extends Vehicle {

    public Motorcycle(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    @Override
    public double calculateFuelEfficiency() {
        return 30.0; // km per liter
    }

    @Override
    public double getMaxSpeed() {
        return 220.0; // km/h
    }
}

// Main class
public class Nine {

    public static void main(String[] args) {
        Vehicle truck = new Truck("Volvo", "FH16", 2022, "Diesel");
        Vehicle car = new Car("Toyota", "Corolla", 2021, "Petrol");
        Vehicle bike = new Motorcycle("Yamaha", "R1", 2023, "Petrol");

        truck.displayInfo();
        System.out.println(
            "Fuel Efficiency: " + truck.calculateFuelEfficiency() + " km/l"
        );
        System.out.println("Max Speed: " + truck.getMaxSpeed() + " km/h");
        System.out.println(
            "Distance with 50L fuel: " + truck.calculateDistance(50) + " km\n"
        );

        car.displayInfo();
        System.out.println(
            "Fuel Efficiency: " + car.calculateFuelEfficiency() + " km/l"
        );
        System.out.println("Max Speed: " + car.getMaxSpeed() + " km/h");
        System.out.println(
            "Distance with 50L fuel: " + car.calculateDistance(50) + " km\n"
        );

        bike.displayInfo();
        System.out.println(
            "Fuel Efficiency: " + bike.calculateFuelEfficiency() + " km/l"
        );
        System.out.println("Max Speed: " + bike.getMaxSpeed() + " km/h");
        System.out.println(
            "Distance with 20L fuel: " + bike.calculateDistance(20) + " km\n"
        );
    }
}
