package Exception;

class AuthenticationException extends Exception {
    public AuthenticationException(String msg) { super(msg); }
}

class InvalidAccountException extends Exception {
    public InvalidAccountException(String msg) { super(msg); }
}

class TransactionFailedException extends Exception {
    public TransactionFailedException(String msg) { super(msg); }
}

class OnlineBanking {
    void authenticateUser(String username, String password) throws AuthenticationException {
        if (!username.equals("Selim") || !password.equals("1234"))
            throw new AuthenticationException("Invalid login credentials!");
    }

    void validateAccount(String account) throws InvalidAccountException {
        if (!account.equals("ACC1001"))
            throw new InvalidAccountException("Account not found!");
    }

    void processTransaction(double amount) throws TransactionFailedException {
        if (amount <= 0)
            throw new TransactionFailedException("Invalid transaction amount!");
        System.out.println("Transaction successful! Amount: " + amount);
    }

    void performTransaction(String user, String pass, String acc, double amount)
            throws AuthenticationException, InvalidAccountException, TransactionFailedException {
        authenticateUser(user, pass);
        validateAccount(acc);
        processTransaction(amount);
    }
}

public class OnlineBank {
    public static void main(String[] args) {
        OnlineBanking ob = new OnlineBanking();
        try {
            ob.performTransaction("Selim", "1234", "ACC1001", 500);
            ob.performTransaction("Selim", "wrong", "ACC1001", 300);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

