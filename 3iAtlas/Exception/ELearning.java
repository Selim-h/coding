package Exception;

import java.io.*;
import java.util.*;

class DuplicateEnrollmentException extends Exception {
    public DuplicateEnrollmentException(String msg) { super(msg); }
}

class InvalidCourseException extends Exception {
    public InvalidCourseException(String msg) { super(msg); }
}

class EPlatform {
    Set<String> availableCourses = new HashSet<>(Arrays.asList("Java", "Python", "AI"));
    Map<String, Set<String>> studentCourses = new HashMap<>();

    public void enroll(String student, String course)
            throws DuplicateEnrollmentException, InvalidCourseException, IOException {
        if (!availableCourses.contains(course)) throw new InvalidCourseException("Invalid course: " + course);

        studentCourses.putIfAbsent(student, new HashSet<>());
        if (studentCourses.get(student).contains(course))
            throw new DuplicateEnrollmentException("Already enrolled in " + course);

        studentCourses.get(student).add(course);

        try (FileWriter fw = new FileWriter("enrollments.txt", true)) {
            fw.write(student + " -> " + course + "\n");
        }
        System.out.println(student + " enrolled in " + course);
    }
}

public class ELearning {
    public static void main(String[] args) {
        EPlatform ep = new EPlatform();
        try {
            ep.enroll("Selim", "Java");
            ep.enroll("Selim", "Java"); // duplicate
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            ep.enroll("Selim", "C++"); // invalid course
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

