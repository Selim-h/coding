package Exception;

import java.io.*;

class FileTooLargeException extends Exception {
    public FileTooLargeException(String msg) { super(msg); }
}

class UnsupportedFileTypeException extends Exception {
    public UnsupportedFileTypeException(String msg) { super(msg); }
}

public class FileUploadSimulator {
    public static void uploadFile(String fileName, long fileSizeBytes) throws FileTooLargeException, UnsupportedFileTypeException {
        long maxSize = 100L * 1024 * 1024; // 100 MB
        if (fileSizeBytes > maxSize) throw new FileTooLargeException("File exceeds 100MB limit.");

        if (!(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".pdf"))) {
            throw new UnsupportedFileTypeException("Unsupported file type: " + fileName);
        }

        // Simulate low-level IO exception and chain it
        try {
            // pretend to write file -> simulate IOException
            if (fileName.equals("causeIOError.pdf")) throw new IOException("Simulated IO failure");
            System.out.println("File uploaded successfully: " + fileName);
        } catch (IOException ioe) {
            throw new UnsupportedFileTypeException("Upload failed due to IO: " + ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            uploadFile("image.jpg", 5 * 1024 * 1024);
            uploadFile("video.mp4", 10 * 1024 * 1024);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            uploadFile("bigfile.pdf", 200L * 1024 * 1024);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

