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
        super(side, side);
    }
}

// Main class
public class Five {

    public static void main(String[] args) {
        // Array to store 15 Square objects
        Square[] squares = new Square[15];

        // Initialize squares with sides from 1 to 15
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square(i + 1); // side = i+1
        }

        // Print areas of all squares
        for (int i = 0; i < squares.length; i++) {
            System.out.print(
                "Square " + (i + 1) + " with side " + (i + 1) + " -> "
            );
            squares[i].printArea();
        }
    }
}
