// Base class
class Employee {

    protected String name;
    protected String address;
    protected double salary;
    protected String jobTitle;

    // Constructor
    public Employee(
        String name,
        String address,
        double salary,
        String jobTitle
    ) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    // Calculate bonus (default: 10% of salary)
    public double calculateBonus() {
        return salary * 0.10;
    }

    // Generate performance report
    public void performanceReport() {
        System.out.println(
            "Performance report for " + name + " (" + jobTitle + ")"
        );
    }

    // Manage projects (default: simple message)
    public void manageProject() {
        System.out.println(name + " is managing general tasks.");
    }

    // Display basic info
    public void displayInfo() {
        System.out.println(
            "Name: " +
                name +
                ", Address: " +
                address +
                ", Job Title: " +
                jobTitle +
                ", Salary: $" +
                salary
        );
    }
}

// Subclass Manager
class Manager extends Employee {

    public Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.20; // Managers get 20% bonus
    }

    @Override
    public void performanceReport() {
        System.out.println(
            "Manager " +
                name +
                " oversees team performance and reports to executives."
        );
    }

    @Override
    public void manageProject() {
        System.out.println(
            "Manager " + name + " is managing multiple projects."
        );
    }
}

// Subclass Developer
class Developer extends Employee {

    public Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.15; // Developers get 15% bonus
    }

    @Override
    public void performanceReport() {
        System.out.println(
            "Developer " + name + " submits code quality and project reports."
        );
    }

    @Override
    public void manageProject() {
        System.out.println(
            "Developer " +
                name +
                " manages code development for assigned projects."
        );
    }
}

// Subclass Programmer
class Programmer extends Employee {

    public Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.12; // Programmers get 12% bonus
    }

    @Override
    public void performanceReport() {
        System.out.println(
            "Programmer " + name + " reports progress on tasks and debugging."
        );
    }

    @Override
    public void manageProject() {
        System.out.println(
            "Programmer " + name + " focuses on coding and implementation."
        );
    }
}

// Main class to test
public class Ten {

    public static void main(String[] args) {
        Manager manager = new Manager("Alice", "123 Main St", 8000);
        Developer developer = new Developer("Bob", "456 Oak St", 6000);
        Programmer programmer = new Programmer("Charlie", "789 Pine St", 5000);

        // Display info and actions
        manager.displayInfo();
        System.out.println("Bonus: $" + manager.calculateBonus());
        manager.performanceReport();
        manager.manageProject();
        System.out.println();

        developer.displayInfo();
        System.out.println("Bonus: $" + developer.calculateBonus());
        developer.performanceReport();
        developer.manageProject();
        System.out.println();

        programmer.displayInfo();
        System.out.println("Bonus: $" + programmer.calculateBonus());
        programmer.performanceReport();
        programmer.manageProject();
    }
}
