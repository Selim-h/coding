// Base class
class Vehicle {

    public void drive() {
        System.out.println("Driving a vehicle");
    }
}

// Subclass
class Car extends Vehicle {

    @Override
    public void drive() {
        System.out.println("Repairing a car");
    }
}

// Runner class
public class Two {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.drive(); // Output: Driving a vehicle

        Car c = new Car();
        c.drive(); // Output: Repairing a car

        // Polymorphism example
        Vehicle v2 = new Car();
        v2.drive(); // Output: Repairing a car
    }
}
