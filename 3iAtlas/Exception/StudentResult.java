package Exception;

import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String msg) {
        super(msg);
    }
}

public class StudentResult {
    static void checkMarks(int[] marks) throws InvalidMarksException {
        for (int m : marks) {
            if (m < 0 || m > 100)
                throw new InvalidMarksException("Invalid marks: " + m);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[3];

        System.out.println("Enter marks for 3 subjects:");
        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }

        try {
            checkMarks(marks);
            double avg = (marks[0] + marks[1] + marks[2]) / 3.0;
            System.out.println("Average Marks: " + avg);
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

