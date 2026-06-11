// Parent class
class Parent {

    private void parentMethod() {
        // private method
        System.out.println("This is parent class");
    }

    // To allow child to call, we can create a public wrapper (optional)
    public void callParentMethod() {
        parentMethod();
    }
}

// Child class
class Child extends Parent {

    public void childMethod() {
        System.out.println("This is child class");
    }
}

// Main class
public class Two {

    public static void main(String[] args) {
        // 1 - method of parent class by object of parent class
        Parent p = new Parent();
        // p.parentMethod(); // ❌ ERROR: parentMethod() has private access
        p.callParentMethod(); // ✅ Works using public wrapper

        // 2 - method of child class by object of child class
        Child c = new Child();
        c.childMethod(); // ✅ Works
        c.callParentMethod(); // ✅ Works via public wrapper

        // 3 - method of parent class by object of child class
        // c.parentMethod();   // ❌ ERROR: parentMethod() has private access
    }
}
