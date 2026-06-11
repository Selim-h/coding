// Base class
class Person {

    private String firstName;
    private String lastName;

    // Constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to get first name
    public String getFirstName() {
        return firstName;
    }

    // Method to get last name
    public String getLastName() {
        return lastName;
    }
}

// Subclass
class Employee extends Person {

    private String employeeId;
    private String jobTitle;

    // Constructor
    public Employee(
        String firstName,
        String lastName,
        String employeeId,
        String jobTitle
    ) {
        super(firstName, lastName);
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
    }

    // New method
    public String getEmployeeId() {
        return employeeId;
    }

    // Overriding getLastName() to include job title
    @Override
    public String getLastName() {
        return super.getLastName() + " (" + jobTitle + ")";
    }
}

// Main class to test
public class Seven {

    public static void main(String[] args) {
        Person p = new Person("John", "Doe");
        System.out.println("Person First Name: " + p.getFirstName());
        System.out.println("Person Last Name: " + p.getLastName());

        Employee e = new Employee(
            "Alice",
            "Smith",
            "E123",
            "Software Engineer"
        );
        System.out.println("\nEmployee First Name: " + e.getFirstName());
        System.out.println("Employee Last Name: " + e.getLastName());
        System.out.println("Employee ID: " + e.getEmployeeId());
    }
}
