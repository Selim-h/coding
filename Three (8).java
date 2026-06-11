import java.util.*;

class Shape {

    public void show() {
        System.out.println("Showing a generic Shape");
    }

    public void getInfo() {
        System.out.println("Class: Shape");
    } // do NOT override
}

class Circle extends Shape {

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public void show() {
        System.out.println("Showing Circle, r=" + r);
    }
}

class Rectangle extends Shape {

    private double w, h;

    public Rectangle(double w, double h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public void show() {
        System.out.println("Showing Rectangle, w=" + w + ", h=" + h);
    }
}

public class PolymorphismDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape s1 = new Circle(5); // upcasting
        Shape s2 = new Rectangle(4, 3); // upcasting

        // Polymorphic calls (dynamic dispatch)
        s1.show(); // Circle's show()
        s2.show(); // Rectangle's show()

        // getInfo() is inherited from Shape (not overridden)
        s1.getInfo(); // prints "Class: Shape"
        s2.getInfo(); // prints "Class: Shape"
    }
}
