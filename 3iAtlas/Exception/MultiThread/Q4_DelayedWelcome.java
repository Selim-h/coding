package Exception.MultiThread;

public class Q4_DelayedWelcome extends Thread {
    private String message;
    private int delay;

    public Q4_DelayedWelcome(String msg, int delay) {
        message = msg;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Q4_DelayedWelcome t1 = new Q4_DelayedWelcome("Good Morning", 0);
        Q4_DelayedWelcome t2 = new Q4_DelayedWelcome("Welcome", 200);
        t1.start();
        t2.start();
    }
}

