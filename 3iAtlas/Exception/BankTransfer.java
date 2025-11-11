package Exception;
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) { super(msg); }
}

class InvalidTransferAmountException extends Exception {
    public InvalidTransferAmountException(String msg) { super(msg); }
}

class Account {
    String name;
    double balance;

    public Account(String name, double balance) {
        this.name = name; this.balance = balance;
    }

    public void deposit(double amt) { balance += amt; }

    public void withdraw(double amt) throws InsufficientFundsException {
        if (amt > balance)
            throw new InsufficientFundsException("Insufficient funds in " + name);
        balance -= amt;
    }
}

public class BankTransfer {
    public static void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException, InvalidTransferAmountException {
        if (amount <= 0)
            throw new InvalidTransferAmountException("Invalid transfer amount!");

        double oldFrom = from.balance;
        double oldTo = to.balance;
        try {
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("Transfer successful: " + amount + " from " + from.name + " to " + to.name);
        } catch (InsufficientFundsException e) {
            // Rollback
            from.balance = oldFrom;
            to.balance = oldTo;
            throw e;
        }
    }

    public static void main(String[] args) {
        Account a1 = new Account("Selim", 2000);
        Account a2 = new Account("Rafi", 1000);
        try {
            transfer(a1, a2, 1500);
            transfer(a1, a2, 2000); // will fail and rollback
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Final Balances → Selim: " + a1.balance + ", Rafi: " + a2.balance);
    }
}
