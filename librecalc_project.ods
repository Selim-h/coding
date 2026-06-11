import java.util.*;

abstract class Shape {

    public abstract void RectangleArea(double length, double breadth);

    public abstract void SquareArea(double side);

    public abstract void CircleArea(double radius);
}

class Area extends Shape {

    @Override
    public void RectangleArea(double l, double b) {
        System.out.printf(
            "Rectangle area (l=%.2f, b=%.2f) = %.2f%n",
            l,
            b,
            l * b
        );
    }

    @Override
    public void SquareArea(double s) {
        System.out.printf("Square area (s=%.2f) = %.2f%n", s, s * s);
    }

    @Override
    public void CircleArea(double r) {
        System.out.printf("Circle area (r=%.2f) = %.2f%n", r, Math.PI * r * r);
    }
}

public class AreaDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Area a = new Area();

        System.out.println("Enter 4 rectangles (length breadth):");
        for (int i = 1; i <= 4; i++) {
            double l = sc.nextDouble(),
                b = sc.nextDouble();
            a.RectangleArea(l, b);
        }

        System.out.println("Enter 4 squares (side):");
        for (int i = 1; i <= 4; i++) {
            double s = sc.nextDouble();
            a.SquareArea(s);
        }

        System.out.println("Enter 5 circles (radius):");
        for (int i = 1; i <= 5; i++) {
            double r = sc.nextDouble();
            a.CircleArea(r);
        }
    }
}
