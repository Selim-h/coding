package Exception.MultiThread;

public class Q2_SumThreads extends Thread {
    public void run() {
        int sum = 0;
        for (int x = 0; x < 10; x++) {
            sum += x;
            System.out.println("Thread: " + getName() + " - Value: " + sum);
        }
        System.out.println("Thread: " + getName() + " - Final Sum: " + sum);
    }

    public static void main(String[] args) {
        Q2_SumThreads t1 = new Q2_SumThreads();
        Q2_SumThreads t2 = new Q2_SumThreads();
        Q2_SumThreads t3 = new Q2_SumThreads();
        t1.setName("A");
        t2.setName("B");
        t3.setName("C");
        t1.start(); t2.start(); t3.start();
    }
}

