package Exception;

class CarNotAvailableException extends Exception {
    public CarNotAvailableException(String msg) { super(msg); }
}

class InvalidRentalPeriodException extends Exception {
    public InvalidRentalPeriodException(String msg) { super(msg); }
}

class Car {
    String name;
    boolean available = true;

    public Car(String name) {
        this.name = name;
    }

    public void rentCar(int days) throws CarNotAvailableException, InvalidRentalPeriodException {
        if (days <= 0) throw new InvalidRentalPeriodException("Rental period must be greater than 0 days!");
        if (!available) throw new CarNotAvailableException(name + " is already rented!");
        available = false;
        System.out.println(name + " rented for " + days + " days.");
    }

    public void returnCar() {
        available = true;
        System.out.println(name + " returned successfully.");
    }
}

public class CarRental {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota Corolla");
        try {
            c1.rentCar(3);
            c1.rentCar(2); // not available
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        c1.returnCar();
    }
}

