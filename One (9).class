import java.util.*;

abstract class BankAccount {

    protected String accNo, name;
    protected double balance;

    BankAccount(String accNo, String name, double opening) {
        this.accNo = accNo;
        this.name = name;
        this.balance = opening;
    }

    public abstract void deposit(double amt);

    public abstract void withdraw(double amt);

    public void show() {
        System.out.printf("%s | %s | Balance: %.2f%n", accNo, name, balance);
    }
}

class SavingsAccount extends BankAccount {

    private static final double MIN_BAL = 500;

    SavingsAccount(String no, String nm, double op) {
        super(no, nm, Math.max(op, MIN_BAL));
    }

    public void deposit(double amt) {
        if (amt > 0) balance += amt;
        else System.out.println("Deposit must be positive.");
    }

    public void withdraw(double amt) {
        if (amt <= 0) System.out.println("Invalid amount.");
        else if (balance - amt < MIN_BAL) System.out.println(
            "Cannot go below minimum balance (" + MIN_BAL + ")."
        );
        else balance -= amt;
    }
}

class CurrentAccount extends BankAccount {

    private static final double OD_LIMIT = -1000; // overdraft allowed

    CurrentAccount(String no, String nm, double op) {
        super(no, nm, op);
    }

    public void deposit(double amt) {
        if (amt > 0) balance += amt;
        else System.out.println("Deposit must be positive.");
    }

    public void withdraw(double amt) {
        if (amt <= 0) System.out.println("Invalid amount.");
        else if (balance - amt < OD_LIMIT) System.out.println(
            "Overdraft limit exceeded."
        );
        else balance -= amt;
    }
}

public class BankAccountDemo {

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("S-1", "Alice", 800);
        CurrentAccount ca = new CurrentAccount("C-1", "Bob", 200);

        sa.show();
        ca.show();
        sa.withdraw(250); // fails (min balance)
        sa.deposit(200);
        sa.withdraw(250);
        sa.show();

        ca.withdraw(900); // within overdraft
        ca.withdraw(500); // may hit limit
        ca.deposit(1000);
        ca.show();
    }
}
