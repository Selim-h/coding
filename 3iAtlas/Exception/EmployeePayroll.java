package Exception;

import java.util.Scanner;

class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String msg) {
        super(msg);
    }
}

class InvalidTaxRateException extends Exception {
    public InvalidTaxRateException(String msg) {
        super(msg);
    }
}

public class EmployeePayroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            System.out.print("Enter tax rate (%): ");
            double tax = sc.nextDouble();

            if (salary < 0)
                throw new InvalidSalaryException("Salary cannot be negative.");
            if (tax < 0 || tax > 100)
                throw new InvalidTaxRateException("Tax rate must be between 0–100.");

            double netSalary = salary - (salary * tax / 100);
            System.out.println("Net Salary: " + netSalary);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

