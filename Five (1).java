// Base class
class Animal {

    // Method to be overridden
    public void move() {
        System.out.println("The animal moves...");
    }
}

// Subclass
class Cheetah extends Animal {

    // Overriding the move() method
    @Override
    public void move() {
        System.out.println("The cheetah runs swiftly!");
    }
}

// Main class to test
public class Six {

    public static void main(String[] args) {
        Animal a = new Animal(); // Animal object
        a.move();

        Animal c = new Cheetah(); // Polymorphism (Cheetah as Animal)
        c.move();
    }
}
