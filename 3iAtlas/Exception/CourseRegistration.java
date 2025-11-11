package Exception;
import java.util.*;

class SeatFullException extends Exception {
    public SeatFullException(String msg) { super(msg); }
}
class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String msg) { super(msg); }
}

class Course {
    String code;
    int capacity;
    Set<String> registered = new HashSet<>();
    String prerequisite; // code of prerequisite or null

    public Course(String code, int capacity, String prerequisite) {
        this.code = code; this.capacity = capacity; this.prerequisite = prerequisite;
    }

    public void registerStudent(String studentId, Set<String> completedCourses) throws SeatFullException, PrerequisiteNotMetException {
        if (registered.size() >= capacity) throw new SeatFullException("Course " + code + " is full.");
        if (prerequisite != null && !completedCourses.contains(prerequisite))
            throw new PrerequisiteNotMetException("Prerequisite not met: " + prerequisite);
        registered.add(studentId);
        System.out.println(studentId + " registered for " + code);
    }
}

public class CourseRegistration {
    public static void main(String[] args) {
        Course c = new Course("CS201", 1, "CS101");
        Set<String> aliceCompleted = new HashSet<>(Arrays.asList("CS101"));
        Set<String> bobCompleted = new HashSet<>();

        try {
            c.registerStudent("Alice", aliceCompleted);
            c.registerStudent("Bob", bobCompleted); // will fail (seat full or prereq)
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

