package Exception;

import java.util.*;
import java.util.regex.*;

class DuplicateIDException extends Exception {
    public DuplicateIDException(String msg) { super(msg); }
}

class InvalidEmailException extends Exception {
    public InvalidEmailException(String msg) { super(msg); }
}

class Student {
    String id;
    String email;

    public Student(String id, String email) {
        this.id = id; this.email = email;
    }
}

public class StudentRegistration {
    private static Set<String> registeredIds = new HashSet<>();
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    public static void registerStudent(Student s) throws DuplicateIDException, InvalidEmailException {
        if (registeredIds.contains(s.id)) throw new DuplicateIDException("ID already exists: " + s.id);
        if (!EMAIL_PATTERN.matcher(s.email).matches()) throw new InvalidEmailException("Invalid email: " + s.email);

        registeredIds.add(s.id);
        System.out.println("Registered student: " + s.id + " (" + s.email + ")");
    }

    public static void main(String[] args) {
        try {
            registerStudent(new Student("S001", "alice@example.com"));
            registerStudent(new Student("S002", "bob@domain")); // invalid email
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            registerStudent(new Student("S001", "charlie@example.com")); // duplicate ID
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

