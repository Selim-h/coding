package Exception;

class LowCreditScoreException extends Exception {
    public LowCreditScoreException(String msg) { super(msg); }
}

class InvalidLoanAmountException extends Exception {
    public InvalidLoanAmountException(String msg) { super(msg); }
}

class LoanApplication {
    double maxLoan = 100000;

    public void applyForLoan(double amount, int creditScore)
            throws LowCreditScoreException, InvalidLoanAmountException {
        if (creditScore < 600)
            throw new LowCreditScoreException("Credit score too low for loan!");
        if (amount <= 0 || amount > maxLoan)
            throw new InvalidLoanAmountException("Invalid loan amount!");
        System.out.println("Loan approved for amount: " + amount);
    }
}

public class LoanSystem {
    public static void main(String[] args) {
        LoanApplication app = new LoanApplication();
        try {
            app.applyForLoan(50000, 700);
            app.applyForLoan(120000, 750); // exceeds max
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            app.applyForLoan(20000, 500); // low score
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

