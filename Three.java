// Base class
class Animal {

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass
class Cat extends Animal {

    @Override
    public void makeSound() {
        // Normally cats "meow", but here we override to "bark"
        System.out.println("Bark!");
    }
}

// Runner class with main method
public class One {

    public static void main(String[] args) {
        Animal a = new Animal();
        a.makeSound(); // Output: Animal makes a sound

        Cat c = new Cat();
        c.makeSound(); // Output: Bark!
    }
}
