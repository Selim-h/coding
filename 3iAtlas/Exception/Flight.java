package Exception;

class OverbookingException extends Exception {
    public OverbookingException(String msg) {
        super(msg);
    }
}

public class Flight {
    int availableSeats = 5;

    void bookTicket(int seats) throws OverbookingException {
        if (seats <= 0)
            throw new IllegalArgumentException("Invalid seat number!");
        if (seats > availableSeats)
            throw new OverbookingException("Not enough seats available!");
        availableSeats -= seats;
        System.out.println("Successfully booked " + seats + " seats. Remaining: " + availableSeats);
    }

    public static void main(String[] args) {
        Flight f = new Flight();
        try {
            f.bookTicket(3);
            f.bookTicket(4); // will throw overbooking exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

