// Question 1: Polymorphism using Inheritance

class Shape {
    void show() {
        System.out.println("This is a generic shape.");
    }

    void getInfo() {
        System.out.println("This method belongs to the Shape class.");
    }
}

class Circle extends Shape {
    @Override
    void show() {
        System.out.println("This is a Circle.");
    }
}

class Rectangle extends Shape {
    @Override
    void show() {
        System.out.println("This is a Rectangle.");
    }
}

public class CirRec {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        // Demonstrate polymorphism
        s1.show();
        s2.show();

        // Demonstrate that getInfo() is inherited, not overridden
        s1.getInfo();
        s2.getInfo();
    }
}
