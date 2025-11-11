package Exception;

import java.io.*;

class TransactionLogNotFoundException extends Exception {
    public TransactionLogNotFoundException(String msg) { super(msg); }
}

class CorruptedDataException extends Exception {
    public CorruptedDataException(String msg) { super(msg); }
}

public class TransactionLogger {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            File f = new File("transactions.txt");
            if (!f.exists()) throw new TransactionLogNotFoundException("Transaction log file missing!");
            br = new BufferedReader(new FileReader(f));
            String data = br.readLine();
            if (data == null || !data.contains("TXN")) throw new CorruptedDataException("Data corrupted!");
            System.out.println("Transaction log read successfully: " + data);
        } catch (TransactionLogNotFoundException | CorruptedDataException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error closing file!");
            }
            System.out.println("File resources closed.");
        }
    }
}

