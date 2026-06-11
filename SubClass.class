class Pizza {

    // Private instance variables
    private String size; // small, medium, large
    private int cheeseToppings;
    private int pepperoniToppings;
    private int hamToppings;

    // Constructor
    public Pizza(
        String size,
        int cheeseToppings,
        int pepperoniToppings,
        int hamToppings
    ) {
        this.size = size.toLowerCase();
        this.cheeseToppings = cheeseToppings;
        this.pepperoniToppings = pepperoniToppings;
        this.hamToppings = hamToppings;
    }

    // Getters and setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size.toLowerCase();
    }

    public int getCheeseToppings() {
        return cheeseToppings;
    }

    public void setCheeseToppings(int cheeseToppings) {
        this.cheeseToppings = cheeseToppings;
    }

    public int getPepperoniToppings() {
        return pepperoniToppings;
    }

    public void setPepperoniToppings(int pepperoniToppings) {
        this.pepperoniToppings = pepperoniToppings;
    }

    public int getHamToppings() {
        return hamToppings;
    }

    public void setHamToppings(int hamToppings) {
        this.hamToppings = hamToppings;
    }

    // Method to calculate cost
    public double calcCost() {
        int basePrice = 0;
        switch (size) {
            case "small" -> basePrice = 10;
            case "medium" -> basePrice = 12;
            case "large" -> basePrice = 14;
            default -> {
                System.out.println("Invalid size! Defaulting to small.");
                basePrice = 10;
            }
        }

        int totalToppings = cheeseToppings + pepperoniToppings + hamToppings;
        return basePrice + (2 * totalToppings);
    }

    // Method to get description
    public String getDescription() {
        return (
            "Pizza size: " +
            size +
            ", Cheese toppings: " +
            cheeseToppings +
            ", Pepperoni toppings: " +
            pepperoniToppings +
            ", Ham toppings: " +
            hamToppings +
            ", Cost: $" +
            calcCost()
        );
    }
}

class PizzaOrder {

    private Pizza pizza1;
    private Pizza pizza2;
    private Pizza pizza3;

    // Add pizzas (up to 3)
    public void setPizza1(Pizza p) {
        this.pizza1 = p;
    }

    public void setPizza2(Pizza p) {
        this.pizza2 = p;
    }

    public void setPizza3(Pizza p) {
        this.pizza3 = p;
    }

    // Calculate total cost
    public double calcTotal() {
        double total = 0;
        if (pizza1 != null) total += pizza1.calcCost();
        if (pizza2 != null) total += pizza2.calcCost();
        if (pizza3 != null) total += pizza3.calcCost();
        return total;
    }
}

public class Three {

    public static void main(String[] args) {
        // Create pizzas
        Pizza p1 = new Pizza("large", 1, 1, 2); // cost = 22
        Pizza p2 = new Pizza("medium", 2, 2, 1); // 12 + 5 toppings*2 = 22

        // Print descriptions
        System.out.println(p1.getDescription());
        System.out.println(p2.getDescription());

        // Create pizza order
        PizzaOrder order = new PizzaOrder();
        order.setPizza1(p1);
        order.setPizza2(p2);

        // Print total
        System.out.println("Total order cost: $" + order.calcTotal());
    }
}
