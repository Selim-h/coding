import java.util.*;

class Account {

    private String accNo;
    private String name;
    private double balance;

    Account(String accNo, String name, double bal) {
        this.accNo = accNo;
        this.name = name;
        if (bal > 0) this.balance = bal;
        else {
            System.out.println("Opening balance must be positive! Set to 1.");
            this.balance = 1;
        }
    }

    public String getAccNo() {
        return accNo;
    }

    public void deposit(double amt) {
        if (amt > 0) balance += amt;
        else System.out.println("❌ Deposit must be positive!");
    }

    public void withdraw(double amt) {
        if (amt <= 0) System.out.println("❌ Invalid amount!");
        else if (balance - amt <= 0) System.out.println("Not enough balance");
        else balance -= amt;
    }

    public void show() {
        System.out.println(accNo + " | " + name + " | Balance: " + balance);
    }
}

class Bank {

    private Account[] accs = new Account[100];
    private int count = 0;

    public void addAccount(Account a) {
        accs[count++] = a;
        System.out.println("✅ Account created!");
    }

    public Account findAccount(String accNo) {
        for (int i = 0; i < count; i++) {
            if (accs[i].getAccNo().equals(accNo)) return accs[i];
        }
        return null;
    }

    public void removeAccount(String accNo) {
        for (int i = 0; i < count; i++) {
            if (accs[i].getAccNo().equals(accNo)) {
                accs[i] = accs[count - 1];
                accs[count - 1] = null;
                count--;
                System.out.println("✅ Account removed!");
                return;
            }
        }
        System.out.println("❌ Account not found!");
    }

    public void showAll() {
        if (count == 0) System.out.println("No accounts yet!");
        else {
            for (int i = 0; i < count; i++) accs[i].show();
        }
    }
}

public class a4Bank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n=== ATM MENU ===");
            System.out.println(
                "1.Add  2.Remove  3.Deposit  4.Withdraw  5.Show All  0.Exit"
            );
            System.out.print("Choose: ");
            int ch = sc.nextInt();

            if (ch == 0) break;

            switch (ch) {
                case 1 -> {
                    System.out.print("Acc No: ");
                    String id = sc.next();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Opening Balance (>0): ");
                    double bal = sc.nextDouble();
                    bank.addAccount(new Account(id, name, bal));
                }
                case 2 -> {
                    System.out.print("Acc No: ");
                    bank.removeAccount(sc.next());
                }
                case 3 -> {
                    System.out.print("Acc No: ");
                    String id = sc.next();
                    Account a = bank.findAccount(id);
                    if (a != null) {
                        System.out.print("Amount: ");
                        a.deposit(sc.nextDouble());
                    } else System.out.println("❌ Not found!");
                }
                case 4 -> {
                    System.out.print("Acc No: ");
                    String id = sc.next();
                    Account a = bank.findAccount(id);
                    if (a != null) {
                        System.out.print("Amount: ");
                        a.withdraw(sc.nextDouble());
                    } else System.out.println("❌ Not found!");
                }
                case 5 -> bank.showAll();
                default -> System.out.println("Invalid choice!");
            }
        }

        System.out.println("👋 Thank you for using the ATM!");
    }
}
