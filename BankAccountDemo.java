import java.util.*;

abstract class Shape {

    public abstract void draw(); // describe how it would be drawn

    public abstract double calculateArea(); // area or total surface area
}

class Circle extends Shape {

    protected double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + r);
    }

    @Override
    public double calculateArea() {
        return Math.PI * r * r; // πr^2
    }
}

class Cylinder extends Shape {

    private double r, h;

    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    @Override
    public void draw() {
        System.out.println(
            "Drawing a Cylinder with radius " + r + " and height " + h
        );
    }

    // Total surface area = 2πr(h + r)
    @Override
    public double calculateArea() {
        return 2 * Math.PI * r * (h + r);
    }
}

public class ShapesDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Circle
        System.out.print("Enter radius for circle: ");
        double r1 = sc.nextDouble();
        Shape c = new Circle(r1);

        // Cylinder
        System.out.print("Enter radius for cylinder: ");
        double r2 = sc.nextDouble();
        System.out.print("Enter height for cylinder: ");
        double h2 = sc.nextDouble();
        Shape cy = new Cylinder(r2, h2);

        c.draw();
        System.out.printf("Circle area = %.4f%n", c.calculateArea());

        cy.draw();
        System.out.printf(
            "Cylinder total surface area = %.4f%n",
            cy.calculateArea()
        );
    }
}
