package Exception;

import java.io.*;
import java.util.*;

class NoRoomAvailableException extends Exception {
    public NoRoomAvailableException(String msg) { super(msg); }
}

class InvalidStayDurationException extends Exception {
    public InvalidStayDurationException(String msg) { super(msg); }
}

class Hotel {
    int roomsAvailable;

    public Hotel(int roomsAvailable) { this.roomsAvailable = roomsAvailable; }

    public void bookRoom(String guest, int nights) throws NoRoomAvailableException, InvalidStayDurationException, IOException {
        if (nights <= 0) throw new InvalidStayDurationException("Stay duration must be positive!");
        if (roomsAvailable <= 0) throw new NoRoomAvailableException("No rooms available!");

        roomsAvailable--;
        try (FileWriter fw = new FileWriter("bookings.txt", true)) {
            fw.write("Guest: " + guest + ", Nights: " + nights + "\n");
        }
        System.out.println("Booking successful for " + guest);
    }
}

public class HotelBooking {
    public static void main(String[] args) {
        Hotel h = new Hotel(1);
        try {
            h.bookRoom("Alice", 3);
            h.bookRoom("Bob", 0); // invalid stay
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            h.bookRoom("Charlie", 2); // no room
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
