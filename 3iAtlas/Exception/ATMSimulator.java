package Exception;

class InvalidDenominationException extends Exception {
    public InvalidDenominationException(String msg) { super(msg); }
}

class InsufficientFundsException2 extends Exception {
    public InsufficientFundsException2(String msg) { super(msg); }
}

public class ATMSimulator {
    double balance = 5000.0;

    public void withdraw(double amount) throws InvalidDenominationException, InsufficientFundsException2 {
        if (amount <= 0 || amount % 500 != 0) throw new InvalidDenominationException("Withdrawals only in multiples of 500.");
        if (amount > balance) throw new InsufficientFundsException2("Insufficient funds.");
        balance -= amount;
        System.out.println("Please collect your cash: " + amount);
    }

    public static void main(String[] args) {
        ATMSimulator atm = new ATMSimulator();
        try {
            atm.withdraw(1250); // invalid denom
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using our service.");
        }

        try {
            atm.withdraw(6000); // insufficient funds
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Thank you for using our service.");
        }
    }
}
