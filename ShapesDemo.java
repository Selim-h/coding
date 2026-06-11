// Base class
class Member {

    String name;
    int age;
    String phoneNumber;
    String address;
    double salary;

    // Method to print salary
    public void printSalary() {
        System.out.println("Salary: $" + salary);
    }
}

// Employee class inherits Member
class Employee extends Member {

    String specialization;
}

// Manager class inherits Member
class Manager extends Member {

    String department;
}

// Main class
public class Three {

    public static void main(String[] args) {
        // Create Employee object
        Employee emp = new Employee();
        emp.name = "Alice";
        emp.age = 28;
        emp.phoneNumber = "123-456-7890";
        emp.address = "123 Elm Street";
        emp.salary = 5000;
        emp.specialization = "Software Development";

        // Create Manager object
        Manager mgr = new Manager();
        mgr.name = "Bob";
        mgr.age = 35;
        mgr.phoneNumber = "987-654-3210";
        mgr.address = "456 Oak Avenue";
        mgr.salary = 8000;
        mgr.department = "IT";

        // Print Employee details
        System.out.println("Employee Details:");
        System.out.println("Name: " + emp.name);
        System.out.println("Age: " + emp.age);
        System.out.println("Phone Number: " + emp.phoneNumber);
        System.out.println("Address: " + emp.address);
        System.out.println("Specialization: " + emp.specialization);
        emp.printSalary();

        System.out.println();

        // Print Manager details
        System.out.println("Manager Details:");
        System.out.println("Name: " + mgr.name);
        System.out.println("Age: " + mgr.age);
        System.out.println("Phone Number: " + mgr.phoneNumber);
        System.out.println("Address: " + mgr.address);
        System.out.println("Department: " + mgr.department);
        mgr.printSalary();
    }
}
