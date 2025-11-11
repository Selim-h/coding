package Exception;

import java.io.*;

class QuotaExceededException extends Exception {
    public QuotaExceededException(String msg) { super(msg); }
}

class InvalidFileNameException extends Exception {
    public InvalidFileNameException(String msg) { super(msg); }
}

public class CloudStorage {
    static double usedStorage = 80; // MB
    static final double quota = 100;

    public static void uploadFile(String fileName, double size)
            throws QuotaExceededException, InvalidFileNameException {
        if (fileName.contains("/") || fileName.contains("?"))
            throw new InvalidFileNameException("Invalid characters in file name!");
        if (usedStorage + size > quota)
            throw new QuotaExceededException("Storage quota exceeded!");
        usedStorage += size;
        System.out.println("Uploaded " + fileName + " (" + size + " MB)");
    }

    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("cloud.txt");
            uploadFile("report.pdf", 10);
            uploadFile("data?.csv", 5); // invalid name
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (fw != null) fw.close();
            } catch (IOException e) {
                System.out.println("Error closing file!");
            }
            System.out.println("Resources closed.");
        }
    }
}
