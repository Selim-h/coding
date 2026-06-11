// Base class
class BankAccount {

    protected double balance;

    // Constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
        System.out.println(
            "Deposited: $" + amount + ", New balance: $" + balance
        );
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(
                "Withdrawn: $" + amount + ", Remaining balance: $" + balance
            );
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    // Get balance
    public double getBalance() {
        return balance;
    }
}

// Subclass
class SavingsAccount extends BankAccount {

    public SavingsAccount(double balance) {
        super(balance);
    }

    // Override withdraw method
    @Override
    public void withdraw(double amount) {
        if (balance - amount < 100) {
            System.out.println(
                "Withdrawal denied! Balance cannot fall below $100."
            );
        } else {
            balance -= amount;
            System.out.println(
                "Withdrawn: $" + amount + ", Remaining balance: $" + balance
            );
        }
    }
}

// Runner class
public class Five {

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(500);

        sa.deposit(200); // deposit money
        sa.withdraw(550); // valid withdrawal
        sa.withdraw(50); // denied because balance < 100
    }
}
