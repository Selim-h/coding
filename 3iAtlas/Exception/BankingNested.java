package Exception;

import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) { super(msg); }
}

public class BankingNested {
    double balance = 1000.0;

    public void deposit(double amt) throws IllegalArgumentException {
        if (amt < 0) throw new IllegalArgumentException("Cannot deposit negative amount");
        balance += amt;
    }

    public void withdraw(double amt) throws InsufficientBalanceException {
        if (amt > balance) throw new InsufficientBalanceException("Insufficient balance");
        balance -= amt;
    }

    public static void main(String[] args) {
        BankingNested bank = new BankingNested();
        try {
            // Outer try: invalid transaction type
            try {
                bank.deposit(-500); // illegal -> outer will catch
            } catch (IllegalArgumentException e) {
                System.out.println("Outer catch: " + e.getMessage());
            }

            // Inner try: withdrawal may throw InsufficientBalanceException
            try {
                bank.withdraw(2000); // will throw
            } catch (InsufficientBalanceException e) {
                System.out.println("Inner catch: " + e.getMessage());
            }
        } finally {
            System.out.println("Final balance: " + bank.balance);
        }
    }
}

