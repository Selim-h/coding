package Exception.MultiThread;

public class Q3_GoodMorningWelcome extends Thread {
    private String message;

    public Q3_GoodMorningWelcome(String msg) {
        message = msg;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        Q3_GoodMorningWelcome t1 = new Q3_GoodMorningWelcome("Good Morning");
        Q3_GoodMorningWelcome t2 = new Q3_GoodMorningWelcome("Welcome");
        t1.start();
        t2.start();
    }
}

