package Exception;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient balance for withdrawal!");
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Remaining: " + balance);
    }
}

public class BankTransaction {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);

        try {
            account.withdraw(2000);
            account.withdraw(4000); // this will throw exception
        } catch (InsufficientBalanceException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
    }
}

