package Exception;

import java.util.*;

class InvalidStockException extends Exception {
    public InvalidStockException(String msg) { super(msg); }
}
class InsufficientFundsException3 extends Exception {
    public InsufficientFundsException3(String msg) { super(msg); }
}
class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String msg) { super(msg); }
}

class TradingAccount {
    double balance;
    Set<String> allowedStocks = new HashSet<>(Arrays.asList("AAPL", "GOOG", "MSFT"));

    public TradingAccount(double balance) { this.balance = balance; }

    public void buyShares(String stock, int quantity, double pricePerShare) throws InvalidStockException, InsufficientFundsException3, InvalidQuantityException {
        if (!allowedStocks.contains(stock)) throw new InvalidStockException("Stock not recognized: " + stock);
        if (quantity <= 0) throw new InvalidQuantityException("Quantity must be > 0");
        double total = pricePerShare * quantity;
        if (total > balance) throw new InsufficientFundsException3("Not enough funds. Required: " + total);
        balance -= total;
        System.out.println("Bought " + quantity + " shares of " + stock + " at " + pricePerShare + " each.");
    }
}

public class StockTrading {
    public static void main(String[] args) {
        TradingAccount acc = new TradingAccount(10000);

        try {
            acc.buyShares("AAPL", 10, 150); // 1500 ok
            acc.buyShares("TSLA", 5, 200); // invalid stock
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            acc.buyShares("GOOG", 100, 200); // insufficient funds
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

