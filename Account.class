// Parent class
class Parent {

    public void parentMethod() {
        System.out.println("This is parent class");
    }
}

// Child class
class Child extends Parent {

    public void childMethod() {
        System.out.println("This is child class");
    }
}

// Main class
public class One {

    public static void main(String[] args) {
        // 1 - method of parent class by object of parent class
        Parent p = new Parent();
        p.parentMethod(); // Output: This is parent class

        // 2 - method of child class by object of child class
        Child c = new Child();
        c.childMethod(); // Output: This is child class

        // 3 - method of parent class by object of child class
        Child c2 = new Child();
        c2.parentMethod(); // Output: This is parent class
    }
}
