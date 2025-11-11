package Exception;

import java.util.*;

class EmptyCartException extends Exception {
    public EmptyCartException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class Item {
    String name;
    double price;
    int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Cart {
    List<Item> items = new ArrayList<>();

    void addItem(Item item) {
        items.add(item);
    }

    void checkout(double balance) throws EmptyCartException, InsufficientBalanceException {
        if (items.isEmpty())
            throw new EmptyCartException("Your cart is empty!");
        double total = 0;
        for (Item i : items)
            total += i.price * i.quantity;

        if (total > balance)
            throw new InsufficientBalanceException("Insufficient balance. Required: " + total);
        System.out.println("Checkout successful! Total: " + total);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addItem(new Item("Phone", 30000, 1));
        cart.addItem(new Item("Earbuds", 2000, 2));

        try {
            cart.checkout(50000);
            cart.checkout(1000); // will throw insufficient balance
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

