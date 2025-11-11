// Question 3: Pizza and PizzaOrder classes

class Pizza {
    private String size;
    private int cheeseToppings;
    private int pepperoniToppings;
    private int hamToppings;

    // Constructor
    public Pizza(String size, int cheeseToppings, int pepperoniToppings, int hamToppings) {
        this.size = size.toLowerCase();
        this.cheeseToppings = cheeseToppings;
        this.pepperoniToppings = pepperoniToppings;
        this.hamToppings = hamToppings;
    }

    // Getters and Setters
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

    // Calculate cost
    public double calcCost() {
        int totalToppings = cheeseToppings + pepperoniToppings + hamToppings;
        double basePrice = 0;

        switch (size) {
            case "small":
                basePrice = 10;
                break;
            case "medium":
                basePrice = 12;
                break;
            case "large":
                basePrice = 14;
                break;
            default:
                System.out.println("Invalid size!");
        }

        return basePrice + (2 * totalToppings);
    }

    // Get description
    public String getDescription() {
        return "Pizza size: " + size +
                ", Cheese: " + cheeseToppings +
                ", Pepperoni: " + pepperoniToppings +
                ", Ham: " + hamToppings +
                ", Cost: $" + calcCost();
    }
}

class PizzaOrder {
    private Pizza pizza1;
    private Pizza pizza2;
    private Pizza pizza3;

    // Allow up to 3 pizzas
    public void setPizza1(Pizza pizza) {
        pizza1 = pizza;
    }

    public void setPizza2(Pizza pizza) {
        pizza2 = pizza;
    }

    public void setPizza3(Pizza pizza) {
        pizza3 = pizza;
    }

    // Calculate total order cost
    public double calcTotal() {
        double total = 0;
        if (pizza1 != null) total += pizza1.calcCost();
        if (pizza2 != null) total += pizza2.calcCost();
        if (pizza3 != null) total += pizza3.calcCost();
        return total;
    }
}

public class PizzaTest {
    public static void main(String[] args) {
        Pizza p1 = new Pizza("large", 1, 1, 2); // $22
        Pizza p2 = new Pizza("medium", 2, 1, 1); // $18
        System.out.println(p1.getDescription());
        System.out.println(p2.getDescription());

        PizzaOrder order = new PizzaOrder();
        order.setPizza1(p1);
        order.setPizza2(p2);

        System.out.println("Total Order Cost: $" + order.calcTotal());
    }
}
