
import java.util.Scanner;

// Account class (for storing account details)
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public Account(String accNo, String name, double initialBalance) {
        accountNumber = accNo;
        accountHolder = name;
        if (initialBalance < 1) {
            System.out.println("Initial balance must be more than 0!");
            balance = 100; // default balance if invalid
        } else {
            balance = initialBalance;
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " Tk successfully.");
        } else {
            System.out.println("Deposit amount must be greater than 0!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (balance - amount <= 0) {
            System.out.println("You can’t withdraw. Balance can’t be zero or negative!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " Tk successfully.");
        }
    }

    // Show account details
    public void showInfo() {
        System.out.println("-----------------------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Current Balance: " + balance);
        System.out.println("-----------------------------");
    }

    // Get account number
    public String getAccountNumber() {
        return accountNumber;
    }
}

// Bank class (for managing multiple accounts)
class Bank {
    private Account[] accounts;
    private int totalAccounts;

    public Bank(int size) {
        accounts = new Account[size];
        totalAccounts = 0;
    }

    // Add a new account
    public void addAccount(Account acc) {
        if (totalAccounts < accounts.length) {
            accounts[totalAccounts] = acc;
            totalAccounts++;
            System.out.println("Account added successfully!");
        } else {
            System.out.println("Bank is full! Cannot add more accounts.");
        }
    }

    // Search account by number
    public Account findAccount(String accNo) {
        for (int i = 0; i < totalAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accNo)) {
                return accounts[i];
            }
        }
        return null;
    }

    // Remove account
    public void removeAccount(String accNo) {
        int index = -1;
        for (int i = 0; i < totalAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accNo)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < totalAccounts - 1; i++) {
                accounts[i] = accounts[i + 1];
            }
            accounts[totalAccounts - 1] = null;
            totalAccounts--;
            System.out.println("Account removed successfully!");
        } else {
            System.out.println("Account not found!");
        }
    }

    // Show all accounts
    public void showAllAccounts() {
        if (totalAccounts == 0) {
            System.out.println("No accounts available in the bank!");
        } else {
            for (int i = 0; i < totalAccounts; i++) {
                accounts[i].showInfo();
            }
        }
    }
}

// Main ATM menu class
public class SimpleATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank(100); // bank can store 100 accounts

        while (true) {
            System.out.println("\n========== ATM Menu ==========");
            System.out.println("1. Add New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Show Account Details");
            System.out.println("5. Remove Account");
            System.out.println("6. Show All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Account Number: ");
                String accNo = sc.next();
                System.out.print("Enter Account Holder Name: ");
                sc.nextLine(); // clear buffer
                String name = sc.nextLine();
                System.out.print("Enter Initial Balance: ");
                double balance = sc.nextDouble();

                Account acc = new Account(accNo, name, balance);
                bank.addAccount(acc);
            }

            else if (choice == 2) {
                System.out.print("Enter Account Number: ");
                String accNo = sc.next();
                Account acc = bank.findAccount(accNo);
                if (acc != null) {
                    System.out.print("Enter amount to deposit: ");
                    double amt = sc.nextDouble();
                    acc.deposit(amt);
                } else {
                    System.out.println("Account not found!");
                }
            }

            else if (choice == 3) {
                System.out.print("Enter Account Number: ");
                String accNo = sc.next();
                Account acc = bank.findAccount(accNo);
                if (acc != null) {
                    System.out.print("Enter amount to withdraw: ");
                    double amt = sc.nextDouble();
                    acc.withdraw(amt);
                } else {
                    System.out.println("Account not found!");
                }
            }

            else if (choice == 4) {
                System.out.print("Enter Account Number: ");
                String accNo = sc.next();
                Account acc = bank.findAccount(accNo);
                if (acc != null) {
                    acc.showInfo();
                } else {
                    System.out.println("Account not found!");
                }
            }

            else if (choice == 5) {
                System.out.print("Enter Account Number to remove: ");
                String accNo = sc.next();
                bank.removeAccount(accNo);
            }

            else if (choice == 6) {
                bank.showAllAccounts();
            }

            else if (choice == 7) {
                System.out.println("Thank you for using our ATM!");
                break;
            }

            else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
        sc.close();
    }
}
