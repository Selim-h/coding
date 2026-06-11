// Base class
class Shape {

    // Methods to be overridden
    public double getPerimeter() {
        return 0.0;
    }

    public double getArea() {
        return 0.0;
    }
}

// Subclass Circle
class Circle extends Shape {

    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Overriding getPerimeter()
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Overriding getArea()
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Main class to test
public class Eight {

    public static void main(String[] args) {
        Circle c = new Circle(7); // Circle with radius 7
        System.out.println("Circle Radius: " + 7);
        System.out.println("Circle Perimeter: " + c.getPerimeter());
        System.out.println("Circle Area: " + c.getArea());
    }
}
