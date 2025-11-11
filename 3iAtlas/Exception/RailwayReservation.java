package Exception;

class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException(String msg) { super(msg); }
}

class TrainService {
    private boolean[] seats; // true = booked

    public TrainService(int capacity) {
        seats = new boolean[capacity];
    }

    public void reserveSeat(int seatNo) throws SeatNotAvailableException {
        if (seatNo < 0 || seatNo >= seats.length) throw new SeatNotAvailableException("Invalid seat number.");
        if (seats[seatNo]) throw new SeatNotAvailableException("Seat " + seatNo + " not available.");
        seats[seatNo] = true;
    }
}

class ReservationController {
    private TrainService service;
    public ReservationController(TrainService s) { service = s; }

    public void book(int seatNo) throws SeatNotAvailableException {
        // propagate directly
        service.reserveSeat(seatNo);
    }
}

public class RailwayReservation {
    public static void main(String[] args) {
        TrainService service = new TrainService(3); // seats 0..2
        ReservationController controller = new ReservationController(service);

        try {
            controller.book(1);
            controller.book(1); // will throw and propagate to main
        } catch (SeatNotAvailableException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}

