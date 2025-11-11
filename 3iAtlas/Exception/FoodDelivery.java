package Exception;

import java.util.*;

class OutOfStockException extends Exception {
    public OutOfStockException(String msg) { super(msg); }
}
class InvalidQuantityException2 extends Exception {
    public InvalidQuantityException2(String msg) { super(msg); }
}

class Restaurant {
    Map<String, Integer> menu = new HashMap<>();

    public Restaurant() {
        menu.put("Burger", 5);
        menu.put("Pizza", 2);
    }

    public void placeOrder(String item, int quantity) throws OutOfStockException, InvalidQuantityException2 {
        if (quantity <= 0) throw new InvalidQuantityException2("Invalid quantity!");
        if (!menu.containsKey(item) || menu.get(item) < quantity)
            throw new OutOfStockException(item + " not available or insufficient stock!");

        menu.put(item, menu.get(item) - quantity);
        System.out.println("Order placed: " + item + " x" + quantity);
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        Restaurant r = new Restaurant();
        try {
            r.placeOrder("Pizza", 1);
            r.placeOrder("Pizza", 3); // out of stock
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            r.placeOrder("Burger", 0); // invalid quantity
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
