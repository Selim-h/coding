// Base class
class Shape {

    public double getArea() {
        // Default implementation
        System.out.println("Area not defined for generic shape");
        return 0;
    }
}

// Subclass
class Rectangle extends Shape {

    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Overriding getArea() to calculate rectangle area
    @Override
    public double getArea() {
        return length * width;
    }
}

// Runner class
public class Three {

    public static void main(String[] args) {
        Shape s = new Shape();
        System.out.println("Shape area: " + s.getArea());

        Rectangle r = new Rectangle(5, 3);
        System.out.println("Rectangle area: " + r.getArea());

        // Polymorphism example
        Shape s2 = new Rectangle(10, 4);
        System.out.println("Polymorphic Rectangle area: " + s2.getArea());
    }
}
