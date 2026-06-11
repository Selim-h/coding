// Base class Shape
class Shape {

    public void printShape() {
        System.out.println("This is shape");
    }
}

// Rectangle class inherits Shape
class Rectangle extends Shape {

    public void printRectangle() {
        System.out.println("This is rectangular shape");
    }
}

// Circle class inherits Shape
class Circle extends Shape {

    public void printCircle() {
        System.out.println("This is circular shape");
    }
}

// Square class inherits Rectangle
class Square extends Rectangle {

    public void printSquare() {
        System.out.println("Square is a rectangle");
    }
}

// Main class
public class Six {

    public static void main(String[] args) {
        // Create Square object
        Square sq = new Square();

        // Call method of Shape class
        sq.printShape(); // Output: This is shape

        // Call method of Rectangle class
        sq.printRectangle(); // Output: This is rectangular shape

        // Optional: call Square’s own method
        sq.printSquare(); // Output: Square is a rectangle
    }
}
