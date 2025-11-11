package Exception;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class MultiThreadedAvg {
    static class ReaderThread extends Thread {
        private List<Integer> list;
        private String filename;

        public ReaderThread(List<Integer> list, String filename) {
            this.list = list;
            this.filename = filename;
        }

        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    list.add(Integer.parseInt(line.trim())); // may throw NumberFormatException
                }
                System.out.println("ReaderThread: Finished reading file.");
            } catch (FileNotFoundException e) {
                System.out.println("ReaderThread Error: File not found.");
                // Optionally rethrow as unchecked to be caught by UncaughtExceptionHandler
                throw new RuntimeException(e);
            } catch (IOException e) {
                System.out.println("ReaderThread IO Error: " + e.getMessage());
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                System.out.println("ReaderThread Error: Invalid number in file.");
                throw new RuntimeException(e);
            }
        }
    }

    static class AveragerThread extends Thread {
        private List<Integer> list;
        public AveragerThread(List<Integer> list) { this.list = list; }
        public void run() {
            try {
                // Wait a bit for reader to fill (in real code use wait/notify or CountDownLatch)
                Thread.sleep(500);
                if (list.isEmpty()) {
                    System.out.println("AveragerThread: No numbers to average.");
                    return;
                }
                double sum = 0;
                for (int n : list) sum += n;
                System.out.println("AveragerThread: Average = " + (sum / list.size()));
            } catch (InterruptedException e) {
                System.out.println("AveragerThread interrupted.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> sharedList = Collections.synchronizedList(new ArrayList<>());
        ReaderThread reader = new ReaderThread(sharedList, "numbers.txt");
        AveragerThread avg = new AveragerThread(sharedList);

        // Uncaught exception handler
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("Uncaught exception in thread " + t.getName() + ": " + e.getCause());
        });

        reader.start();
        avg.start();

        reader.join();
        avg.join();

        System.out.println("Main: Done.");
    }
}

