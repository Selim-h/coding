// Base class Rectangle
class Rectangle {

    protected double length;
    protected double breadth;

    // Constructor to initialize length and breadth
    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Method to print area
    public void printArea() {
        System.out.println("Area: " + (length * breadth));
    }

    // Method to print perimeter
    public void printPerimeter() {
        System.out.println("Perimeter: " + (2 * (length + breadth)));
    }
}

// Subclass Square inherits Rectangle
class Square extends Rectangle {

    // Constructor for Square, calls parent constructor
    public Square(double side) {
        super(side, side); // both length and breadth are the same
    }
}

// Main class
public class Four {

    public static void main(String[] args) {
        // Rectangle object
        Rectangle rect = new Rectangle(5, 3);
        System.out.println("Rectangle:");
        rect.printArea();
        rect.printPerimeter();

        System.out.println();

        // Square object
        Square sq = new Square(4);
        System.out.println("Square:");
        sq.printArea();
        sq.printPerimeter();
    }
}
