package Exception.MultiThread;

public class Q5_MaxDivisorThreads extends Thread {
    int start, end;
    int maxDivisors = 0;
    int number = 0;

    public Q5_MaxDivisorThreads(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0)
                    count++;
            }
            if (count > maxDivisors) {
                maxDivisors = count;
                number = i;
            }
        }
        System.out.println("Thread " + getName() + " done. Max divisors: " +
                maxDivisors + " at number: " + number);
    }

    public int getMaxDivisors() { return maxDivisors; }
    public int getNumber() { return number; }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Q5_MaxDivisorThreads t1 = new Q5_MaxDivisorThreads(1, 25000);
        Q5_MaxDivisorThreads t2 = new Q5_MaxDivisorThreads(25001, 50000);
        Q5_MaxDivisorThreads t3 = new Q5_MaxDivisorThreads(50001, 75000);
        Q5_MaxDivisorThreads t4 = new Q5_MaxDivisorThreads(75001, 100000);

        t1.setName("T1"); t2.setName("T2"); t3.setName("T3"); t4.setName("T4");
        t1.start(); t2.start(); t3.start(); t4.start();

        try { t1.join(); t2.join(); t3.join(); t4.join(); } catch (InterruptedException e) {}

        Q5_MaxDivisorThreads[] arr = {t1, t2, t3, t4};
        int overallMax = 0, number = 0;
        for (Q5_MaxDivisorThreads t : arr) {
            if (t.getMaxDivisors() > overallMax) {
                overallMax = t.getMaxDivisors();
                number = t.getNumber();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("\nNumber with most divisors: " + number);
        System.out.println("Total divisors: " + overallMax);
        System.out.println("Elapsed time: " + (endTime - startTime) + " ms");
    }
}
