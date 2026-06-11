// Point class to represent a coordinate
class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

// Base class Quadrilateral
class Quadrilateral {

    private Point p1, p2, p3, p4; // Four vertices

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    // Getters for points (protected for subclasses)
    protected Point getP1() {
        return p1;
    }

    protected Point getP2() {
        return p2;
    }

    protected Point getP3() {
        return p3;
    }

    protected Point getP4() {
        return p4;
    }
}

// Trapezoid class inherits Quadrilateral
class Trapezoid extends Quadrilateral {

    public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    // Area = 1/2 * (sum of parallel sides) * height
    // Assuming p1-p2 and p3-p4 are parallel sides, height = distance between lines
    public double area() {
        double a = distance(getP1(), getP2());
        double b = distance(getP3(), getP4());
        double height = Math.abs(getP1().getY() - getP3().getY());
        return 0.5 * (a + b) * height;
    }

    private double distance(Point p1, Point p2) {
        return Math.hypot(p2.getX() - p1.getX(), p2.getY() - p1.getY());
    }
}

// Parallelogram class inherits Trapezoid
class Parallelogram extends Trapezoid {

    public Parallelogram(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    public double area() {
        double base = distance(getP1(), getP2());
        double height = Math.abs(getP1().getY() - getP3().getY());
        return base * height;
    }

    private double distance(Point p1, Point p2) {
        return Math.hypot(p2.getX() - p1.getX(), p2.getY() - p1.getY());
    }
}

// Rectangle class inherits Parallelogram
class Rectangle extends Parallelogram {

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    public double area() {
        double length = distance(getP1(), getP2());
        double breadth = distance(getP2(), getP3());
        return length * breadth;
    }

    private double distance(Point p1, Point p2) {
        return Math.hypot(p2.getX() - p1.getX(), p2.getY() - p1.getY());
    }
}

// Square class inherits Rectangle
class Square extends Rectangle {

    public Square(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    @Override
    public double area() {
        double side = distance(getP1(), getP2());
        return side * side;
    }

    private double distance(Point p1, Point p2) {
        return Math.hypot(p2.getX() - p1.getX(), p2.getY() - p1.getY());
    }
}

// Main class to test
public class Seven {

    public static void main(String[] args) {
        // Example points for shapes
        Point q1 = new Point(0, 0);
        Point q2 = new Point(4, 0);
        Point q3 = new Point(3, 3);
        Point q4 = new Point(-1, 3);

        Trapezoid trap = new Trapezoid(q1, q2, q3, q4);
        System.out.println("Trapezoid area: " + trap.area());

        Point p1 = new Point(0, 0);
        Point p2 = new Point(5, 0);
        Point p3 = new Point(6, 3);
        Point p4 = new Point(1, 3);

        Parallelogram para = new Parallelogram(p1, p2, p3, p4);
        System.out.println("Parallelogram area: " + para.area());

        Point r1 = new Point(0, 0);
        Point r2 = new Point(6, 0);
        Point r3 = new Point(6, 4);
        Point r4 = new Point(0, 4);

        Rectangle rect = new Rectangle(r1, r2, r3, r4);
        System.out.println("Rectangle area: " + rect.area());

        Point s1 = new Point(0, 0);
        Point s2 = new Point(4, 0);
        Point s3 = new Point(4, 4);
        Point s4 = new Point(0, 4);

        Square sq = new Square(s1, s2, s3, s4);
        System.out.println("Square area: " + sq.area());
    }
}
