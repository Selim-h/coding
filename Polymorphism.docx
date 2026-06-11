import java.util.*;

class Student {

    private String student_id;
    private String student_name;
    private ArrayList<Integer> grades = new ArrayList<>();

    // getters & setters
    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String id) {
        this.student_id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String name) {
        this.student_name = name;
    }

    public List<Integer> getGrades() {
        return Collections.unmodifiableList(grades);
    }

    // addGrade with validation (0..100)
    public boolean addGrade(int g) {
        if (g < 0 || g > 100) {
            System.out.println("Grade must be between 0 and 100.");
            return false;
        }
        grades.add(g);
        return true;
    }

    public double average() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int x : grades) sum += x;
        return (sum * 1.0) / grades.size();
    }

    public void show() {
        System.out.println(
            student_id +
                " | " +
                student_name +
                " | Grades: " +
                grades +
                " | Avg: " +
                String.format("%.2f", average())
        );
    }
}

public class StudentDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        System.out.print("Enter ID: ");
        s.setStudent_id(sc.nextLine());
        System.out.print("Enter Name: ");
        s.setStudent_name(sc.nextLine());

        System.out.println("Enter grades (end with -1):");
        while (true) {
            int g = sc.nextInt();
            if (g == -1) break;
            s.addGrade(g);
        }

        s.show();
    }
}
